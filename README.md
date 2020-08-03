# trade-republic-test

This repository meant for trade republic QA Automation Test.

**Note**: Project has some additional unused dictionaries and script files. These are added to give the skeleton view of the automation framework

## Short summary
- As I don't posses the experience of automating web socket, So I choose API + web automation
- I choose `Yahoo finance` for automation, they provide both API & web application and it's closed related to trade republic business
- The topic I selected is `Trending Tickers`

## Test cases automated:
   1. Get the list of United States top tending tickers using yahoo finance API (API Test case)
   2. Get the list of France top tending tickers using yahoo finance API (API Test case)
   3. Verify the trending tickers dashboard displayed in the yahoo finance web page (UI test case)
   4. Verify the trending tickers list fetched from api matches with the dashboard details on web page (business use case)

## Technical details

- Automation          : API, Web
- Tool                : Rest assured, Selenium
- Scripting language  : Groovy
- Build tool          : Gradle

## Implementation included

- TDD (TestNG)
- Docker configuration
- Logging (Allure)
- HTML reporting (Allure)
- Version control (git)

## Prerequisites

- Project has been developed using groovy. Java has to be installed on the machine.
- java (1.8.0_261 recommended)
- gradle (required if you want to run from gradle clean test. 6.5.1 recommended)
- git (optional)

## Running the tests

- To download run from command line:
  1. Download the project from git
  2. Unzip the downloaded file
  3. CD to project folder (trade-republic-test)
  4. run the command `gradle clean Test` on cmd
  
- To clone and run the build from an IDE:
  1. `git clone https://github.com/rajnavakoti/trade-republic-test.git`
  2. open the project in any IDE
  3. run build.gradle
  4. or run full.xml (/test/resources/suites)
  
- Project is ready to run on jenkins and docker


### Project Structure:

    - Root\
       - src\
         - main\
            - groovy
               - com.yahoofinance\
                  - api
                  - gui
                  - wss
                  - utils             
            - resources\
               - schemas
              - confifuration file
         - test\
            - groovy\
               - com.yahoofinance\
                  - api
                  - gui
                  - wss
                  - usecases
            - resources\
               - suites
                  - full.xml
                  
## paths
 - Test cases       : `/src/test/groovy/`
 - Test suites      : `/src/test/resources/suites/`
 - Test screenshots : `/screenshots`
 - Test reports     : `/build/test-results/test/*.xml`

###### Scripting best practices implemented in the framework:
    - Class names: camel cassing
    - method,variable names: pascal cassing
	- Documentation: @story, @step
	- Logging & Reporting: Allure html test report
	- 1 liner indentation
	- Suite setup and teardown mandatory for every test file
	- Config/variable/data files usage