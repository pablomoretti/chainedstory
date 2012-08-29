<!doctype html>
<html>
	<head>
		<meta name="layout" content="default"/>
		<title>Chainedstories</title>
		<meta name="description" content="Chainedstories"/>
	</head>
	<body>
		<header>
			<h1>Chainedstories</h1>
		</herader>
		<section>
			<form action="http://ui.ml.com:3000/test/post" class="ch-form myForm" method="POST">
				<fieldset>
					<legend>Inputs</legend>
					<p class="ch-form-hint">* Required fields</p>
						<p class="ch-form-row">
							<label for="input_ico">
								Icon:
							</label>
							<input type="text" id="input_ico" name="input_ico" size="30" placeholder="">
							<i class="ch-form-ico ch-icon-question-sign"></i>
						</p>
						<p class="ch-form-row">
							<label for="input_button">
								Category:
							</label>
							<input type="text" id="input_button" name="input_button" size="30" placeholder="">
							<input type="button" name="add_category" value="Add" class="ch-btn ch-btn-small ch-btn-skin">
							<span class="ch-form-hint">Add your category</span>
						</p>
						<p class="ch-form-row ch-form-required">
							<label for="price">
								Price:
								<em>*</em>
							</label>
							<input type="text" id="price" name="price" required="required" placeholder="1349.43">
							<span class="ch-form-hint">Numbers and dot symbol</span>
						</p>
						<p class="ch-form-row ch-form-required">
							<label for="email">
								E-mail:
								<em>*</em>
							</label>
							<input type="email" id="email" name="email" required="required" size="35" placeholder="juan.perez@chico-ui.com.ar">
							<span class="ch-form-hint">It will be your login name</span>
						</p>
						<p class="ch-form-row">
							<label for="email2">
								E-mail:
							</label>
							<input type="email2" id="email2" name="email2" required="required" size="35" placeholder="juan.perez@chico-ui.com.ar">
							<input type="checkbox" id="news" name="news" checked="checked" class="ch-form-checkbox-inline">
							<label for="news" class="ch-label-inline">
								Accept to receive weekly news
							</label>
						</p>
						<p class="ch-form-row">
							<label for="url">
								URL:
							</label>
							<input type="url" id="url" name="url" size="60" placeholder="http://www.chico-ui.com.ar">
						</p>
						<p class="ch-form-row">
							<label for="number">
								Numeric field:
							</label>
							<input type="number" id="number" name="number" min="18" max="99" placeholder="30">
						</p>
						<p class="ch-form-row">
							<label for="range">
								Numeric range:
							</label>
							<input type="range" id="range" name="range" min="1" max="10">
							<span class="ch-form-hint">Between 1 to 10</span>
						</p>
						<p class="ch-form-row ch-form-required ch-form-disabled">
							<label for="required_disabled">
								Required disabled:
								<em>*</em>
							</label>
							<input type="text" id="required_disabled" required="required" disabled="disabled">
							<span class="ch-form-hint">It's a unknown use case</span>
						</p>
						<p class="ch-form-row">
							<label for="characters">
								Characters:
							</label>
							<input type="text" id="characters">
						</p>
						<p class="ch-form-row">
							<label for="custom">
								Custom:
							</label>
							<input type="text" id="custom" placeholder="12" size="2">
						</p>
						<p class="ch-form-row">
							<label for="readonly">
								Readonly:
							</label>
							<input type="text" readonly="readonly" id="readonly" value="its a readonly value">
						</p>
						<p class="ch-form-row">
							<label for="double">
								It's a input text with double line:
							</label>
							<input type="text" id="double">
						</p>
				</fieldset>
				<fieldset>
					<legend>Selects</legend>
					<p class="ch-form-row">
						<label for="select1">
							Common field:
						</label>
						<select id="select1">
							<option value="-1">Select one...</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
							<option value="4">Option 4</option>
						</select>
					</p>
					<p class="ch-form-row ch-form-required">
						<label for="select2">
							Rquired: <em>*</em>
						</label>
						<select id="select2" required="required" pattern="[^-1]">
							<option value="">Select one...</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
							<option value="4">Option 4</option>
						</select>
					</p>
					<p class="ch-form-row ch-form-required ch-form-disabled">
						<label for="select3" class="required disabled">
							Required disabled: <em>*</em>
						</label>
						<select id="select3" required="required" disabled="disabled">
							<option value="">Select one...</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
							<option value="4">Option 4</option>
						</select>
					</p>
					<p class="ch-form-row ch-form-disabled">
						<label for="select4">
							Disabled:
						</label>
						<select id="select4" disabled="disabled">
							<option value="0">Select one...</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
							<option value="4">Option 4</option>
						</select>
					</p>
				</fieldset>
				<fieldset>
					<legend>Misc</legend>
					<p class="ch-form-row">
						<label for="street">
							Domicilio:
						</label>
						<input type="text" size="30" id="street" placeholder="Av. Costanera Rafael Obligado" />
						<input type="number" id="door" placeholder="1345" />
						<select id="state">
							<option value="">Select one state/province...</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
							<option value="4">Option 4</option>
						</select>
					</p>
					<p class="ch-form-row">
						<label for="select5">
							Common field:
						</label>
						<select id="select5">
							<option value="0">Select one...</option>
							<option value="1">Option 1</option>
							<option value="2">Option 2</option>
							<option value="3">Option 3</option>
							<option value="4">Option 4</option>
						</select>
						<input type="text" id="secondary_option" placeholder="Common field" />
					</p>
					<p class="ch-form-row">
						<label for="num1">
							CUIT:
						</label>
						<input type="number" id="num1" placeholder="20" /> -
						<input type="number" id="num2" placeholder="23111399" /> /
						<input type="number" id="num3" placeholder="4" />
					</p>
					<p class="ch-form-row">
						<label for="tc1">
							Expires:
						</label>
						<input type="number" id="tc1" min="1" max="12" placeholder="11" />
						<input type="number" id="tc2" min="2011" max="2020" placeholder="2013" />
					</p>
					<p class="ch-form-row">
						<label for="select6">
							House features:
						</label>
						<select id="select6" multiple="multiple" size="5" class="ch-form-select-multiple">
							<option value="0">Air conditioning</option>
							<option value="1">Rooms</option>
							<option value="2">Balcony</option>
							<option value="3">Laundry</option>
							<option value="4">Kitchen</option>
							<option value="5">Living</option>
							<option value="6">Dining room</option>
							<option value="7">Amenities</option>
						</select>
					</p>

				</fieldset>
				<fieldset>
					<p class="ch-form-options ch-form-required check2">
						<input type="checkbox" value="alpha" id="check4a" name="version4" required="required">
						<label for="check4a">
							Unique checkbox
						</label>
					</p>
				</fieldset>
				<fieldset>
					<legend>Checkbox</legend>
						<div class="ch-form-options">
							<h4 class="ch-form-subtitle">Label of checkboxs group:</h4>
							<p class="ch-form-row">
								<input type="checkbox" value="alpha" id="check1a" name="version1a" required="required">
								<label for="check1a">
									Alpha
								</label>
							</p>
							<p class="ch-form-row">
								<input type="checkbox" value="beta" id="check1b" name="version1b">
								<label for="check1b">
									Beta
								</label>
							</p>
						</div>
				</fieldset>

				<fieldset>
					<legend>Legend of required group <em>*</em></legend>
					<div class="ch-form-options check2">
						<p class="ch-form-row">
							<input type="checkbox" value="alpha" id="check2a" name="version2">
							<label for="check2a">
								Alpha
							</label>
						</p>
						<p class="ch-form-row">
							<input type="checkbox" value="beta" id="check2b" name="version2">
							<label for="check2b">
								Beta
							</label>
						</p>
					</div>
				</fieldset>

				<fieldset>
					<legend>Legend of checkboxs group</legend>
					<div class="ch-form-options ch-form-required check3">
						<h4 class="ch-form-subtitle">Label of required group: <em>*</em></h4>
						<p class="ch-form-row">
							<input type="radio" value="alpha" id="check3a" name="version3">
							<label for="check3a">
								Alpha
							</label>
						</p>
						<p class="ch-form-row">
							<input type="radio" value="beta" id="check3b" name="version3">
							<label for="check3b">
								Beta
							</label>
						</p>
					</div>
				</fieldset>

				<fieldset>
					<legend>Radio buttons</legend>
					<div class="ch-form-options">
						<p class="ch-form-row">
							<input type="radio" value="alpha" id="radio1a" name="version4">
							<label for="radio1a">
								Alpha
							</label>
						</p>
						<p class="ch-form-row">
							<input type="radio" value="beta" id="radio1b" name="version4">
							<label for="radio1b">
								Beta
							</label>
						</p>
					</div>
				</fieldset>

				<fieldset>
					<legend>Radio buttons required<em>*</em></legend>
					<div class="ch-form-options radio2">
						<p class="ch-form-row">
							<input type="radio" value="alpha" id="radio2a" name="version5">
							<label for="radio2a">
								Alpha
							</label>
						</p>
						<p class="ch-form-row">
							<input type="radio" value="beta" id="radio2b" name="version5">
							<label for="radio2b">
								Beta
							</label>
						</p>
					</div>
				</fieldset>

				<fieldset>
					<legend>Legend of radio group</legend>
					<div class="ch-form-options ch-form-required radio3">
						<h4 class="ch-form-subtitle">Radios required: <em>*</em></h4>
						<p class="ch-form-row">
							<input type="radio" value="alpha" id="radio3a" name="version6">
							<label for="radio3a">
								Alpha
							</label>
						</p>
						<p class="ch-form-row">
							<input type="radio" value="beta" id="radio3b" name="version6">
							<label for="radio3b">
								Beta
							</label>
						</p>
					</div>
				</fieldset>

				<fieldset>
					<div class="ch-form-options radio4">
						<p class="ch-form-row">
							<input type="radio" value="alpha" id="radio4a" name="version7">
							<label for="radio4a">
								Lorem ipsum dolor sit amet
							</label>
						</p>
						<p class="ch-form-row">
							<input type="radio" value="beta" id="radio4b" name="version7">
							<label for="radio4b">
								Beta
							</label>
						</p>
					</div>
				</fieldset>

				<fieldset>
					<legend>Textarea</legend>
					<p class="ch-form-row">
						<label for="textarea1">
							Textarea:
						</label>
						<textarea id="textarea1"></textarea>
					</p>

					<p class="ch-form-row ch-form-required">
						<label for="textarea2">
							Required: <em>*</em>
						</label>
						<textarea id="textarea2" required="required"></textarea>
					</p>

					<p class="ch-form-row ch-form-required ch-form-disabled">
						<label for="textarea3">
							Required disabled: <em>*</em>
						</label>
						<textarea id="textarea3" required="required" disabled="disabled"></textarea>
					</p>

					<p class="ch-form-row ch-form-disabled">
						<label for="textarea4">
							Disabled:
						</label>
						<textarea id="textarea4" disabled="disabled"></textarea>
					</p>
				</fieldset>

				<p class="ch-form-actions">
					<input type="submit" name="_eventId_confirmation" value="Webflow" class="ch-btn ch-primary">
					<!--input type="submit" value="Send" class="ch-btn ch-primary"-->
					<input type="reset" value="Cancel" class="ch-btn ch-btn-small">
					<a href="#" class="resetForm">Reset validations</a>
				</p>
			</form>
		</section>
	</body>
</html>
