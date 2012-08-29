package chainedstory

class OauthController {
	
	def appId = 222415064551176
	
	def canvasPage = 'https://apps.facebook.com/chainedstory-dev/'
	
    def index() { 
		render "<script> top.location.href='https://www.facebook.com/dialog/oauth?client_id=${appId}&redirect_uri=${canvasPage.encodeAsURL()}&scope=email,publish_actions'</script>"
	}
	
	def demo1(){
		render(view:"/homes/index")
	}
}
