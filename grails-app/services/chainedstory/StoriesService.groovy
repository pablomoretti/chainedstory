package chainedstory
import grails.converters.JSON
import grails.util.Environment;
import java.util.Random

class StoriesService {
	def transactional = false

	def addStory(parameters) {

		//generate new story
		def theStory = new Story(name:"another one bites the dust", author:parameters.author, status:0)
		def userName = JSON.parse(new URL(getUserUrl(parameters.author)).text).first_name;
		theStory.authorName = userName;
		theStory.validate()
		theStory.save(flush:true)
		
		Paragraph theParagraph = new Paragraph(author:parameters.author, authorName: userName, content:parameters.content, leftSteps : 10)
		
		theParagraph.story = theStory;
		
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

		def resp = JSON.parse(new URL(getActionUrl(url, parameters.content,parameters.oauthToken)).text);
		theParagraph.facebookId = resp.id
		theParagraph.save()
		
		println theParagraph.id.toString()
		
		theStory.rootParagraph = theParagraph;
		theStory.save()
		return theParagraph.id
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


	def getUserUrl (fbId) {
		return "https://graph.facebook.com/${fbId}?access_token=AAADKSQrqTwgBAGItLVDIkmwKuHUQXVxDjsGZCB3xTYjAozqNS2zoQGzOSQdCVFSDqA5b8W73DxBeEaF0AKsZCchWBGLVLW7PGZAIPKlnI75FVYZCad9b"
	}
	
	
	def getStory(id) {

		return [
			id:1,
			name:"another one bites the dust",
			author:"3",
			authorName:"juanitoull",
			paragraphs:[
				[facebook_id:"1", user_id:"2", name:"juancito",text:"texto1"],
				[facebook_id:"2", user_id:"3", name:"juancito",text:"texto1"],
				[facebook_id:"3", user_id:"4", name:"juancito",text:"texto1"],
				[facebook_id:"4", user_id:"5", name:"juancito",text:"texto1"]

			]
			]

	}

	def getCompleteStory(storyId, userId) {
		//check if there is a paragraph from the user in the story
		Random rand = new Random()


		def story = Story.get(storyId)
		if (isFinished(story))
		println "historia terminada"
		else
		println "no terminada"

		def userParagraph
		if (userId)
		userParagraph = Paragraph.findByAuthorAndStoryId(userId, storyId)

		def actualStory = [id:story.id, name:story.name, author:story.author, authorName :story.authorName, paragraphs:[]]
		def actualParagraph
		if (userParagraph) {
			actualParagraph = userParagraph.parent;
			while (actualParagraph != null) {
				actualStory.paragraphs = [actualParagraph] + actualStory.paragraphs
				actualParagraph = actualParagraph.parent
			}
			actualParagraph = userParagraph
		} else
		actualParagraph = story.rootParagraph

		actualStory.paragraphs << actualParagraph
		while (actualParagraph.children?.size() != 0) {
			def option = rand.nextInt(actualParagraph.children.size())
			actualParagraph = actualParagraph.children.getat(option)
			actualStory.paragraphs << actualParagraph
		}

		return actualStory
	}
	
	
	def getRootParagraph(paragraph) {
		def parent = paragraph.parent
		while (parent != null) {
			paragraph = parent
			parent = paragraph.parent
		}
		return paragraph
	}

	private boolean isFinished(story) {
		def pending = [story.rootParagraph]
		def isFinished = true
		while (isFinished &&  pending.size()!= 0) {
			def p = pending.pop()
			if (p.leftSteps != 0) {
				if  (p.children?.size() != 0) {
					p.children.each {
						openBranches.push(it)
					}
				} else isFinished = false;
			}
		}
		return isFinished
	}
}
