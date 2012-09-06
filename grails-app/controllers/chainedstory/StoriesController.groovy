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
		println "id requested ${params.paragraph_id}"
		
		if (params.paragraph_id == null) {
			def newStory = storiesService.addStory(author:request.getAttribute("facebook").user_id, content:params.paragraph,oauthToken:request.getAttribute("facebook").oauth_token)
			redirect(action:"congrats", params:[id:newStory])
		} else {
			def newParagraph = storiesService.addParagraph(paragraph:params.paragraph_id,author:request.getAttribute("facebook").user_id, content:params.paragraph,oauthToken:request.getAttribute("facebook").oauth_token)
		
		}
		
	}
	
	
	def view() {
		println storiesService.getCompleteStory(params.story_id, null)
	}
	
	def congrats(){
		
	}
	
	def paragraph(){
		return ['paragraph':Paragraph.findById(params.id)]
	}
}
