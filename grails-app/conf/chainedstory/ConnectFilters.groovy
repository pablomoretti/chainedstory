package chainedstory

import grails.converters.JSON
import grails.util.Environment;

import org.apache.commons.codec.binary.Base64
import org.apache.commons.lang.StringUtils;

class ConnectFilters {

	def base64UrlDecode(value) {
		new Base64(true).decode(StringUtils.replace(StringUtils.replace(value,'-','+'),'/','_'))
	}

	def filters = {

		all(controller:'stories', action:'*') {

			before = {

				if(Environment.isDevelopmentMode()){
					def canvasPage = 'https://apps.facebook.com/chainedstory-dev/'
					def appId = 222415064551176
				}
				else{
					def canvasPage = 'https://apps.facebook.com/chainedstory/'
					def appId = 424204097615701
				}

				def input  = params.signed_request

				Map facebookUser

				if(Environment.isDevelopmentMode() && input == null){
					facebookUser = [issued_at:1346263267, expires:1346270400, oauth_token:"AAADKSQrqTwgBABQE3xYOCNAD6oW096BK9ZBM0zFJ83TNlpatMZAI7xc4MR03YlqZCIw7BVEp9lIjVRf07ZCi5hJeayhf7rHTPfaZBFBxXyYEHpNohpe3g", user_id:1426088112, user:[age:[min:21], locale:"es_LA", country:"ar"], algorithm:"HMAC-SHA256"]
				}else{

					def auth_url = "https://www.facebook.com/dialog/oauth?client_id=${appId}&redirect_uri=${canvasPage.encodeAsURL()}"

					if(!input){
						redirect(uri:canvasPage)
						return true
					}else{
						String[] split = input.split("[.]", 2);

						facebookUser = (Map) JSON.parse(new String( base64UrlDecode(split[1])));

						if(!facebookUser['user_id']){
							redirect(controller:'oauth')
							return true
						}
					}
				}

				request.setAttribute("facebook",facebookUser)

				println facebookUser
			}
			after = { Map model ->
			}
			afterView = { Exception e ->
			}
		}
	}
}
