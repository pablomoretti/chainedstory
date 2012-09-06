<!doctype html>
<html>
	<head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# chainedstory: http://ogp.me/ns/fb/chainedstory-dev#">
		<meta property="fb:app_id" content="424204097615701" />
		<meta property="og:type"   content="chainedstory:story" />
		<meta property="og:url"    content="http://www.chainedstory.com/stories/read/${story.story.id}" />
		<meta property="og:title"  content="${story.paragraphs[0].authorName}'s ChainedStory" />
		<meta name="layout" content="default"/>
		<title>${story.paragraphs[0].authorName}'s ChainedStory</title>
		<meta name="description" content=""/>
	</head>
	<body>
		<header class="cs-header">
			<h1 class="cs-logo">ChainedStory</h1>
		</header>
		<div class="cs-main">
			<section class="cs-link-view cs-paragraph">
				<div class="cs-story">
					<h2 class="title">${story.story.title}</h2>
					<ul>
						<g:each  var="paragraph" in="${story.paragraphs}">
							<li>
								<article>
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
				</div>
			</section>
			<g:if test="${story.story.status != 'closed'}">
				<g:if test="${add}" >
					<section class="cs-link-view">
						<form action="/stories/create" class="ch-form" method="post">
							<input type="hidden" name="paragraph_id" value="${story.paragraphs[0].id}"/>
							<fieldset class="cs-media">
									<label class="cs-img" for="paragraph">
										<img src="https://graph.facebook.com/${session.facebook.id}/picture?type=square" width="50" height="50">
									</label>
									<div class="cs-bd ch-form-row">
										<textarea id="paragraph" required placeholder="Wrinting here..." name="text" maxlength="512"></textarea>
									</div>
							</fieldset>
							<p class="ch-form-actions">
								<span class="cs-btn-container">
									<input type="submit" name="fold" value="Publish!" class="ch-btn" />
								</span>
							</p>
						</form>
					</section>
				</g:if>
				<g:else>
					<p class="ch-form-actions">
						<span class="cs-btn-container">
							<a  href="/stories/add/${story.story.id}" class="ch-btn" > Continue the story </a>
						</span>
	     			</p>
				</g:else>
			</g:if>
			<footer>
				<p>ChainedStory &copy; 2012</p>
			</footer>
		</div>
	</body>
</html>
