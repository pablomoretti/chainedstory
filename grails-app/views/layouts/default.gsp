<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# chainedstory: http://ogp.me/ns/fb/chainedstory#">
		<meta charset="utf-8">
		<title><g:layoutTitle default="Grails"/></title>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster+Two:400italic">
		<link rel="shortcut icon" type="image/x-icon" href="${resource(dir: 'assets', file: 'favicon-chainedstory.ico')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'chico-min-0.11.css')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'chico-mesh.css')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'chainedstory.css')}">
		<g:layoutHead/>
        <r:layoutResources />
	</head>
	<body>
		<g:layoutBody/>
        <r:layoutResources />

        <script src="${resource(dir: 'js', file: 'jquery.js')}"></script>
        <script src="${resource(dir: 'js', file: 'chico-min-0.11.js')}"></script>
		<script>
			if ($("#paragraph").length > 0) {
				$("#paragraph").countdown(512);
			}
		</script>
        </script>
	</body>
</html>