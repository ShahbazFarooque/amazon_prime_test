Feature: Amazon Prime Test cases feature file
  Description: This purpose of feature file is to test Amazon prime test cases.

  @Login
  Scenario Outline: Verify able to Login to Amazon prime
    Given I am at home page of amazon prime "Welcome to Prime Video"
    When I click on user profile logo for login option
    And I click on sign in option from dropdown
    And I do login with email id "<email_id>" and "<password>"
    Then I verify is user logged in "<userName>"

    Examples: 
      | email_id  | password | userName  |
      | test@gmail.com |     Test@123 | Test |
      
      
 @SearchMovie
Scenario Outline: Verify able to Search for an movie
    Given I am at home page of amazon prime "Welcome to Prime Video"
    #When I click on user profile logo for login option
    #And I click on sign in option from dropdown
    #And I do login with email id "<email_id>" and "<password>"
    #Then I verify is user logged in "<userName>"
    And I click on search bar
    And I search for movie "<movieName>"
    Then I verify same movie is there or not "K.G.F Chapter 2 (Hindi)"

    Examples: 
      | email_id            |  password | userName | movieName     |
      | dapltest1@gmail.com |  Test@123 |   Test   | KGF Chapter 2 |
      
 @SearchMovieDescription
Scenario Outline: Verify able to go to movie detail page from search result page
    Given I am at home page of amazon prime "Welcome to Prime Video"
    #When I click on user profile logo for login option
    #And I click on sign in option from dropdown
    #And I do login with email id "<email_id>" and "<password>"
    #Then I verify is user logged in "<userName>"
    And I click on search bar
    And I search for movie "<movieName>"
    And I verify same movie is there or not "K.G.F Chapter 2 (Hindi)"
    And I click on searched movie "K.G.F Chapter 2 (Hindi)"
    And I verify user landed to movie description page "<movieDesc>"

    Examples: 
      | email_id            |  password | userName | movieName     | movieDesc |
      | dapltest1@gmail.com |  Test@123 |   Test   | KGF Chapter 2 |Vijendra Ingalgi, Son of Anand Ingalgi continues the story of KGF and Rocky in Chapter 2. Rocky survives the attack by Vanaram’s guards after killing Garuda. He is a hero and a saviour to the people of Narachi. While trying to fulfil his promise to his mother, he must face many obstacles in the form of Adheera, Inayat Khalil and Ramika sen.|
      
 @playVideo
Scenario Outline: Verify able to play the video
    Given I am at home page of amazon prime "Welcome to Prime Video"
    #When I click on user profile logo for login option
    #And I click on sign in option from dropdown
    #And I do login with email id "<email_id>" and "<password>"
    #Then I verify is user logged in "<userName>"
    And I click on search bar
    And I search for movie "<movieName>"
    And I verify same movie is there or not "K.G.F Chapter 2 (Hindi)"
    And I click on searched movie "K.G.F Chapter 2 (Hindi)"
    And I click on play video button
    And I close the play video
      
      Examples: 
      | email_id            |  password | userName | movieName     |
      | dapltest1@gmail.com |  Test@123 |   Test   | KGF Chapter 2 |
      
      
 
@latestMovieScroll
Scenario: Verify able to scroll to Latest movies section in Home page
    Given I am at home page of amazon prime "Welcome to Prime Video"
   	When I click on store
   	And I scroll to latest movie section
   	
   	
@latestMovieDesc
Scenario Outline: Verify able to scroll to Latest movies section in Home page
    Given I am at home page of amazon prime "Welcome to Prime Video"
   	When I click on store
   	And I scroll to latest movie section
   	And I click on first latest movie
   	And I verify user landed to movie description page "<movieDesc>"
   
   Examples:
   | movieDesc |
   |The world’s favorite blue hedgehog is back! Dr. Robotnik returns, this time with help from Knuckles, in search of a powerful emerald. Sonic, along with his new sidekick Tails, embarks on a journey to stop Dr. Robotnik's plans before it's too late.|