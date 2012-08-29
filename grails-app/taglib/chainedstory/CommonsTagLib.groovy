package chainedstory

class CommonsTagLib {
	
	static namespace = 'commons'
	
	static returnObjectForTags = ['currentUrl']
	
	def currentUrl = {  attrs ->
		return GrailsRequestUtils.getCurrentUrl(request)
	}

}
