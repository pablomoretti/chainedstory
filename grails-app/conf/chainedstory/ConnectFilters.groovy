package chainedstory

import grails.converters.JSON

import org.apache.commons.codec.binary.Base64
import org.apache.commons.lang.StringUtils;

class ConnectFilters {

	def appId = 222415064551176

	def canvasPage = 'https://apps.facebook.com/chainedstory-dev/'

	def base64UrlDecode(value) {
		new Base64(true).decode(StringUtils.replace(StringUtils.replace(value,'-','+'),'/','_'))
	}

	def filters = {

		all(controller:'story', action:'*') {

			before = {

				def auth_url = "https://www.facebook.com/dialog/oauth?client_id=${appId}&redirect_uri=${canvasPage.encodeAsURL()}"

				def input  = params.signed_request

				if(!input){
					redirect(uri:canvasPage)
					return true
				}else{

					String[] split = input.split("[.]", 2);

					Map envelope = (Map) JSON.parse(new String( base64UrlDecode(split[1])));

					println envelope

					if(!envelope['user_id']){
						redirect(controller:'oauth')
						return true
					}
					else{
						request.setAttribute("facebook",envelope)
					}
				}
			}
			after = { Map model ->
			}
			afterView = { Exception e ->
			}
		}
	}
}
