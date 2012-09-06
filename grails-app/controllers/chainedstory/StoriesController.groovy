package chainedstory

class StoriesController {

	def requiredAuthentication = ['start']
	
	StoriesService storiesService
	
	def start() {
		request.setAttribute("facebook", [userId:1426088112])
	}
	
	def create() {
		request.setAttribute("facebook", [userId:1426088112])
	}
	
	def read(){
		[story:[id:1,name:'ss']]
	}

	def index() {
		println "want to get story ${params.id}"
		def story = storiesService.getCompleteStory(params.id)
		println story
		return [story:story]
	}

	def add(){
		start()
		println "save ${params.paragraph}"
		println "id requested ${params.paragraph_id}"

		if (params.paragraph_id == null) {
			def newStory = storiesService.addNewStory(
				author:request.getAttribute("facebook").userId, 
				content:params.paragraph,
				oauthToken:request.getAttribute("facebook").oauth_token,
				title: params.title,
				steps: params.steps)
			redirect(action:"congrats", params:[id:newStory])
		} else {
			def newParagraph = storiesService.addNewParagraph(
				paragraph:params.paragraph_id,
				author:request.getAttribute("facebook").userId, 
				content:params.paragraph,
				oauthToken:request.getAttribute("facebook").oauth_token)
			redirect(action:"congrats", params:[id:newParagraph])
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
