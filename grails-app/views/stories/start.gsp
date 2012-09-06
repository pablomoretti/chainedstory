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
		<div class="cs-main">
			<section class="cs-link-view">
				<form action="/stories/create" class="ch-form" method="post">
					<div class="cs-story">
						<h2 class="title">Create a new story</h2>
						<p class="ch-form-hint">* Required fields</p>
						<fieldset>
							<div class="ch-form-row ch-form-required">
								<label for="title">Title: <em>*</em></label>
								<input id="title" type="text" required placeholder="Title of the story" name="name" size="55" maxlength="55">
							</div>
							<div class="ch-form-row ch-form-required">
								<label for="genre">Genre: <em>*</em></label>
								<select id="genre" name="category" required>
									<option value="">List of genres...</option>
									<option value="Action">Action</option>
									<option value="Horror">Horror</option>
									<option value="Comedy">Comedy</option>
									<option value="Drama">Drama</option>
									<option value="Romance">Romance</option>
								</select>
							</div>
						</fieldset>
						<fieldset class="cs-media">
							<label class="cs-img" for="paragraph">
								<img src="https://graph.facebook.com/${session.facebook.id}/picture?type=square" width="50" height="50">
							</label>
							<div class="cs-bd ch-form-row">
								<textarea id="paragraph" required placeholder="Start wrinting here..." name="text" maxlength="512"></textarea>
							</div>
						</fieldset>
					</div>
					<p class="ch-form-actions">
						<span class="cs-btn-container">
							<input type="submit" name="fold" value="Create" class="ch-btn" />
						</span>
					</p>
				</form>
			</section>
		</div>
	</body>
</html>
