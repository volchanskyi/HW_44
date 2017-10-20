package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Common {

    static WebDriver driver;

    public static void open(String url) {
	String USERAGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:55.0) Gecko/20100101 Firefox/55.0";
	Logger.getLogger("").setLevel(Level.OFF);

	driver = new HtmlUnitDriver();
	((HtmlUnitDriver) driver).setJavascriptEnabled(true);
	((HtmlUnitDriver) driver).getBrowserVersion().setUserAgent(USERAGENT);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get(url);
	System.out.println(
		"UserAgent: " + (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;"));
	System.out.println("Page URL: " + driver.getCurrentUrl());

    }

    public static void quite() {
	driver.quit();
    }

    public static boolean isPresent(By by) {
	if (driver.findElements(by).size() > 0)
	    return true;
	else
	    return false;
    }

    public static boolean isVisible(By by) {
	if ((driver.findElements(by).size() > 0) && driver.findElement(by).isDisplayed())
	    return true;
	else
	    return false;
    }

    private static By getEl(String elem) {
	return Locators.getMylist().get(elem);
    }

    public static void validatePage(int test_case, String el) {
	System.out.println(Locators.getElems()[test_case] + (Common.isPresent(getEl(el)) ? "Exists" : "Not exist"));
    }

}
