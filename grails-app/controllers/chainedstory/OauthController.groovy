package chainedstory

import grails.util.Environment

class OauthController {

	def index() {

		def appId = 424204097615701

		if(Environment.isDevelopmentMode()){
			appId = 222415064551176
		}
		render "<script> top.location.href='https://www.facebook.com/dialog/oauth?client_id=${appId}&redirect_uri=${params.go.encodeAsURL()}&scope=email,publish_actions'</script>"
	}
}
