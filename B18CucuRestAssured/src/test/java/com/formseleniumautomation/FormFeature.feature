
Feature: Open the form and Fill the data

  Scenario: Testing user details on the Form
    Given launch the browser with application
    When user enter "Jyoti" as first name and "Patil" as lasst name
    When user enter "wakad" as address and "abc.com" as mail and "1234" as phnumber
    Then user select female as gender 
    When user check for select hobbies
    Then user select language
    Then user select "C" as skills
    When user select "India" as country
    Then user select "Hong Kong" as second country
    When user select "2000" as DOB year
    Then user select "September" as month
    Then user select "19" as day
    When user enter "selenium" as password
    When user enter "selenium" as confirm password
    
    