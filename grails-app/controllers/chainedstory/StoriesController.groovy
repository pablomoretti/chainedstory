package chainedstory

class StoriesController {

    def index() { 
		
	
	}
	
	def add(){
		println "save ${params.paragraph}"
		redirect(action:'congrats')
	}
	
	def congrats(){
		
	}
	
	def paragraph(){
	
	}
}
