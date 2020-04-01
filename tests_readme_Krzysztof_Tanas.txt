This file contains information about all the provided files and information how to run the tests.

  TestCase1.java   - Test file for a positive test case when a new user is successfully registered on the
                     automationpractice.com web page.
                     In this example, we create an account for a fictional person named "John Peter Smith".
                     Details on how exactly the test works are provided in comments inside the test's code.

  TestCase2.java   - Test file for a negative test case when the email address of a newly created user has
                     already been registered.
                     In this case an error is raised and the appropriate alert message appears.

  geckodriver.exe  - A file with Mozilla Firefox driver, which is used in the provided tests by default.

  chromedriver.exe - If you prefer to use Google Chrome, edit the code of test files to initialize
                     ChromeDriver instead of FirefoxDriver and set path to this file instead of
                     geckodriver.exe


  Tests were written in Java language with Selenium WebDriver in IntelliJ IDEA environment.


  To run a particular test case (TestCase1 or TestCase2) from there, perform the following steps:

   1. Create a Maven project in IntelliJ IDEA (or add the test files to an existing project)
   2. Click on the given test file in the project hierarchy tree, to see the test file
   3. Look at the test file, read it, as well as the comments which explain how exactly the given test works
      Change the path to the driver file in code of both tests to the one where the driver is installed on
      your computer.
   4. Select Run --> Edit Configurations in the IntelliJ IDEA toolbar.
   5. In the configuration, set "Test kind" to "Class" and type "TestCase1" or "TestCase2" in "Class" field.
      Click 'Apply' and then 'OK'.
   6. When ready, click on "Run" (the green triangular arrow in the upper right toolbar, or Shift+F10).

  The test is now running! Execute TestCase1 first, and if it was successful, then TestCase2 for the same
  email address of the created user, defined in the test's code.
  If TestCase1 was unsuccessful due to the given user's email being already registered on the
  automationpractice.com web page, change the user's email in TestCase1 to something else and repeat until
  TestCase1 successfully registers a new user, then define the same email address for TestCase2 and run it.


  Good luck in testing!
  