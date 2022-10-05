package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPageObject {
	public WebDriver sdriver;

	public searchPageObject(WebDriver rdriver) {
		sdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	@CacheLookup
	WebElement searchTextbox;
	
	@FindBy(xpath = "//button[@class='btn btn-default button-search']")
	@CacheLookup
	WebElement searchButton;
	
	public void sendSearchKey(String key) {
		searchTextbox.clear();
		searchTextbox.sendKeys(key);
	}

	public void clickSearchButton() {
		searchButton.click();
	}
	public String getCurrentTitle() {
		 return sdriver.getTitle().toString();
	}
}
