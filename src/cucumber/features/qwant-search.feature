Feature: Qwant text search

Scenario: Valid phrase search using https://www.qwant.com/
Given An url https://www.qwant.com opened in browser
When Search phrase <<Quo Vadis>> typed into search input box
And Search button clicked
Then First 3 results contain phrase <<Quo Vadis>>
