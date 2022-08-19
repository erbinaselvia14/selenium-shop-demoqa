package com.juaracoding.shop.demowa.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.juaracoding.shop.demowa.drivers.startegies.DriverStrategy;
import com.juaracoding.shop.demowa.drivers.startegies.DriverStrategyImplementer;
public class DriverSingleton {

	// membuat modifier
	private static DriverSingleton instance = null;
	private static WebDriver driver;

	// membuat constractur
	private DriverSingleton(String driver) {
		instantiate(driver);
	}

	// untuk memilih web browsernya
	public WebDriver instantiate(String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();

		// ketika sudah memilih web browsernya, untuk menunggu waktu di selenium
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// untuk membuat web browser maximize
		driver.manage().window().maximize();

		return driver;
	}

	public static DriverSingleton getInstance(String driver) {
		if (instance == null) {
			instance = new DriverSingleton(driver);
		}
		return instance;
	}

	// method untuk memanggil web drivernya
	public static WebDriver getDriver() {
		return driver;
	}
}
