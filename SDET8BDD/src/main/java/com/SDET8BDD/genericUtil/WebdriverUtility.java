package com.SDET8BDD.genericUtil;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class WebdriverUtility {

	public void switchToWindow(WebDriver driver,String partialTitle) {
		Set<String> id=driver.getWindowHandles();
		for(String sid:id) {
			driver.switchTo().window(sid);
			String pageTitle = driver.getTitle();
			if(pageTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void selectDD(WebElement element,DropDown dropdownType,String option) {
		Select sel=new Select(element);
		switch (dropdownType) {
		case VISIBLETEXT:
			sel.selectByVisibleText(option);
			break;
		case INDEX:
			sel.selectByIndex(Integer.parseInt(option));
			break;
		case VALUE:
			sel.selectByValue(option);
			break;
		default:
			System.out.println("select valid dropdown type");
			break;
		}
	}
	
	public void moveToElement(WebDriver driver,WebElement element) {
		new Actions(driver).moveToElement(element).perform();
		
	}
	
	public void getScreenshot(WebDriver driver,String scenarioName) throws IOException {
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		File src=event.getScreenshotAs(OutputType.FILE);
		File dest=new File(IConstant.screenshotPath+scenarioName+".png");
		Files.copy(src, dest);
	}
	public static int randomInt() {
		Random ran=new Random();
		return ran.nextInt(1000);
	}
}
