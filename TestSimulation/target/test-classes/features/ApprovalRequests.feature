Feature: Approval Requests

Scenario: Verify 0 items on the Approval Requests page
  Given the tester logs into the Salesforce application
    | Username | testautomationibm584@gmail.com |
    | Password | TestAutomation123!            |
  When the tester opens the App Launcher
  And the tester selects Approval Requests
  Then the tester verifies they land on the Approval Requests page
  And there is an "Items to Approve" header
  And there are 0 items
