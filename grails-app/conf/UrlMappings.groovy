class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
			}
		}
		
		"/"(controller:"stories")
		
		"500"(view:'/error')
	}
}
