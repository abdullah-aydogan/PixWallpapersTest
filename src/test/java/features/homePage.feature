Feature: Home Page Test Senarios

  Background: Go to Home Page
    Given See notification permission window
    When Skip notification permission window
    Then Check that the home page opens

  Scenario: Add a Random Image to Favorites
    Given Get count of images listed
    When Click the heart icon of a random image
    When Switch to the favorites tab
    Then Check that the favorites list appears

  Scenario: Switch to Favorites Tab Without Adding Images to Favorites
    When Switch to the favorites tab
    Then Check that the empty favorites list appears

  Scenario Outline: Search for Wallpaper
    When Click on the search icon
    When Type blue in the EditText field
    Then Check the search result "<Result>"
    Examples:
    |Result|
    |Sonuc bulundu|

  Scenario Outline: Search for Invalid Wallpaper
    When Click on the search icon
    When Type dsd in the EditText field
    Then Check the search empty result "<Result>"
    Examples:
    |Result|
    |Sonuc bulunamadi|