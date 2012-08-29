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
			<div class="cs-paragraph">
				<span>Pablo Morreti wrote:</span>
				<blockquote>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing.</blockquote>
			</div>
			<hr>
			<form action="/stories/add" class="ch-form" method="post">
				<legend>Me:</legend>
				<div class="ch-form-row">
					<textarea placeholder="Write a new paragraph, fold and share..." name="paragraph" maxlength="512"></textarea>
				</div>
				<p class="ch-form-actions">
					<input type="submit" name="fold" value="Fold and share" class="ch-btn" />
				</p>
			</form>
		</section>
	</body>
</html>
