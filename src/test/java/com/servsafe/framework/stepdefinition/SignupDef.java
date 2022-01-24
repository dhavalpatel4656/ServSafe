package com.servsafe.framework.stepdefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;

import com.servsafe.constants.Constants;
import com.servsafe.framework.settings.ObjectRepo;
import com.servsafe.framework.utility.EmailHelper;
import com.servsafe.helper.PageObject.NavigationPage;
import com.servsafe.helper.PageObject.SignupPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignupDef {
	private SignupPage sP = new SignupPage(ObjectRepo.driver);
	private NavigationPage nP = new NavigationPage(ObjectRepo.driver);
	private String firstName = "Auto_" + RandomStringUtils.randomAlphabetic(3);
	private String lastName = "Auto_" + RandomStringUtils.randomAlphabetic(3);
	private String address1 = "Auto_" + RandomStringUtils.randomAlphabetic(10);
	private String mobile = "94" + RandomStringUtils.randomNumeric(8);
	private String otp;

	@Given("^user open servsafe url in browser$")
	public void user_open_servsafe_url_in_browser() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getURL());
	}

	@When("^user navigate to signup page$")
	public void user_navigate_to_signup_page() throws Throwable {
		nP.clickOnLoginOrCreateAccountButton();
		nP.clickOnCreateAccountButton();
	}

	@When("^user enter an email address$")
	public void user_enter_an_email_address() throws Throwable {
		Constants.email = ObjectRepo.reader.getGmailID().split("@")[0] + "+" + RandomStringUtils.randomNumeric(3)
				+ "@gmail.com";
		sP.enterEmail(Constants.email);
		sP.clickOnSubmitButton();
	}

	@Then("^user should be reached on signup page$")
	public void user_should_be_reached_on_signup_page() throws Throwable {
		String title = ObjectRepo.driver.getTitle();
		System.out.println(title);
	}

	@When("^user fill required data for create a new account$")
	public void user_fill_required_data_for_create_a_new_account() throws Throwable {
		sP.enterFirstName(firstName);
		sP.enterLastName(lastName);
		sP.selectEmailType("Work");
		sP.selectAddressType("Business");
		sP.enterAddress1(address1);
		sP.selectCountry("India");
		sP.enterCity("Ahmedabad");
		sP.enterState("Gujarat");
		sP.enterZipCode("380001");
		sP.selectMobileCountry("+91 (India)");
		sP.enterMobile(mobile);
		sP.selectJobRole("Student");
		sP.enterPassword(Constants.password);
		sP.enterConfirmPassword(Constants.password);
	}

	@When("^user click on submit button$")
	public void user_click_on_submit_button() throws Throwable {
		sP.clickOnCreateAccountButton();
	}

	@Then("^verification code is sent to and email entered$")
	public void verification_code_is_sent_to_and_email_entered() throws Throwable {
		Assert.assertTrue(sP.verifyCodeIsSent());
	}

	@Given("^user fetch verification code from email$")
	public void user_fetch_verification_code_from_email() throws Throwable {
		otp = EmailHelper.check(ObjectRepo.reader.getGmailHost(), ObjectRepo.reader.getGmailStoreType(),
				ObjectRepo.reader.getGmailID(), ObjectRepo.reader.getGmailPassword());
	}

	@Given("^enter verification code$")
	public void enter_verification_code() throws Throwable {
		sP.enterOTP(otp);
		sP.clickOnSubmitOTP();
	}

	@Then("^new account should be created$")
	public void new_account_should_be_created() throws Throwable {
		Assert.assertTrue(sP.verifyAccountIsCreatedAndActivated());
	}

}