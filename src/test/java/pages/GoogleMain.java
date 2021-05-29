package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GoogleMain extends Base {
	private static final Logger logger = LogManager.getLogger(GoogleMain.class);

	public GoogleMain(WebDriver driver) {
		super(driver);
	}

	// check google page opened
	public boolean checkGoogleLoad() throws InterruptedException {

		if (isExist(By.xpath("//input[@name='q']")))
			return true;
		else
			return false;

	}

	// check Country label
	public boolean checkCountrylLable(String country) throws InterruptedException {

		if (isExist(By.cssSelector("div.uU7dJb")))
			if (country.equals(getText(By.cssSelector("div.uU7dJb"))))
				return true;
			else
				return false;
		return false;

	}
	
	// check Hebrew label
		public boolean verifyLaguage(String lang) throws InterruptedException {

			switch (lang) {
			  case "hebrew":
				logger.info("check israel coordination");
				Thread.sleep(3000);
					if (isExist(By.linkText("כניסה"))) {
						logger.info("found languge Hebrew");
						return true;
					}
					else {
						logger.error("missing lang: "+ lang );
						return false;
					}
			  default:
				  logger.error("Languge was not found");
			}

			return true;


		}

	// Go to maps
	public boolean getIntoApps(String app) throws InterruptedException {
		
		Thread.sleep(2000);
		click(By.cssSelector("svg.gb_Ve"));
		
		
		switch (app) {
		  case "maps":
			logger.info("Go to : Maps");
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//a[@href='https://maps.google.co.il/maps?hl=iw']")).click();
			driver.switchTo().defaultContent();
		    break;
		  default:
			  logger.info("Apps was not defined");;
		}

		return true;

	}
	
	// Go to maps
		public boolean verifyCoordination(String country) throws InterruptedException {
						
			switch (country) {
			  case "israel":
				logger.info("check israel coordination");
				Thread.sleep(6000);
					if (driver.getCurrentUrl().contains("@32.0522") && driver.getCurrentUrl().contains(",34.8734")) {
						logger.info("found coordinate");

						return true;
					}
					else {
						logger.error("missing coordinate: " + driver.getCurrentUrl());
						return false;
						
					}
						
			  default:
				  logger.error("Contry was not found");;
			}

			return true;

		}
}
