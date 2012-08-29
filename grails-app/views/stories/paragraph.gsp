<!doctype html>
<html>
	<head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# chainedstory-dev: http://ogp.me/ns/fb/chainedstory-dev#">
		<meta property="fb:app_id" content="222415064551176" /> 
		<meta property="og:type"   content="chainedstory-dev:paragraph" /> 
		<meta property="og:url"    content="${commons.currentUrl()}" /> 
		<meta property="og:title"  content="Paragraph of ${paragraph.author}" /> 
		<meta property="og:image"  content="https://s-static.ak.fbcdn.net/images/devsite/attachment_blank.png" /> 
		<meta name="layout" content="default"/>
		<title>Paragraph of ${paragraph.author}</title>
		<meta name="description" content="Chainedstory"/>
	</head>
	<body>
		<header class="cs-header">
			<h1 class="cs-logo">Chainedstory</h1>
		</header>
		<section class="cs-link-view">
			<header>
				<h2>Create a new chained story...</h2>
			</header>
			<form action="/stories/add" class="ch-form" method="post">
				<div class="ch-form-row">
					<textarea placeholder="Start an awesome story with your friends..." name="paragraph"></textarea>
				</div>
				<p class="ch-form-actions">
					<input type="submit" name="fold" value="Fold and share" class="ch-btn" />
				</p>
			</form>
		</section>
	</body>
</html>
