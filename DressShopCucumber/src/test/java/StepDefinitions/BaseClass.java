package StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.searchPageObject;
import PageObjects.loginPageObject;

public class BaseClass {
	public WebDriver driver;
	public searchPageObject searchPage;
	public loginPageObject loginPage;
	public static Logger logger;
	public Properties configProp;

	// Created for generating random string for Unique email
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	// Create Email dynamically
	public static String randomEmail() {
	String emailAddress = "";
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	while(emailAddress.length()<5)
	{
		int character = (int) (Math.random() * 26);
		emailAddress += alphabet.substring(character, character + 1);
		emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
	}
	return emailAddress+"@gmail.com";
}
}
