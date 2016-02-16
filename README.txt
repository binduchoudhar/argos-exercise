Read me:

1. Created a maven java project to get the JSON response from server side, and then display the JSON output on HTML5 grid.
2. pom.xml is the starting point for this exercise. 2 maven plugins being used - 1) to compile the code 2) build the war artifact. Dependency with Junit and JSON library added in this pom.
3. ArgosRESTService.java: this is the main service to get the JSON output from server side. This service calls the ExtractData class to extract data from HUKD data and then convert into JSON output. It is having methods - 1) test the service connectivity 2) and the other one is the main service method to get the JSON output.
4. ExtractData.java: this is the class read the data from HUKD xml and then set into list of product beans. after that, list of product beans has been converted into JSON output.
5. Product.java: POJO for the product details. Argos product has been set as 500 as there is no database connectivity being used in this exercise.
6. Web.xml: this is the file to map servlet for this exercise.

Pending work:
1. Remove constant value for Argos price and use database instead.
2. Prepare HTML5 and Javascript files to display JSON output.


