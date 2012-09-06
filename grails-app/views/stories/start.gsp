<!doctype html>
<html>
	<head>
		<meta name="layout" content="default"/>
		<title>ChainedStory</title>
		<meta name="description" content="ChainedStory"/>
	</head>
	<body>
		<header class="cs-header">
			<h1 class="cs-logo">ChainedStory</h1>
		</header>
			<h2 >Create a Story</h2>
		
		<section class="cs-link-view">
			<form action="/stories/create" class="ch-form" method="post">
				<div class="cs-media">
					<a href="https://www.facebook.com/${request.session.facebook.id}" class="cs-img">
						<img src="https://graph.facebook.com/${request.session.facebook.id}/picture?type=square" width="50" height="50">
					</a>
					<div class="cs-bd ch-form-row">
						Name : <input type="text" name="name" maxlength="60" >
						
						Category :
						
						<select name="category" >
						  <option value="Action">Action</option>
						  <option value="Horror">Horror</option>
						  <option value="Comedy">Comedy</option>
						  <option value="Drama">Drama</option>
						  <option value="Romance">Romance</option>
						</select>
						
					</div>
					<div class="cs-bd ch-form-row">
						<textarea required placeholder="Start an awesome story with your friends..." name="text" maxlength="512"></textarea>
					</div>
				</div>
				<p class="ch-form-actions">
					<input type="submit" name="fold" value="Create" class="ch-btn" />
				</p>
			</form>
		</section>
	</body>
</html>
