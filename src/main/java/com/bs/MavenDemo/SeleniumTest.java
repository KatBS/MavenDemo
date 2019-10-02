
package com.bs.MavenDemo;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SeleniumTest {
	private static final String BROWSERSTACK_USERNAME=System.getenv("BROWSERSTACK_USERNAME");
	private static final String BROWSERSTACK_ACCESS_KEY =System.getenv("BROWSERSTACK_ACCESS_KEY");


	public static void main(String[] args) throws MalformedURLException 
	{
		String URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserName", "iPhone");
	    caps.setCapability("device", "iPhone 8 Plus");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "11");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    System.out.println("Ran successfully");
	    System.out.println("Jenkins also configured ");
	    driver.quit();
	}
	
	
}
