package chainedstory
import grails.converters.JSON
import grails.util.Environment;


class StoriesService {
	def transactional = true

	def addStory(parameters) {
		def theParagraph = new Paragraph(author:parameters.author, content:parameters.content, leftSteps : 10)
		if (theParagraph.validate()) {
			theParagraph.save()
		}
		else {
			throw new RuntimeException(theParagraph.errors.toString())
		}

		def url = ""
		
		if(Environment.isDevelopmentMode()){
			url = "http://samples.ogp.me/222499907876025"
		}
		else{
			url = "http://www.chainedstory.com/stories/paragraph/" + theParagraph
		}

		def resp = JSON.parse(new URL(getActionUrl(url, parameters.content,oauthToken)).text);
		theParagraph.facebookId = resp.id
		theParagraph.save()
		println theParagraph.properties.toString()
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
		"&text=$text"
	}
	def getStory(id) {
		return [
			[facebook_id:"1", user_id:"2", name:"juancito",text:"texto1"],
			[facebook_id:"2", user_id:"3", name:"juancito",text:"texto1"],
			[facebook_id:"3", user_id:"4", name:"juancito",text:"texto1"],
			[facebook_id:"4", user_id:"5", name:"juancito",text:"texto1"]

		]
	}

	def getCompleteStory(paragraph) {
		def root = getRootParagraph(paragraph)
		if (isFinished)
		println "caca"
		else
		throw new RuntimeException("Story is not finished yet")
	}
	def getRootParagraph(paragraph) {
		def parent = paragraph.parent
		while (parent != null) {
			paragraph = parent
			parent = paragraph.parent
		}
		return paragraph
	}

	private boolean isFinished(rootParagraph) {
		def pending = [rootParagraph]
		def isFinished = true
		while (isFinished && ! pending.empty()) {
			def p = pending.pop()
			if (p.leftSteps != 0) {
				if  (!p.children.empty()) {
					p.children.each {
						openBranches.push(it)
					}
				} else isFinished = false;
			}
		}
		return isFinished
	}
}
/*para optimizar despues
 boolean finished = false
 Exception anyException = null
 withPool(100) {pool ->
 runForkJoin(null) { paragraph ->
 def children
 if (paragraph == null) {
 children = [rootParagraph]
 } else {
 try {
 def category = getCategory(categoryId, siteId)
 log.debug "Fetched category $category.id"
 def json = new JSONObject(category).toString()
 if (!firstWrite) {
 writer.write(',')
 }
 writer.write("\"$category.id\":$json")
 firstWrite = false
 writer.flush()
 children = category.children_categories.collect {it.id}
 } catch (Exception e) {
 anyException = e
 throw e
 }
 }
 children.each {
 forkOffChild(it)       //fork a child task
 }
 }
 }
 */