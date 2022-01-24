package com.servsafe.framework.list;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.servsafe.framework.helper.Generic.GenericHelper;
import com.servsafe.framework.helper.Logger.LoggerHelper;
import com.servsafe.framework.settings.ObjectRepo;

public class ListHelper extends GenericHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(ListHelper.class);

	public ListHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		oLog.debug("ListHelper : " + this.driver.hashCode());
	}

	public void locateRecordAndCLick(By List, String Text, By elementToClick) throws InterruptedException {
		// System.out.println(Text +" to match");
		List<WebElement> list = driver.findElements(List);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contentEquals(Text)) {
				System.out.println("match");
				driver.findElement(elementToClick).click();
				// Assert.assertEquals(Text, list.get(i).getText());
				break;
			}
		}
	}

	public void clickByAction(By Xpath) {
		WebElement element = driver.findElement(Xpath);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
	}

	public void clickHideenTry(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public List<WebElement> getList(By by) {
		return ObjectRepo.driver.findElements(by);
	}
}
