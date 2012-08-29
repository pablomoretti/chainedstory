package chainedstory

class StoriesController {
	def storiesService
	
    def index() { 
		println "want to get story ${params.id}"
		def story = storiesService.getStory(params.id)
		println story
		return story
		
	
	}
	
	def add(){
		println "save ${params.paragraph}"
		def newStory = storiesService.addStory(author:"yo", content:params.paragraph)
		redirect(action:"congrats", params:[id:newStory])
	}
	
	def view() {
	}
	
	def congrats(){
		
	}
	
	def paragraph(){
		return ['paragraph':Paragraph.findById(params.id)]
	}
}
