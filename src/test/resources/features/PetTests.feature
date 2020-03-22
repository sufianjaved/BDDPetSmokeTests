Feature: Pet Tests

  Scenario: User is able to add pets to the system
    Given the Swagger PetStore API is available
    When I add a Pet to the system
    Then the pet request response has a 200 response code

  Scenario: User is able to delete pet
    Given a pet exists
    When I delete a pet
    Then the pet request response has a 200 response code
    And getting same pet request response has a 404 response code
    
  Scenario: User is able to update pet
    Given a pet exists
    When I update a pet
    Then the pet request response has a 200 response code
