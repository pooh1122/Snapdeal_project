Feature: Search a Product feature

 Background: User can access the search bar
   Given user is able to access the search bar

   @smoke
  Scenario: Verify that User can able to search valid product name
    Given The user is navigated to the SnapDeal website and the search bar is visible.
    When the user enters a valid product name in the search bar and hits the enter key.
    Then The search results page should display all the relevant products related to the entered product name.


    Scenario: Verify that user can able to search with multiple keywords
     Given The user is on the SnapDeal website and the search bar is visible.
     When The user enters multiple keywords in the search bar separated by space.
     Then The search results page should display all the relevant products related to the entered keywords.

    @smoke
    Scenario: Verify that user enters an special characters in search bar
    Given The user is navigated on to the SnapDeal website and the search bar is visible.
    When The user enters special characters in the search bar.
    Then The search results page should display relevant message indicating characters not found.

  @regression
    Scenario: Verify that user able to search without input
      Given the user is on the SnapDeal website and search bar is visible.
      When the user DoesNot enter the input and click on search bar.
      Then The Search bar should display all the valid results

    @test
    Scenario Outline: Verify that user is able to search for different products
      Given the user is on the SnapDeal website
      When the user enters "<product name>" in the search bar
      Then the search bar should display all the related results "<result>" .
      Examples:
          |  product name      | result |
          |  samsung mobiles   | We've got 10000+ results for samsung mobiles |
          |  data cards huawei | We've got 1 results for data cards huawei    |

