package chainedstory
import grails.converters.JSON
import grails.util.Environment
import javax.servlet.http.HttpServletRequest

public class SessionService {

	static transactional = false

	def createSession(HttpServletRequest request,Map facebook){
		request.session.facebook = facebook
		
	}

	def isAutenticate(HttpServletRequest request){
		return request.isRequestedSessionIdValid() && request.session.facebook
	}

	def destroySession(HttpServletRequest request){
		request.session.invalidate();
	}
}

