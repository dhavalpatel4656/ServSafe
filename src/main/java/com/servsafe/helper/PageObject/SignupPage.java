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
import com.servsafe.framework.helper.DropDown.DropDownHelper;
import com.servsafe.framework.helper.Generic.GenericHelper;
import com.servsafe.framework.helper.TextBox.TextBoxHelper;

public class SignupPage extends PageBase {

//	private WebDriver driver;

	private final static Logger log = LogManager.getLogger(SignupPage.class);
	private ButtonHelper bHelper;
	private TextBoxHelper tHelper;
	private DropDownHelper dHelper;
	private GenericHelper gHelper;
//	private WaitHelper wHelper;

	public SignupPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
		gHelper = new GenericHelper(driver);
//		wHelper = new WaitHelper(driver, ObjectRepo.reader);
		dHelper = new DropDownHelper(driver);
	}

	/** Web Elements */

	@FindBy(id = "emailToCheck")
	@CacheLookup
	private WebElement txtEmail;

	@FindBy(id = "doCheckUniquenessButton")
	@CacheLookup
	private WebElement btnSubmit;

	@FindBy(id = "givenName")
	@CacheLookup
	private WebElement txtFirstName;

	@FindBy(id = "sn")
	@CacheLookup
	private WebElement txtLastName;

	@FindBy(id = "emailType")
	@CacheLookup
	private WebElement drpEmail;

	@FindBy(id = "addressType")
	@CacheLookup
	private WebElement drpAddress;

	@FindBy(id = "address1")
	@CacheLookup
	private WebElement txtAddress1;

	@FindBy(id = "city")
	@CacheLookup
	private WebElement txtCity;

	@FindBy(id = "country")
	@CacheLookup
	private WebElement drpCountry;

	@FindBy(id = "internationalState")
	@CacheLookup
	private WebElement txtState;

	@FindBy(id = "zipCode")
	@CacheLookup
	private WebElement txtZipCode;

	@FindBy(id = "mobileCountry")
	@CacheLookup
	private WebElement drpMobileCountry;

	@FindBy(id = "phoneNumber")
	@CacheLookup
	private WebElement txtPhone;

	@FindBy(id = "jobRole")
	@CacheLookup
	private WebElement drpJobRole;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement txtPassword;

	@FindBy(id = "confirmPassword")
	@CacheLookup
	private WebElement txtConfirmPassword;

	@FindBy(id = "submitButton")
	@CacheLookup
	private WebElement btnCreateAccount;

	@FindBy(id = "Passcode")
	@CacheLookup
	private WebElement txtOTP;

	@FindBy(id = "submitBtn")
	@CacheLookup
	private WebElement btnCodeSubmit;

	By success = By.xpath("//*[contains(@class,'pass-box')]");

	@FindBy(xpath = "//*[text()='Go to My Account']")
	@CacheLookup
	private WebElement btnGoToMyAccount;

	public void enterEmail(String email) {
		tHelper.clearAndSendKeys(txtEmail, email);
		log.info(txtEmail);
	}

	public void enterFirstName(String firstName) {
		tHelper.clearAndSendKeys(txtFirstName, firstName);
		log.info(txtFirstName);
	}

	public void enterLastName(String lastName) {
		tHelper.clearAndSendKeys(txtLastName, lastName);
		log.info(txtLastName);
	}

	public void selectEmailType(String emailType) {
		dHelper.SelectUsingVisibleValue(drpEmail, emailType);
		log.info(drpEmail);
	}

	public void selectAddressType(String addressType) {
		dHelper.SelectUsingVisibleValue(drpAddress, addressType);
		log.info(drpAddress);
	}

	public void enterAddress1(String add1) {
		tHelper.clearAndSendKeys(txtAddress1, add1);
		log.info(txtAddress1);
	}

	public void enterCity(String city) {
		tHelper.clearAndSendKeys(txtCity, city);
		log.info(txtCity);
	}

	public void selectCountry(String country) {
		dHelper.SelectUsingVisibleValue(drpCountry, country);
		log.info(drpCountry);
	}

	public void enterState(String state) {
		tHelper.clearAndSendKeys(txtState, state);
		log.info(txtState);
	}

	public void enterZipCode(String zipCode) {
		tHelper.clearAndSendKeys(txtZipCode, zipCode);
		log.info(txtZipCode);
	}

	public void selectMobileCountry(String country) {
		dHelper.SelectUsingVisibleValue(drpMobileCountry, country);
		log.info(drpMobileCountry);
	}

	public void enterMobile(String mobile) {
		tHelper.clearAndSendKeys(txtPhone, mobile);
		log.info(txtPhone);
	}

	public void selectJobRole(String role) {
		dHelper.SelectUsingVisibleValue(drpJobRole, role);
		log.info(drpJobRole);
	}

	public void enterPassword(String password) {
		tHelper.clearAndSendKeys(txtPassword, password);
		log.info(txtPassword);
	}

	public void enterConfirmPassword(String password) {
		tHelper.clearAndSendKeys(txtConfirmPassword, password);
		log.info(txtConfirmPassword);
	}

	public void clickOnSubmitButton() {
		bHelper.click(btnSubmit);
		log.info(btnSubmit);
	}

	public void clickOnCreateAccountButton() {
		bHelper.click(btnCreateAccount);
		log.info(btnCreateAccount);
	}

	public void enterOTP(String otp) {
		tHelper.clearAndSendKeys(txtOTP, otp);
		log.info(txtOTP);
	}

	public void clickOnSubmitOTP() {
		bHelper.click(btnCodeSubmit);
		log.info(btnCodeSubmit);
	}

	public boolean verifyCodeIsSent() {
		return gHelper.IsElementPresentQuick(By.id("Passcode"));
	}

	public boolean verifyAccountIsCreatedAndActivated() {
		return gHelper.IsElementPresentQuick(success);
	}

}
