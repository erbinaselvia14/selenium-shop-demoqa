package com.juaracoding.shop.demowa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.shop.demowa.drivers.DriverSingleton;

public class SampleWishlist {

	private WebDriver driver;

	//constructor
	public SampleWishlist() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='noo-product-item one noo-product-sm-4 not_featured post-1473 product type-product status-publish has-post-thumbnail product_cat-bodycon-dresses product_tag-bodycon-dresses product_tag-women has-featured first instock shipping-taxable purchasable product-type-variable']//div[@class='owl-item active']//img[@class='product-one-thumb']")
	private WebElement btnImage;
	
	//label[contains(@for, 'hobbies-checkbox')]
	//select[@id='pa_color']
	
	@FindBy(xpath = "//select[@id='pa_color']")
	private List<WebElement> listColor;
	
	@FindBy(xpath ="//select[@id='pa_size']")
	private List<WebElement> listSize;
	
	@FindBy (xpath = "//button[normalize-space()='Add to cart']")
	private WebElement btnAddCart;
	
	@FindBy(xpath = "//div[contains(@class,'noo-product-item noo-product-sm-4 not_featured post-1497 product type-product status-publish has-post-thumbnail product_cat-t-shirt product_tag-t-shirt product_tag-women has-featured first instock shipping-taxable purchasable product-type-variable')]//a[@class='add_to_wishlist single_add_to_wishlist']")
	private WebElement btnPertama;
	
	//div[@id='yith-wcwl-message']
	@FindBy(xpath = "document.querySelector(\"#yith-wcwl-message\")")
	private WebElement txtAdd;
	
	@FindBy(xpath = "//div[@class='yith-wcwl-add-to-wishlist add-to-wishlist-1491 exists wishlist-fragment on-first-load']//a[contains(text(),'Browse Wishlist')]")
	private WebElement btnKedua;
	
	
	public void getBtnImg() {
		btnImage.click();
	}
	
	public void pilihColor(int pilih) {
		listColor.get(pilih).click();
		System.out.println(listColor.get(pilih).getText());
	}
	
	public void pilihSize(int pilih) {
		listSize.get(pilih).click();
		System.out.println(listSize.get(pilih).getText());
	}
	
	public void getBtnAddCart() {
		btnAddCart.click();
	}
	
	public void btnList() {
		btnPertama.click();
	}
	
	public String getTxtAdd() {
		return txtAdd.getText();
	}
	
	public void btnListDua() {
		btnKedua.click();
	}
}
