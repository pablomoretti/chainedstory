class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
			}
		}
		
		"/"(view:"/index")
		
		"500"(view:'/error')
	}
}
