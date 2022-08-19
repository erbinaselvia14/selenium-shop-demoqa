package com.juaracoding.shop.demowa.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.shop.demowa.drivers.DriverSingleton;
import com.juaracoding.shop.demowa.pages.SampleSearch;
import com.juaracoding.shop.demowa.pages.SampleWishlist;

public class TestSampleWishlist {

	public static WebDriver driver;
	private SampleWishlist sampleWishList;
	private SampleSearch sampleSearch;
	
	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		sampleSearch = new SampleSearch();
		sampleWishList = new SampleWishlist();
	}
	
	@Test
	public void testSampleWishList() {
		sampleSearch.clickBtnSearch();
		System.out.println(sampleSearch.getTxtLabelSearch());
		sampleSearch.getTxtSearch("Dress");
		scroll(300);
		System.out.println(sampleSearch.getTxtHasilSearchTersedia());
		sampleWishList.getBtnImg();
		scroll(700);
		sampleWishList.pilihColor(1);
		sampleWishList.pilihSize(1);
		sampleWishList.getBtnAddCart();
	}
	
	@Test
	public void testWishList() {
		scroll(1000);
		sampleWishList.btnList();
		System.out.println(sampleWishList.getTxtAdd());
		delay(2);
		sampleWishList.btnListDua();
		System.out.println(sampleWishList.getTxtAdd());
	}
	
	@AfterClass
	public void closeBrowser() {
		delay(10);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertical+")");
	}

}
