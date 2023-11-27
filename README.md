# SELENIUM FRAMEWORK

This test automation project is created for Web UI Testing, using Selenium framework.

Solution information
----------------------
The project is supposed to automate the proposed test cases (listed in below section).
The solution uses Maven for build compilation & dependency management. Extent report to generate clear, user readable & presentable reports.

Proposed Test cases for Automation:
----------------------
**UI Automation**
- End-to-end test as a final user adding a product to wish list.



Instructions to run locally:
----------------------
- Clone this project (https://github.com/nicolasmaranesi/baufestChallenge.git)
- Follow instructions from the project's readme file

Setup Instructions (Ubuntu)
----------------------

1. Download and install intelliJ (https://www.jetbrains.com/es-es/idea/download/#section=linux)
2. Clone this repo (Make sure you are on Master branch):
```
https://github.com/nicolasmaranesi/baufestChallenge.git
```
3. Install Java and set ENV using the following commands:
```
    * sudo apt-get update && apt-get -y install openjdk-17-jdk
    * export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/ echo $JAVA_HOME
```
4. Install Maven. (https://maven.apache.org/install.html).

5. Download Chrome (https://www.google.com/chrome/?brand=JJTC&gclid=CjwKCAjw9pGjBhB-EiwAa5jl3B09PARVNmdPk4EXaQ6OAxEkaFIojbqaahSiBPEKYpNxUS2LJ-EdERoC1O8QAvD_BwE&gclsrc=aw.ds)

6. Download the chromedriver accurate for your Chrome WebBrowser.(https://chromedriver.chromium.org/downloads).

7. Import cloned repo in intelliJ:
    - File->Import->Project from existing sources
    - Choose `baufestChallenge` folder

8. Move downloaded chromedriver to ./baufestChallenge/Drivers folder.

9.  In case needed, modify BaseUiTest.java (.SeleniumBaseProyect/src/test/java/Utils/BaseClass.java) with the new chromedriver path.


Run UI Automated Tests from IntelliJ / Terminal
----------------------
1. Navigate to 'baufestChallenge' folder from terminal window
2. Run following command -> ``` mvn clean test -DsuiteXmlFile=TestSuite.xml```




Reporting - Extent report
----------------------
1. From 'SeleniumBaseProyect' folder, navigate to 'report' folder from terminal
2. * In order to open the UI test report run the comand ```google-chrome UiTest.html```


3. An Extent report will open in browser with the last run report.

Tools/Tech stack
----------------------

- Maven
- Selenium
- TestNG
- Extent Reports
- Java
- IntelliJ
- Git
