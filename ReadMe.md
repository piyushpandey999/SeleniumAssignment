# ReadMe

1. Download the project and open it in Eclipse or IntelliJ.
2. All the dependencies are in the pom.xml and automatically downloaded when the project is built.
3. All the global data is stored under the config file such as browser name, mode, base URL etc.
4. To change the browser simply change the browser name in config.properties.
5. Setup Page file under the Base package contains code to initialize the browser and open base URL.
6. Pages package contains different page files for each test case which contains the xpath of the elements and the methods that performs operation on that element.
7. Utilities package contains DataProviderClass, Listeners, ReadExcelData, ReadingPropertiesFile, ScreenShots files.
8. DataProviderClass is used to pass the data to the test case.
9. Listeners class contains methods that run for different events like when test case passes,finished,failed etc.
10. ReadExcelData class is used to read the data from the Excel file.
11. Reading Properties file is used to read the data from config.properties file.
12. Screenshot file is used to take the screenshots where the test cases failed.
13. Resources folder contains Driver folder which contains chrome, edge, Firefox driver and Data.xlsx contains the login credentials of the user.
14. All the test cases are stored in the com.assignment.TestCases package under the test directory.
15. Logs are implemented in the test cases using Log4j.
16. Test report is being created after running the test cases in the Test-Reports directory.
17. Screenshot of the failed test case is generated in the Screenshots folder.
18. To run the Tests, you can either run the tests separately or you can run the testng.xml to run all the testcases at once.