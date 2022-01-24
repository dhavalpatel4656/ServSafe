package com.servsafe.framework.stepdefinition;

import org.testng.Assert;

import com.servsafe.constants.Constants;
import com.servsafe.framework.settings.ObjectRepo;
import com.servsafe.helper.PageObject.AddCartPage;
import com.servsafe.helper.PageObject.NavigationPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCartDef {
	private AddCartPage aP = new AddCartPage(ObjectRepo.driver);
	private NavigationPage nP = new NavigationPage(ObjectRepo.driver);

	@When("^user navigate to ServSafe Workplace$")
	public void user_navigate_to_ServSafe_Workplace() throws Throwable {
		nP.clickOnServSafeWorkplace();
	}

	@When("^user click on buy now$")
	public void user_click_on_buy_now() throws Throwable {
		aP.clickOnBuyNowLastProduct();
	}

	@When("^user add last product to cart$")
	public void user_add_last_product_to_cart() throws Throwable {
		Constants.lastProduct = aP.getProductName();
		aP.clickOnAddToCartLastProduct();
	}

	@When("^user navigate to cart$")
	public void user_navigate_to_cart() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getCartURL());
	}

	@Then("^user should be able to see added product in cart$")
	public void user_should_be_able_to_see_added_product_in_cart() throws Throwable {
		Assert.assertTrue(aP.verifyProductAdded(Constants.lastProduct));
	}

}