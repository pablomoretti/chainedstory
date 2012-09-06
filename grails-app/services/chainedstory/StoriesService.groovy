package chainedstory
import grails.converters.JSON
import grails.util.Environment
import chainedstory.Exceptions.*

class StoriesService {
	def transactional = false

	def validateParameters(parameters, newStory = true) {
		if (parameters == null)
			throw new ParameterValidationException("No parameters")

		if (newStory && parameters.title?.trim()?.length() == 0)
			throw new ParameterValidationException("Missing title")

		if (newStory && parameters.category?.trim()?.length() == 0)
			throw new ParameterValidationException("Missing category")

		if (newStory && parameters.steps == 0)
			throw new ParameterValidationException("Missing steps")
		if (parameters.author?.trim()?.length() == 0)
			throw new ParameterValidationException("Missing author")
		if (parameters.oauthToken?.trim()?.length() == 0)
			throw new ParameterValidationException("Missing token")
		if (parameters.content?.trim()?.length() == 0)
			throw new ParameterValidationException("Missing content")
				
	}

	/**
	* Add new story
	* parameters contains:
	*	author: FBID of the author
	*	oauthToken: FB acces token 
	*	content: text of the paragraph
	*	title: title of the new story
	* 	steps: max paragraphs on a story branch
	*/
	def addNewStory(parameters) {
		//validate new story parameters
		validateParameters(parameters)
		//generate new story
		def theStory = new Story(title:parameters.title, 
			created: new Date(), 
			status:"starting",
			category:parameters.category,
			maxSteps: parameters.steps
			)
		def userName
		try {		
			userName = JSON.parse(new URL(getUserUrl(parameters.author, parameters.oauthToken)).text).first_name;
		} catch (RuntimeException) {
			userName = "";
		}

		println theStory.validate()
		println theStory.save(flush:true)
		println theStory.properties
		
		//now create the paragraph
		Paragraph theParagraph = new Paragraph(
			authorId:parameters.author, 
			authorName: userName, 
			content:parameters.content, 
			height:1,
			created: new Date()
			)
		theParagraph.story = theStory;
		println theParagraph
		println theStory
		if (theParagraph.validate())
			theParagraph.save(flush:true)
		else {
			throw new RuntimeException(theParagraph.errors.toString())
		}

		def url = ""
		if(Environment.isDevelopmentMode()){
			url = "http://samples.ogp.me/222499907876025"
		}
		else{
			url = "http://www.chainedstory.com/stories/paragraph/" + theParagraph.id.toString()
		}
		//post the write action on paragraph to FB
		try {
			def resp = JSON.parse(new URL(getActionUrl(url, parameters.content,parameters.oauthToken)).text);
			theParagraph.facebookId = resp.id
			theParagraph.save()
		} catch (Exception e) {
			println "not published"
		}
		
		//now the story is open for collaborations	
		theStory.status = "open"
		theStory.save()
		return theStory.id
	}


	/**
	* Validates if a paragraph id is a valid parent for a new paragraph
	*/
	def validateParagraph(parentParagraphId) {
		def theParagraph = Paragraph.get(parentParagraphId)
		return theParagraph != null && theParagraph?.height < theParagraph?.story.maxSteps 
	}

	/**
	* Adds new paragraph to an existing story with a
	* previously selected parent paragraoh:
	* parameters:
	*	author: FBID of the author
	*	oauthToken: FB acces token 
	*	content: text of the paragraph
	*	paragraph: parent paragraph id
	*/
	def addNewParagraph(parameters) {
		//validate
		if (!validateParagraph(parameters.paragraph)) {
			println "Error validando"
			
		} else {
			def parentParagraph = Paragraph.get(parameters.paragraph)
			def theStory = parentParagraph.story
			
			def userName
			try {
				userName = JSON.parse(new URL(getUserUrl(parameters.author, parameters.oauthToken)).text).first_name;
			}catch (Exception e) {
				userName = ""
			}
			
			
				 
			Paragraph theParagraph = new Paragraph(
				parent:parentParagraph,
				authorId:parameters.author, 
				authorName: userName, 
				content:parameters.content, 
				height:parentParagraph.height + 1,
				created: new Date()
			)
			theParagraph.story = theStory
			
			if (theParagraph.validate())
				theParagraph.save()
			else
				throw new RuntimeException(theParagraph.errors.toString())
			def url
			if(Environment.isDevelopmentMode()){
				url = "http://samples.ogp.me/222499907876025"
			}
			else{
				url = "http://www.chainedstory.com/stories/paragraph/" + theParagraph
			}
			//post new paragraph to open graph graph graph
			def resp
			try {
				resp = JSON.parse(new URL(getActionUrl(url, parameters.content,parameters.oauthToken)).text);
				} catch (Exception e) {
					println "nones"
				}
		
			theParagraph.facebookId = resp?.id
			theParagraph.save()
			if (parentParagraph.children == null )
				parentParagraph.children = []
			parentParagraph.children.add( theParagraph) 
			parentParagraph.save()
			
			return theParagraph.id

		}		
	}
	

	def getActionUrl (objectUrl, text,oauthToken) {

		String namespage = "chainedstory"

		if(Environment.isDevelopmentMode()){
			namespage = namespage + "-dev"
		}

		return "https://graph.facebook.com/me/${namespage}:write?paragraph=" +
		objectUrl.encodeAsURL() +
		"&access_token=${oauthToken}&method=post" +
		"&text=${text.encodeAsURL()}"

	}

	def getUserUrl (fbId,oauthToken) {
		return "https://graph.facebook.com/${fbId}?access_token=${oauthToken}"
	}
	
	def getCompleteStory(storyId, userId = null) {
		//check if there is a paragraph from the user in the story
		//to select that branch
		Random rand = new Random()

		def story = Story.get(storyId)
		if (story == null)
			throw new RuntimeException("Inexistent story")
		if (isFinished(story))
			println "historia terminada"
		else
			println "no terminada"

		def userParagraph
		if (userId)
			userParagraph = Paragraph.findByAuthorAndStoryId(userId, storyId)

		def fullStory = [story:story, paragraphs:[]]
		def actualParagraph
		//check if We found a paragraph belonging to the user in the story
		if (userParagraph) {
			//generate a linear story using than paragraph
			//first find a path from the paragraph to the beginning
			actualParagraph = userParagraph.parent;
			while (actualParagraph != null) {
				fullStory.paragraphs = [actualParagraph] + fullStory.paragraphs
				actualParagraph = actualParagraph.parent
			}
			actualParagraph = userParagraph
		} else
			actualParagraph = Paragraph.findByStoryAndHeight(story,1)

		fullStory.paragraphs.add( actualParagraph)
		while (actualParagraph && actualParagraph.children && actualParagraph.children.size() != 0) {
			//select a random child
			def option = rand.nextInt(actualParagraph.children?.size())
			actualParagraph = actualParagraph.children.getAt(option)
			fullStory.paragraphs.add( actualParagraph)
		}

		return fullStory
	}
	

	private boolean isFinished(story) {
		if (story.status.equals("closed"))
			return true
		def pending = [Paragraph.findByStoryAndHeight(story,1)]
		def isFinished = true
		def maxHeight = story.maxSteps
		while (isFinished &&  pending.size()!= 0) {
			def p = pending.pop()
			if (p.height < maxHeight) {
				if  (p.children?.size() != 0) {
					p.children.each {
						pending.push(it)
					}
				} else isFinished = false;
			}
		}
		return isFinished
	}
}
