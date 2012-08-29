package chainedstory
import grails.converters.JSON
import static groovyx.gpars.GParsPool.runForkJoin
import static groovyx.gpars.GParsPool.withPool


class StoriesService {
	def transactional = true

	def addStory(parameters) {
		def theParagraph = new Paragraph(author:parameters.author, content:parameters.content, leftSteps : 10)
		if (theParagraph.validate()) 
			theParagraph.save()
		else 
			throw new RuntimeException(theParagraph.errors.toString())
		def resp = JSON.parse(new URL(getActionUrl("http://samples.ogp.me/222499907876025", parameters.content)).text);
		theParagraph.facebookId = resp.id
		theParagraph.save()
		println theParagraph.properties.toString()
		return theParagraph.id
	}
	
	def getActionUrl (objectUrl, text) {
		return "https://graph.facebook.com/me/chainedstory-dev:write?paragraph=" +
			objectUrl.encodeAsURL() +
			"&access_token=AAADKSQrqTwgBAOef6qHxnpSwCWQksGyDtHhgtwUGrVAoptiM3fU6lv5uU6ImKXK0qwgTysJjqmILZAskQBTEmmPblyIa4qIlzH8azcOD1t744UWnZC&method=post" +
			"&text=$text"
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