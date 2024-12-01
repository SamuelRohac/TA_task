package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

public class TestSetup {

    @Before
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\samue\\Desktop\\IBM\\chromedriver-win64\\chromedriver.exe"); // Path to ChromeDriver
        Configuration.browser = "chrome";         // Set Chrome as the default browser
        Configuration.browserSize = "1920x1080"; // Set default browser window size
        Configuration.timeout = 10000;           // Set default timeout (10 seconds)
        Configuration.headless = false;          // Run in headless mode (set to true if needed)
    }
}
