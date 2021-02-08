Feature: Search for Batman movies
	User should be able to search for Batman movies and look at results
	
Scenario: Login in to account with correct details
	Given Open browser in http://localhost:3000/shows
	And Enter a text in search box with text "batman"
	And Press button search
	And Navigate to the url that is show in second card of results
	And Navigate back using browser features
	And Change css background color to #4a148c to card with title Batman Unlimited
	When Press back button
	Then Make sure that input for search is empty
	