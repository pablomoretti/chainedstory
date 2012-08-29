package chainedstory

import grails.util.Environment

class OauthController {


	def index() {

		if(Environment.isDevelopmentMode()){
			def canvasPage = 'https://apps.facebook.com/chainedstory-dev/'
			def appId = 222415064551176
		}
		else{
			def canvasPage = 'https://apps.facebook.com/chainedstory/'
			def appId = 424204097615701
		}


		render "<script> top.location.href='https://www.facebook.com/dialog/oauth?client_id=${appId}&redirect_uri=${canvasPage.encodeAsURL()}&scope=email,publish_actions'</script>"
	}

	def demo1(){
		render(view:"/homes/index")
	}
}
