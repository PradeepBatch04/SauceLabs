Feature: FitPeo

Scenario: Adjust the Slider
When Navigate to the "Revenue Calculator" Page
Then verify screen navigate to the Revenue Calculator page
And Scroll to revenue calculator slider
When Adjust the slider to 820
Then bottom text field value should be updated to 820
When Enter the value 560 in the text field
Then verify slider's position is updated to 560.