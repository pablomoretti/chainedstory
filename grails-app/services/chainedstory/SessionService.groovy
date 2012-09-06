package chainedstory
import grails.converters.JSON
import grails.util.Environment
import javax.servlet.http.HttpServletRequest

public class SessionService {

	static transactional = false

	def createSession(HttpServletRequest request,Map data){
		request.session.login = true
	}

	def isAutenticate(HttpServletRequest request){
		return request.isRequestedSessionIdValid() && request.session.login
	}

	def destroySession(HttpServletRequest request){
		request.session.invalidate();
	}
}

