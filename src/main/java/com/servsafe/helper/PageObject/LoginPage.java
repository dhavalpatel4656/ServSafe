package com.servsafe.helper.PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.servsafe.framework.helper.BasePageObject.PageBase;
import com.servsafe.framework.helper.Button.ButtonHelper;
import com.servsafe.framework.helper.Generic.GenericHelper;
import com.servsafe.framework.helper.TextBox.TextBoxHelper;

public class LoginPage extends PageBase {

//	private WebDriver driver;

	private final static Logger log = LogManager.getLogger(LoginPage.class);
	private ButtonHelper bHelper;
	private TextBoxHelper tHelper;
//	private DropDownHelper dHelper;
	private GenericHelper gHelper;
//	private WaitHelper wHelper;

	public LoginPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
		gHelper = new GenericHelper(driver);
//		wHelper = new WaitHelper(driver, ObjectRepo.reader);
//		dHelper = new DropDownHelper(driver);
	}

	/** Web Elements */

	@FindBy(id = "username")
	@CacheLookup
	private WebElement txtUsername;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement txtPassword;

	@FindBy(xpath = "//*[@id='LoginButtonDiv']//a")
	@CacheLookup
	private WebElement btnLogin;

	By invalidLoginMsg = By.xpath(
			"//*[contains(text(),'We didn') and contains(text(),'recognize the username or password you entered')]");

	By welcomeMsg = By.xpath("//a[contains(text(),'Welcome')]");

	public void enterUsername(String username) {
		try {
			tHelper.clearAndSendKeys(txtUsername, username);
		} catch (Exception e) {
			tHelper.clearAndSendKeys(txtUsername, username);
		}
		log.info(txtUsername);
	}

	public void enterPassword(String password) {
		try {
			tHelper.clearAndSendKeys(txtPassword, password);
		} catch (Exception e) {
			tHelper.clearAndSendKeys(txtPassword, password);
		}
		log.info(txtPassword);
	}

	public void clickOnLoginButton() {
		try {
			bHelper.click(btnLogin);
		} catch (Exception e) {
			bHelper.click(btnLogin);
		}
		log.info(btnLogin);
	}

	public boolean verifyLoginPage() {
		return gHelper.IsElementPresentQuick(By.id("LoginButtonDiv"));
	}

	public boolean verifyInvalidLoginMessageIsDisplayed() {
		return gHelper.IsElementPresentQuick(invalidLoginMsg);
	}

	public boolean verifyWelcomePageIsDisplayed() {
		return gHelper.IsElementPresentQuick(welcomeMsg);
	}

}
