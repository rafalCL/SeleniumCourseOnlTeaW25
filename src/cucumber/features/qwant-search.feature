Feature: Qwant text search

Scenario: Valid phrase search using https://www.qwant.com/
Given An url https://www.qwant.com opened in browser
When Search phrase Quo Vadis typed into search input box
And Search button clicked
Then First 3 results contain phrase Quo Vadis

# above scenario left for comparison

Scenario Outline: Valid phrase search using https://www.qwant.com/
Given An url https://www.qwant.com opened in browser
When Search phrase <searchPhrase> typed into search input box
And Search button clicked
Then First <meaningfulCount> results contain phrase <searchPhrase>
Examples:
  |searchPhrase         |meaningfulCount|
  |W pustyni i w puszczy|3              |
  |Quo Vadis            |3              |
  |Liga włoska          |2              |
