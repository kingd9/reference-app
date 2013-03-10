class AddPersonPage
	include PageObject
	DEFAULT_DATA={
		'first_name'=>Faker::Name.first_name,
		'last_name'=>Faker::Name.last_name,
		'email'=>Faker::Internet.email
	}
	page_url  'http://localhost:8080/reference-app/person/add/'
	
	text_field(:first_name,:id=>"firstName")
	text_field(:last_name,:id=>"lastName")
	text_field(:email,:id=>"email")
	
	button(:save,:value=>"Save")
	
	def add_person(data={})
		populate_page_with DEFAULT_DATA.merge(data)
		save
	end
end