package chainedstory

import grails.converters.*

import javax.crypto.Mac
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

import org.apache.commons.codec.binary.Base64
import org.codehaus.groovy.grails.commons.GrailsApplication

class FacebookService {

	static transactional = false

	private static String API_GRAPH = "https://graph.facebook.com"

	public static String PREFIX_COOKIE = "fbsr_"

	GrailsApplication grailsApplication

	def getAppConfig(){
		grailsApplication.config.facebook.app
	}

	def getCookieName(){
		PREFIX_COOKIE + appConfig.id
	}

	Map getAccessToken(String code,String redirectUri) {

		StringBuilder sb  = new StringBuilder()

		sb << API_GRAPH
		sb << "/oauth/access_token"
		sb << "?client_id=${appConfig.id}"
		sb << "&redirect_uri=${redirectUri.encodeAsURL()}"
		sb << "&client_secret=${appConfig.clientSecret}"
		sb << "&code=${code}"

		def mapAccessToken = [:]

		def timeBeforeRequest = new Date().time

		def body =  new URL(sb.toString()).text

		body.tokenize('&').each {  value ->
			def split = value.split('=');
			mapAccessToken[(split[0])] = split[1].decodeURIComponent()
		}

		Map accessToken = [:]
		accessToken.value = mapAccessToken.access_token
		accessToken.expires = new Date(time:timeBeforeRequest + 1000 * Integer.parseInt(mapAccessToken.expires))

		return accessToken
	}

	Map getUserFromCode(String code,String redirectUri='') {

		Map accessToken = getAccessToken(code,redirectUri)

		Map user = getUser(accessToken)

		return user
	}

	Map getUser(Map accessToken) {

		String response =  new URL( API_GRAPH + "/me?access_token=${accessToken.value.encodeAsURL()}").text

		def json = JSON.parse(response)

		Map user = [id:json.id,firstName:json.first_name,lastName:json.last_name,email:json.email]

		user.accessToken = accessToken

		return user
	}


	Map getUserFromCookie(String cookie) throws FacebookException {

		String[] parts = cookie.split("\\.")

		def sig = Base64.decodeBase64(parts[0])

		def plaintext = parts[1].getBytes()

		def decoded = JSON.parse(new String(parts[1].decodeBase64()))

		// "HMAC-SHA256" doesn't work, but "HMACSHA256" does.
		String algorithm = decoded.algorithm.replace("-", "")

		SecretKey secret = new SecretKeySpec(appConfig.clientSecret.getBytes(), algorithm)

		Mac mac = Mac.getInstance(algorithm)

		mac.init(secret)

		byte[] digested = mac.doFinal(plaintext)

		if (!Arrays.equals(sig, digested))
			throw new FacebookException(new IllegalStateException("Facebook cookie has invalid signature"))

		try {
			return getUserFromCode(decoded.code);
		}catch (Exception e) {
			throw new FacebookException(e);
		}

	}

	static class FacebookException extends Exception {

		public FacebookException() {
			super();
		}

		public FacebookException(String arg0, Throwable arg1) {
			super(arg0, arg1);
		}

		public FacebookException(String arg0) {
			super(arg0);
		}

		public FacebookException(Throwable arg0) {
			super(arg0);
		}

	}

}