Feature: Update pet

  @PutPet
  Scenario Outline: Update pet successfully.
    When I consume the endpoint "<endpoint>" and I send the user information id "<id>", Category "<nameCategory>" namePet "<namePet>"
    Then I can validate the response server <code>

    Examples:
      | id   | nameCategory | namePet    | endpoint | code |
      | 1100 | Samsung      | Shibba inu | /pet     | 200  |