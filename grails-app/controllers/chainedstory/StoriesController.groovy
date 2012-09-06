package chainedstory
import grails.converters.JSON

class StoriesController {

	def requiredAuthentication = ['starts']
	
	StoriesService storiesService
	
	def start() {
		request.setAttribute("facebook", [userId:1426088112])
	}
	
	def read(){
		[story:[id:1,name:'ss']]
	}

	def story() {
		println "want to get story ${params.id}"
		def story = storiesService.getCompleteStory(params.id)
		println story
		return [story:story]
	}

	def create(){
		if (params.paragraph_id == null) {
			def newStory = storiesService.addNewStory(
				author:request.getAttribute("facebook")?.userId?:"123", 
				content:params.text,
				category: params.category,
				oauthToken:request.getAttribute("facebook")?.oauth_token,
				title: params.name,
				steps: params.steps?:10)
			redirect(action:"congrats", params:[id:newStory])
		} else {
			def newParagraph = storiesService.addNewParagraph(
				paragraph:params.paragraph_id,
				author:request.getAttribute("facebook")?.userId?:"123", 
				content:params.paragraph,
				oauthToken:request.getAttribute("facebook")?.oauth_token)
			redirect(action:"congrats", params:[id:newParagraph])
		}
	}


	def view() {
		println storiesService.getCompleteStory(params.id, null)
	}

	def congrats(){
	}

	def paragraph(){
		return ['paragraph':Paragraph.findById(params.id)]
	}
}
