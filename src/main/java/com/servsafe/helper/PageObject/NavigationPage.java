package com.servsafe.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.servsafe.framework.helper.BasePageObject.PageBase;
import com.servsafe.framework.helper.Button.ButtonHelper;
import com.servsafe.framework.helper.Generic.GenericHelper;
import com.servsafe.framework.helper.Logger.LoggerHelper;

public class NavigationPage extends PageBase {

//	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(NavigationPage.class);
	private ButtonHelper bHelper;
	private GenericHelper gHelper;

	public NavigationPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		bHelper = new ButtonHelper(driver);
		gHelper = new GenericHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "//div[@class='masthead-top-nav-right']//*[text()='Login / Create Account']")
	@CacheLookup
	private WebElement btnLoginOrCreateAccount;

	@FindBy(id = "createAccount-Btn")
	@CacheLookup
	private WebElement btnCreateAccount;

	@FindBy(xpath = "//*[text()='Close Window']")
	@CacheLookup
	private WebElement btnClose;

	@FindBy(xpath = "//*[@aria-label='Main navigation']//*[text()='ServSafe Workplace']")
	@CacheLookup
	private WebElement menuServSafeWorkplace;

	public void clickOnLoginOrCreateAccountButton() {
		bHelper.click(btnLoginOrCreateAccount);
		log.info(btnLoginOrCreateAccount);
		if (gHelper.IsElementPresentQuick(By.xpath("//*[text()='Close Window']")))
			bHelper.click(btnClose);
	}

	public void clickOnCreateAccountButton() {
		bHelper.click(btnCreateAccount);
		log.info(btnCreateAccount);
	}

	public void clickOnServSafeWorkplace() {
		bHelper.click(menuServSafeWorkplace);
		log.info(menuServSafeWorkplace);
	}

}
