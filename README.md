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

Project already set to CI CD by push or pull commit via file "main.yml" on folder workflow
SS git hub action on auto run test sebagai berikut: 
![image](https://github.com/user-attachments/assets/7631232e-8d02-4303-bbd1-4989ff8c000c)
![image](https://github.com/user-attachments/assets/23340f6d-cecc-45e8-8f21-5cd684c4cc2f)
![image](https://github.com/user-attachments/assets/22ac523e-7526-4a16-a3eb-19dcd9e73034)

