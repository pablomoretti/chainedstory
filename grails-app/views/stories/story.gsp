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
			<ul class="cs-story-full">
				<li>
					<article class="cs-paragraph">
						<div class="cs-media">
							<a href="https://www.facebook.com/${paragraph.author}" class="cs-img">
								<img src="https://graph.facebook.com/${paragraph.author}/picture?type=square" width="50" height="50">
							</a>
							<div class="cs-bd">
								<p><a href="https://www.facebook.com/${paragraph.author}">${paragraph.author}</a> wrote:</p>
								<blockquote>${paragraph.content}</blockquote>
							</div>
						</div>
					</article>
				</li>
			</ul>
		</section>
	</body>
</html>
