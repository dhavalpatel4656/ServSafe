package com.servsafe.framework.stepdefinition;

import org.testng.Assert;

import com.servsafe.constants.Constants;
import com.servsafe.framework.settings.ObjectRepo;
import com.servsafe.helper.PageObject.LoginPage;
import com.servsafe.helper.PageObject.NavigationPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginDef {
	private LoginPage lP = new LoginPage(ObjectRepo.driver);
	private NavigationPage nP = new NavigationPage(ObjectRepo.driver);

	@When("^user navigate to login page$")
	public void user_navigate_to_signup_page() throws Throwable {
		Constants.email = "dhaval.patelservsafe+051@gmail.com";
		nP.clickOnLoginOrCreateAccountButton();
	}

	@Then("^user should be reached on login page$")
	public void user_should_be_reached_on_login_page() throws Throwable {
		Assert.assertTrue(lP.verifyLoginPage());
	}

	@When("^user enter invalid email and password$")
	public void user_enter_invalid_email_and_password() throws Throwable {
		lP.enterUsername(Constants.email);
		lP.enterPassword("Automation@2021");
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		lP.clickOnLoginButton();
	}

	@Then("^user should not able to login$")
	public void user_should_not_able_to_login() throws Throwable {
		Assert.assertTrue(lP.verifyInvalidLoginMessageIsDisplayed());
	}

	@When("^user enter valid email and password$")
	public void user_enter_valid_email_and_password() throws Throwable {
		lP.enterUsername(Constants.email);
		lP.enterPassword(Constants.password);
	}

	@Then("^user should be able to login and reached to dashboard page$")
	public void user_should_be_able_to_login_and_reached_to_dashboard_page() throws Throwable {
		Assert.assertTrue(lP.verifyWelcomePageIsDisplayed());
	}
}