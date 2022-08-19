package com.juaracoding.shop.demowa.pages;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.shop.demowa.drivers.DriverSingleton;

public class SampleSearch {

	private WebDriver driver;

	//constructor
	public SampleSearch() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='noo-search']")
	private WebElement btnSearch;
	
	@FindBy(xpath = "//label[@class='note-search']")
	private WebElement txtLabelSearch;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement txtSeacrh;
	
	@FindBy(xpath = "//p[@class='woocommerce-result-count']")
	private WebElement txtHasilSearchTersedia;
	
	@FindBy(xpath = "//p[@class='woocommerce-info']")
	private WebElement txtHasilSearchKosong;
	
	public void clickBtnSearch() {
		btnSearch.click();
	}
	
	public String getTxtLabelSearch() {
		return txtLabelSearch.getText();
	}
	
	public void getTxtSearch(String katakunci) {
		txtSeacrh.sendKeys(katakunci, Keys.ENTER);
	}
	
	public String getTxtHasilSearchTersedia() {
		return txtHasilSearchTersedia.getText();
	}
	
	public String getTxtHasilSearchKosong() {
		return txtHasilSearchKosong.getText();
	}
}
