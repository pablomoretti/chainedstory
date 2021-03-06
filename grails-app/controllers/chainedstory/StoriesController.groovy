package chainedstory
import grails.converters.JSON

class StoriesController {

	def requiredAuthentication = ['start','create','congrats','add']
	
	StoriesService storiesService
	
	def start() {
	}
	
	def read(){
		def story = storiesService.getCompleteStory(params.id)
		return [story:story]
	}
	
	def add(){
		def story = storiesService.getCompleteStory(params.id)
		render(view:'read',model:[story:story,add:true])
	}
		
	def create(){
		if (params.paragraph_id == null) {
			def newStory = storiesService.addNewStory(
				author:request.session.facebook.id,
				authorName:request.session.facebook.firstName,
				content:params.text,
				category: params.category,
				oauthToken:request.session.facebook.accessToken.value,
				title: params.name,
				steps: params.steps?:10)
			redirect(action:"congrats", params:[id:newStory])
		} else {
			def newParagraph = storiesService.addNewParagraph(
				paragraph:params.paragraph_id,
				author:request.session.facebook.id,
				content:params.text,
				authorName:request.session.facebook.firstName,
				oauthToken:request.session.facebook.accessToken.value)
			redirect(action:"congrats", params:[id:newParagraph])
		}
	}


	def congrats(){
	}

}
