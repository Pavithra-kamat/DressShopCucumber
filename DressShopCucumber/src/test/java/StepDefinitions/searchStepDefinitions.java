package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import PageObjects.searchPageObject;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class searchStepDefinitions extends BaseClass {
	//public searchPageObject searchObj;
	//WebDriver driver;

	@Before
	public void setup() throws IOException {
		// Logger
		logger = Logger.getLogger("DressShop"); // Added logger
		PropertyConfigurator.configure("Log4j.properties");// Added logger

		// Reading properties
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);

		String br = configProp.getProperty("browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}

		logger.info("******** Launching browser*********");
		//System.setProperty("webdriver.chrome.driver",
		//		"C:\\Users\\pavit\\eclipse-workspace\\DressShopCucumber\\src\\test\\resources\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();

	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		logger.info("******** Launching Search Page*********");
		searchPage = new searchPageObject(driver);
	}

	@Then("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Then("Enter {string} in search box")
	public void enter_in_search_box(String key) {
		logger.info("******** Passing search key*********");
		searchPage.sendSearchKey(key);

	}

	@Then("Click on Search icon")
	public void click_on_search_icon() {
		logger.info("******** Clicking the search button *********");
		searchPage.clickSearchButton();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		// String actualUrl=driver.getTitle().toString();
		logger.info("******** Checking the search page title *********");
		String actualTitle = searchPage.getCurrentTitle();
		System.out.println("The curent page Title is :" + actualTitle);
		Assert.assertEquals(expectedTitle.toString(), actualTitle);
		

	}

}
