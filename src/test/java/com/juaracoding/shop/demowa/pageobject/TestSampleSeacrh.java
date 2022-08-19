package com.juaracoding.shop.demowa.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.shop.demowa.drivers.DriverSingleton;
import com.juaracoding.shop.demowa.pages.SampleSearch;

public class TestSampleSeacrh {

	public static WebDriver driver;
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
	}
	
	@Test (priority = 1)
	public void testSampleSearchTersedia() {
		sampleSearch.clickBtnSearch();
		System.out.println(sampleSearch.getTxtLabelSearch());
		sampleSearch.getTxtSearch("Dress");
		scroll(250);
		System.out.println(sampleSearch.getTxtHasilSearchTersedia());
	}
	
	@Test (priority = 2)
	public void testSampleSearchKosong() {
		System.out.println();
		sampleSearch.clickBtnSearch();
		System.out.println(sampleSearch.getTxtLabelSearch());
		sampleSearch.getTxtSearch("Celana");
		scroll(250);
		System.out.println(sampleSearch.getTxtHasilSearchKosong());
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
