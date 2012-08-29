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
				<div class="sc-media">
					<a href="https://www.facebook.com/${request.getAttribute('facebook')?.user_id}" class="sc-img">
						<img src="https://graph.facebook.com/${request.getAttribute('facebook')?.user_id}/picture?type=square" width="50" height="50">
					</a>
					<div class="sc-bd">
						<p><a href="https://www.facebook.com/${request.getAttribute('facebook')?.user_id}">Me</a>:</p>
						<div class="ch-form-row">
							<textarea placeholder="Start an awesome story with your friends..." name="paragraph" id="paragraph" maxlength="512"></textarea>
						</div>
					</div>
				</div>
				<p class="ch-form-actions">
					<input type="submit" name="fold" value="Create" class="ch-btn" />
				</p>
			</form>
		</section>
	</body>
</html>
