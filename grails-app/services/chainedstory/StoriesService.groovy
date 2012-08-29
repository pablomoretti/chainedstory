package chainedstory

class StoriesService {

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
