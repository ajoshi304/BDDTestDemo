@Smoke
Feature:  Request and response Functionality
  This feature covers all areas provided by reqres module


  @getsingleuser
  Scenario: Get a single User
    Given user sets the specification
   # When  user hits the getsingleuser endpoint for the http get method
   # When user hits the '/users/2' endpoint for the http 'get' method
    When user hits the 'GETSINGLEUSER' endpoint for the http 'get' method
    Then user receives the response from the server
    And  user validates the status code is matching 200
   # And  check whether the "data.first_name" is matching the value "Janet"
    #And  check whether the "data.last_name" is matching the value "Weaver"

    @getallusers
    Scenario: Get all users
      Given user sets the specification
     # When user hits the getallusers endpoint for the http get method
      #When user hits the '/users?page=2' endpoint for the http 'get' method
      When user hits the 'GETALLUSERS' endpoint for the http 'get' method
      Then user receives the response from the server
      And user validates the status code is matching 200

        @createanewuser
        Scenario Outline: : Create a new user
          Given user sets the specification
          And user sends the payload for the post in the below format
          |name|job|
          |<name>|<job>|

         # When user hits the createnewuser endpoint for the http post method
          #When user hits the '/users' endpoint for the http 'post' method
          When user hits the 'CREATEUSER' endpoint for the http 'post' method
          Then user receives the response from the server
          And user validates the status code is matching 201

          Examples:
          |name|job|
          |morpheus|leader|
          |bill    |ceo   |
          |steve   |cfo   |

