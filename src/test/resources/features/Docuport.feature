Feature: Different functions of Docuport

  @day20 @ui
  Scenario: Change Rows Per Page for advisor
    Given user is on docuport homepage of "advisor"
    Then user clicks "Leads" button
    And rows per page shows by default 10 at "page"
    And change rows per page to 5
    And user clicks "Users" button
    And rows per page shows by default 10 at "page"
    And change rows per page to 5


  @day21 @ui
  Scenario Outline: Change Rows Per Page for advisor/supervisor
    Given user is on docuport homepage of "<role>"
    Then user clicks "Leads" button
    And rows per page shows by default 10 at "page"
    And change rows per page to 5
    And user clicks "Users" button
    And rows per page shows by default 10 at "page"
    And change rows per page to 5
    Examples:
      | role       |
      | advisor    |
      | supervisor |


  @day21 @ui @employee
  Scenario Outline: Change Rows Per Page for employee
    Given user is on docuport homepage of "<role>"
    Then user clicks "Users" button
    And rows per page shows by default 10 at "page"
    And change rows per page to 5
    Examples:
      | role       |
      | employee    |
