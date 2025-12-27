# ADFW Mobile App Automation Project

Automation framework for mobile app testing using Appium, Selenium, TestNG, Java, and Maven.

## Project Structure

- `src/main/java/pages` - Page classes for different screens of the mobile app  
- `src/main/java/tests` - Test classes containing TestNG test cases  
- `src/main/java/utils` - Utility classes (DriverFactory, ReportPrint, etc.)  
- `reports/` - Test execution reports  
- `screenshots/` - Screenshots captured during tests  
- `pom.xml` - Maven project configuration  
- `testng.xml` - TestNG suite configuration  

## How to Run

1. Install & setup Appium server  
2. Launch Android Emulator or connect a real device  
3. Open Eclipse IDE and import this Maven project  
4. Execute tests using TestNG suite (`testng.xml`)  
5. Check generated reports in `reports/` folder  

## Notes

- Ensure the device/emulator has the application installed  
- Screenshots are captured automatically for failed tests  
- Keep `reports/` and `screenshots/` folders ignored in Git (`.gitignore`)  

## Author

- Nitish
