package chainedstory

class StoriesController {
	def storiesService
	
    def index() { 
		
	
	}
	
	def add(){
		println "save ${params.paragraph}"
		def newStory = storiesService.addStory(author:"yo", content:params.paragraph)
		redirect(action:"congrats", params:[id:newStory])
	}
	
	def getStory() {
		println "want to get story ${params.storyId}"
		def sampleStory = [
				[author:"juancito"]
			]
		redirect(action:'congrats')
	}
	
	def congrats(){
		
	}
	
	def paragraph(){
		return ['paragraph':Paragraph.findById(params.id)]
	}
}
