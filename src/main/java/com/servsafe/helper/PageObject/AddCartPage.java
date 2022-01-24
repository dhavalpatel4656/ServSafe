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
import com.servsafe.framework.helper.TextBox.TextBoxHelper;

public class AddCartPage extends PageBase {

//	private WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(AddCartPage.class);
	private ButtonHelper bHelper;
	private TextBoxHelper tHelper;
	private GenericHelper gHelper;

	public AddCartPage(WebDriver driver) {
		super(driver);
//		this.driver = driver;
		bHelper = new ButtonHelper(driver);
		tHelper = new TextBoxHelper(driver);
		gHelper = new GenericHelper(driver);
	}

	/** Web Elements */

	@FindBy(xpath = "(//*[text()='Buy Now'])[last()]")
	@CacheLookup
	private WebElement buyNowLastProduct;

	@FindBy(xpath = "(//*[text()='Add to Cart'])[last()]")
	@CacheLookup
	private WebElement addToCartLastProduct;

	@FindBy(id = "btnRemove")
	@CacheLookup
	private WebElement btnRemove;

	@FindBy(xpath = "(//*[@class='productlistrow']//*[@class='title']//a)[last()]")
	@CacheLookup
	private WebElement getProductName;

//	private String commonText = "//*[text()='%s']";

	private By cartList = By.xpath("//*[@id='Surge-Cart-Items']");

	public void clickOnBuyNowLastProduct() {
		bHelper.click(buyNowLastProduct);
		log.info(buyNowLastProduct);
	}

	public void clickOnAddToCartLastProduct() {
		bHelper.click(addToCartLastProduct);
		log.info(addToCartLastProduct);
	}

	public void clickOnRemoveProduct() {
		bHelper.click(btnRemove);
		log.info(btnRemove);
	}

	public String getProductName() {
		return tHelper.getText(getProductName);
	}

	public boolean verifyProductAdded(String lastProduct) {
		return gHelper.IsElementPresentQuick(cartList);
	}
}
