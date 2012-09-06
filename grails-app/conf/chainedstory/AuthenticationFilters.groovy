package chainedstory

import org.apache.commons.lang.StringUtils;
import org.codehaus.groovy.grails.commons.GrailsApplication

import com.kennardconsulting.core.net.UrlEncodedQueryString;

class AuthenticationFilters  {

	GrailsApplication grailsApplication

	SessionService sessionService

	FacebookService facebookService

	def filters = {

		authenticate(controller: '*', action: '*') {
			before = {

				if(params.code){
					
					sessionService.createSession(request, facebookService.getUserFromCode(params.code, getRedirectUri(request)))

					String url = GrailsRequestUtils.getCurrentUrl(request)
					
					url =  url.substring(0, url.indexOf("code"))
					
					redirect(uri:url)

					return false;
				}
			}
		}

		authenticate(controller: '*', action: '*') {

			before = {

				if(controllerName){

					def artefact = grailsApplication.getArtefactByLogicalPropertyName("Controller", controllerName)

					def controller = grailsApplication.getMainContext().getBean(artefact.clazz.name)

					if(controller.hasProperty("requiredAuthentication")){

						def action = actionName?:'index'

						if(controller.requiredAuthentication.contains(action)){

							if (sessionService.isAutenticate(request)){
								return true;
							}else{

								def app = grailsApplication.config.facebook.app

								String url = GrailsRequestUtils.getCurrentUrl(request)

								if(url.contains("?")){
									url = url + "&login=true"
								}else{
									url = url + "?login=true"
								}

								redirect(uri:"https://www.facebook.com/dialog/oauth?scope=${app.scope}&client_id=${app.id}&display=page&redirect_uri=${url.encodeAsURL()}")

								return false;
							}
						}
					}
				}
			}
		}
	}


	def getRedirectUri(request){
		return GrailsRequestUtils.getCurrentUrl(request).replaceFirst("&code.*",'')
	}
}
