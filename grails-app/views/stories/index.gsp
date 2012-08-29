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
			<header>
				<h2>Create a new chained story...</h2>
			</header>
			<form action="/stories/add" class="ch-form" method="post">
				<div class="ch-form-row">
					<textarea autofocus placeholder="Start an awesome story with your friends..." name="paragraph"></textarea>
				</div>
				<p class="ch-form-actions">
					<input type="submit" name="fold" value="Create And Share" class="ch-btn" />
				</p>
			</form>
		</section>
	</body>
</html>
