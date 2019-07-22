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
4. Import data to use it in desktop app
5. etc


### About tests
I created tests for four scenarios which are the most basic for this application. They are:
1. Setup application with default accounts
2. Setup application without accounts
3. Create new account
4. Create new transaction

**!!!** To run a test your Android emulator should be up and running.

**!!!** You need to change path to your .apk file in Driver class
```sh
File appDir = new File(classpathRoot, "../../../Github Projects/GnucashAndroid");
```

For this test app I decided to try and use JUnit5 and Allure for reports as this tool provides very informative reports. 
Screenshoots are generated for all user click-actions to increase report readability.

Example: run test for creating an account
```sh
-Dtest=CreateAccountTest#createAccount test
```

### Test report
For reports I'm using Allure Reports. 
To create and run reports you need to execute following command after you completed the test:
```sh
allure:serve
```
This command will create a test report and open it in Google Chrome automatically.
