# Otomasi Tes Api & WebUI

Object API Test = https://reqres.in/api/
Object WebUI Test = https://www.saucedemo.com/v1/

Language = Java
JDK = Oracle GraalVM 17.0.12 - version 17
Framework Testing = JUnit
Testing Library = RestAssured, AssertJ-Core, Cucumber, Selenium

How to Run =
1. via IntellijIDEA : open project> run project from file feature "api.feature" to run API testing; run project from file feature "web.feature" to run WebUI testing

2. via Terminal : go to project directory "Otomasi-tes-API-WebUI" > type "./gradlew apiTest" to run API testing; type "./gradlew webTest" to run WebUI testing