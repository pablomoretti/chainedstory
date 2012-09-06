<!doctype html>
<html>
	<head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# chainedstory: http://ogp.me/ns/fb/chainedstory-dev#">
		<meta property="fb:app_id" content="424204097615701" />
		<meta property="og:type"   content="chainedstory:story" />
		<meta property="og:url"    content="http://www.chainedstory.com/stories/read/${story.id}" />
		<meta property="og:title"  content="${story.name}" />
		<meta name="layout" content="default"/>
		<title>${story.paragraphs[0].authorName}'s Chained Story</title>
		<meta name="description" content=""/>
	</head>
	<body>

		<header class="cs-header">
			<h1 class="cs-logo">Chainedstory</h1>
		</header>
		<section class="cs-link-view">
			<ul class="cs-story-full">
				<g:each  var="paragraph" in="${story.paragraphs}">
					<li>
						<article class="cs-paragraph">
							<div class="cs-media">
								<a href="https://www.facebook.com/${paragraph.facebookId}" class="cs-img">
									<img src="https://graph.facebook.com/${paragraph.authorId}/picture?type=square" width="50" height="50">
								</a>
								<div class="cs-bd">
									<blockquote>${paragraph.content}</blockquote>
								</div>
							</div>
						</article>
					</li>
				</g:each>
			</ul>
		</section>
	</body>
</html>
