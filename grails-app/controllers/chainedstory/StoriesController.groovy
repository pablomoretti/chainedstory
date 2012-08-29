package chainedstory

class StoriesController {
	def storiesService
	
    def index() { 
		println "want to get story ${params.id}"
		def story = storiesService.getStory(params.id)
		println story
		return [story:story]
		
	
	}
	
	def add(){
		println "save ${params.paragraph}"
		println request.facebook
		def newStory = storiesService.addStory(author:request.facebook?:"1466346255", content:params.paragraph)
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
