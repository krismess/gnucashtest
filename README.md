# Automated test for Gnucash application

**Requirements:**
Appium, NodeJS and Android SDK must be installed. 

For tests I used Java 8 + JUnit5 + Appium + Allure Reports

### App discription

GnuCash is a powerful financial manager application which also has a mobile app for Android devices. 

In this app user can:
1. Setup application with default/custom or imported accounts
2. Create accounts with complex hierarchy and customize them
3. Create transactions between accounts
4. Import data to use it in a desktop app
5. Expenses reports
6. etc

As Android app doesn't have all function of Desktop version we can consider it as an additional application which main functions are creating accounts and transactions and exporting it to csv/qif/xml file, which later can be used by a desktop application. I think these features are the most important from the business point of view. 

Also, this application has complex hierarchy of accounts and transactions between them, so it's important to carefully test their workflow. 

Testing UI/UX is also very important as this application has not very intuitive and obvious navigation between screens which is resulting in bad user experience.

For test automation of this application, I can suggest a close work with developers, as its not the most 'test-friendly' application. There some difficulties with detecting element from the list of elements and getting some of their parameters for assertions, which can be solved by, for example, adding an id to the element.

### Automated scenarios
I created tests for four scenarios which are the most basic for this application. They are:
1. Setup application with default accounts
2. Setup application without accounts
3. Create a new account
4. Create a new transaction

**!!!** To run a test your Android emulator should be up and running.

**!!!** You need to change path to your .apk file in Driver class
```sh
File appDir = new File(classpathRoot, "../../../Github Projects/GnucashAndroid");
```

For this test app, I decided to try and use JUnit5 and Allure for reports as this tool provides very informative reports. 
Screenshots are generated for all user click-actions to increase report readability.

Example: run test for creating an account
```sh
-Dtest=CreateAccountTest#createAccount test
```

### Test report
For reports, I'm using Allure Reports. 
To create and run reports you need to execute the following command after you completed the test:
```sh
allure:serve
```
This command will create a test report and open it in Google Chrome automatically.



#### ToDo list
1. Refactor the code: need to change driver from being static to run several tests
2. Maybe change JUnit5 to TestNG
3. logging
4. create solution to run tests in cloud
