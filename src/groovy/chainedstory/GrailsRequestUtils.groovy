package chainedstory


import javax.servlet.http.HttpServletRequest;

class GrailsRequestUtils {

	static String getCurrentUrl(HttpServletRequest request){

		StringBuilder sb = new StringBuilder()

		sb << request.getRequestURL().substring(0,request.getRequestURL().indexOf("/", 7))
		
		sb << request.getAttribute("javax.servlet.forward.request_uri")

		if(request.getAttribute("javax.servlet.forward.query_string")){

			sb << request.getAttribute("javax.servlet.forward.query_string")
		}

		return sb.toString();
	}
}
