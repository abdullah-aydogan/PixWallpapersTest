Feature: Detail Page Test Senarios

  Background: Open Home Page
    Given Check notification permission window
    When Skip notification window
    Then Check that the home page

  Scenario: Click On a Random Image
    Given Get count images
    When Click on the random image from the list
    When Click on the information button
    When Check that the information screen appears
    When Click outside
    When Click on the apply button
    When Check that the apply screen appears
    When Click the cancel button
    When Click the close button
    Then Check return home page
