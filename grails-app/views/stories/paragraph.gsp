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
				<h2>Write a new paragraph</h2>
			</header>
			<div class="cs-paragraph">
				<p>Pablo Morreti wrote:</p>
				<cite>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing.</cite>
			</div>
			<form action="/stories/add" class="ch-form" method="post">
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
