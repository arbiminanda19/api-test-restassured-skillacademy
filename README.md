# api-test-with-param

Tools Used: Maven, Java, rest-assured, TestNG, json-simple

This is automation API test for endpoint [this url](https://skillacademy.com/api/skillacademy/discovery/search)

# Setting up and running tests

* Open project as Maven Project in Eclipse, Intellij, or other IDE
* Run TestAPI.java file using TestNG. The directory file:
```
{YourProjectPath}/src/test/java/apiTestRunner
```
* In that file, there is a scenario API test that consists of several test case:
	* Test Case 1, to get basic search results 
	* Test Case 2, to get search result with set page parameter
	* Test Case 3, to get search result with price filter
	* Test Case 4, to get search result with duration filter
	* Test Case 5, to get sorted search result
	* Test Case 6, to get search result with all parameter
