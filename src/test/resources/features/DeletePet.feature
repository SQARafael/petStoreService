Feature: Delete pet

  @DeletePet
  Scenario Outline: Delete pet successfully.
    When I consume the endpoint "<endpoint>" and I send the id "<id>"
    Then I can validate the message "<message>"
    Examples:
      | endpoint | id     | message |
      | /pet     | 353502 | 353502  |