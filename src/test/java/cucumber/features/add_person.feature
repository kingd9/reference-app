Feature: Adding a Person
	As a user
	I want to be able to add information about myself
	So that I can allow others to search for me

Background:
	Given I am on the add person page

Scenario: Adding a person
	When I add a person
	Then I should see "Person Added"

