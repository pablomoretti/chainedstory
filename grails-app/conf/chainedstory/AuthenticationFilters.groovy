package chainedstory

import org.codehaus.groovy.grails.commons.GrailsApplication

class AuthenticationFilters  {

	GrailsApplication grailsApplication

	SessionService sessionService

	def filters = {
		
		authenticate(controller: '*', action: '*') {
			before = {
				
				if(params.code){
					
					sessionService.createSession(request, [])
					
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
								
								redirect(uri:"https://www.facebook.com/dialog/oauth?scope=${app.scope}&client_id=${app.id}&display=page&redirect_uri=${GrailsRequestUtils.getCurrentUrl(request).encodeAsURL()}")
								
								return false;
							}
						}
					}
				}
			}
		}
	}
}
