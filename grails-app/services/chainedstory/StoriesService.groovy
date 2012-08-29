package chainedstory

class StoriesService {

	def addStory(parameters) {
		def theParagraph = new Paragraph(author:parameters.author, content:parameters.content, leftSteps : 10)
		def resp = [:]
		if (theParagraph.validate()) {
			theParagraph.save()
			resp.status = 0
			resp.objId = theParagraph.id
		} else {
			throw new RuntimeException(theParagraph.errors.toString())
		}
		return resp
	}
	
    def getParagraphs() {

    }
	def getChainFor(paragraphId) {
	
	}
	def getFirstParagraph(paragraph) {
		def parent = paragraph.parent
		while (parent != null) {
			paragraph = parent
			parent = paragraph.parent
		}
		return paragraph
	}
	def getOpenParagraphs(){
		
	}
	def getFinishedStories() {
		def finishedBranches = Paragraph.findByLeftSteps(0);
		def stories = []
		finishedBranches.each{
			def openBranches = []
			def root = getFirstParagraph(it)
			openBranches << it.parent;
			def ok = true
			while (ok && ! openBranches.empty()) {
				def p = openBranches.pop()
				if (p.leftSteps != 0) {
					if  (!p.children.empty()) {
						p.children.each {
							openBranches<<it
						}
					} else ok = false;
				}
			}
			if (ok)
				stories << root;
		}
		return stories
	}
}
