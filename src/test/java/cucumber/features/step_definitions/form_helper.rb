module FormHelper
	def enter_form_text(field,text)
		@browser.text_field(:id=>field).set(text)
	end
end