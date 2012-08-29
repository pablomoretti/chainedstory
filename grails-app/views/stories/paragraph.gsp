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
			<article class="cs-paragraph">
				<div class="cs-media">
					<a href="https://www.facebook.com/${paragraph.author}" class="cs-img">
						<img src="https://graph.facebook.com/${paragraph.author}/picture?type=square" alt="${paragraph.author}" width="50" height="50">
					</a>
					<div class="cs-bd">
						<blockquote>${paragraph.content}</blockquote>
					</div>
				</div>
			</article>
			<hr>
			<form action="/stories/add" class="ch-form" method="post">
				<input type="hidden" name="paragraph_id" value="${paragraph.id}"/>
				<div class="cs-media">
					<a href="https://www.facebook.com/${request.getAttribute('facebook')?.user_id}" class="cs-img">
						<img src="https://graph.facebook.com/${request.getAttribute('facebook')?.user_id}/picture?type=square" width="50" height="50">
					</a>
					<div class="cs-bd ch-form-row">
						<textarea required placeholder="Write a new paragraph, fold and share..." id="paragraph" name="paragraph" maxlength="512"></textarea>
					</div>
				</div>
				<p class="ch-form-actions">
					<input type="submit" name="fold" value="Fold" class="ch-btn" />
				</p>
			</form>
		</section>
	</body>
</html>
