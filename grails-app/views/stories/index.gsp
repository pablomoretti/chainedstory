<!doctype html>
<html>
	<head>
		<meta name="layout" content="default"/>
		<title>Chainedstory</title>
		<meta name="description" content="Chainedstory"/>
	</head>
	<body>
		<header class="cs-header">
			<h1 class="cs-logo">Chainedstory</h1>
		</header>
		<section class="cs-link-view">
			<form action="/stories/add" class="ch-form" method="post">
				<div class="cs-media">
					<a href="https://www.facebook.com/${request.getAttribute('facebook')?.user_id}" class="cs-img">
						<img src="https://graph.facebook.com/${request.getAttribute('facebook')?.user_id}/picture?type=square" width="50" height="50">
					</a>
					<div class="cs-bd ch-form-row">
						<textarea required placeholder="Start an awesome story with your friends..." name="paragraph" id="paragraph" maxlength="512"></textarea>
					</div>
				</div>
				<p class="ch-form-actions">
					<input type="submit" name="fold" value="Create" class="ch-btn" />
				</p>
			</form>
		</section>
	</body>
</html>
