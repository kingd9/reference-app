Given /^I am on the add person page$/ do
  @page=AddPersonPage.new(@browser,true)
end

When /^I add a person$/ do 
  @page.add_person
end

Then /^I should see "(.*?)"$/ do |expected|
  @browser.text.should include expected
end


