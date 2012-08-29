package chainedstory

class ConnectFilters {

	def appId = 222415064551176

	def canvasPage = 'https://apps.facebook.com/chainedstory-dev/'

	def filters = {

		all(controller:'*', action:'*') {

			before = {

				def auth_url = "https://www.facebook.com/dialog/oauth?client_id=${appId}&redirect_uri=${canvasPage.encodeAsURL()}"

				def signed_request  = params.signed_request
				
				//def list1 = signed_request.slipt(".")
				
				println signed_request

//				$data = json_decode(base64_decode(strtr($payload, '-_', '+/')), true);
//
//				if (empty($data["user_id"])) {
//					echo("<script> top.location.href='" . $auth_url . "'</script>");
//				} else {
//					echo ("Welcome User: " . $data["user_id"]);
//				}
			}
			after = {
				Map model ->
			}
			afterView = {
				Exception e ->
			}
		}
	}
}
