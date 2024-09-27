Feature: Passing multiple parameters to the same step

  @jaad @ListOfMap2
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searches the following item
      | items        |
      | java         |
      | selenium     |
      | cucumber bdd |
      | sql          |
      | nadir        |
      | zahid        |
      | anna         |
      | jaad         |
# spaces between | | do NOT matter
  # spaces in steps DO matter
  #When we want first one to be header we will use MAP