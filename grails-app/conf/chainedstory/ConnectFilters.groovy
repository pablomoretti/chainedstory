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

				def canvasPage = 'https://apps.facebook.com/chainedstory/'
				def appId = 424204097615701

				if(Environment.isDevelopmentMode()){
					canvasPage = 'https://apps.facebook.com/chainedstory-dev/'
					appId = 222415064551176
				}

				if(session.facebookUser){
					request.setAttribute("facebook",session.facebookUser)
				}else{

					Map facebookUser

					def auth_url = "https://www.facebook.com/dialog/oauth?client_id=${appId}&redirect_uri=${canvasPage.encodeAsURL()}"

					def input  = params.signed_request

					StringBuilder sb = new StringBuilder()

					sb << request.getAttribute("javax.servlet.forward.request_uri")

					if(request.getAttribute("javax.servlet.forward.query_string")){
						sb << request.getAttribute("javax.servlet.forward.query_string")
					}
					

					if(!input){
						redirect(uri:canvasPage + StringUtils.replaceOnce(sb.toString(), "/", ""))
						return true
					}else{
						String[] split = input.split("[.]", 2);

						facebookUser = (Map) JSON.parse(new String( base64UrlDecode(split[1])));

						if(!facebookUser['user_id']){
							redirect(controller:'oauth',params:[go:canvasPage + StringUtils.replaceOnce(sb.toString(), "/", "") ])
							return true
						}

						session.facebookUser = facebookUser

						request.setAttribute("facebook",facebookUser)
					}
				}

				println request.getAttribute("facebook")
			}
			after = { Map model ->
			}
			afterView = { Exception e ->
			}
		}
	}
}


