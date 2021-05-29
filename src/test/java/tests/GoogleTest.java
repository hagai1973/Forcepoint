package tests;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleMain;
import utilites.GetDriver;
import utilites.Utilities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


public class GoogleTest {

	// Global variables 
	// Add extent reports
	private ExtentReports extent;
	private ExtentTest myTest;
	private static String reportPaht = System.getProperty("user.dir") + "\\test-output\\reportSanity.html";

	private WebDriver driver;

	//pages
	private GoogleMain main;
	private static final Logger logger = LogManager.getLogger(GoogleTest.class);
	private static String baseUrl;
	private static String browser;
	
	@BeforeClass
	public void beforeClass() throws ParserConfigurationException, SAXException, IOException {
		//PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");

		

	}

	
	
	@BeforeMethod
	public void beforeMethod(Method method) throws IOException, ParserConfigurationException, SAXException {
		

	}
		
	/*  Prerequisite: getting into https://www.10bis.co.il/
	 * 		Given: Client click connection and  
	 * 		When: give Facebook login details and click login
	 *  	Then: Getting into 10bis as registered user
	 */
	
	
	
	@Given("open Google Chrome and go to Google.com")
	@Test(priority = 1, enabled = true, description = "Go to login")
	public void getIntoGoogle() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
		extent = new ExtentReports(reportPaht);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\resources\\extent-config.xml"));
		myTest = extent.startTest("Check Google local");
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
		baseUrl = Utilities.getDataFromXML("info.xml", "website", 0);
	
		
		browser = Utilities.getDataFromXML("info.xml", "browser", 0);
		driver = GetDriver.getDriver(browser, baseUrl, "hagai");

	
		
		
		//driver = GetDriver.getDriver(browser, baseUrl, user);
		
		main = new GoogleMain(driver);		
		
		Assert.assertTrue(main.checkGoogleLoad(), "could not verify google load, check logs");


		logger.info("Going to google page: " + baseUrl);
	
		
	}
	
	@When("Verify the lable of local")
	@Then("label local is Israel")	
	@Test(priority = 2, enabled = true, description = "Login 10bis using Facebook")
	public void checkLocalIsrael() throws InterruptedException, IOException, ParserConfigurationException, SAXException {

		
		logger.info("Check the local");
		Assert.assertTrue(main.checkCountrylLable("ישראל"), "could not verify local country, check logs");
		
		logger.info("Successfully check local");
		//driver.quit();
	}
	
	
	@When("Open Application and select Maps")
	@Test(priority = 2, enabled = true, description = "Login 10bis using Facebook")
	public void goToMaps() throws InterruptedException, IOException, ParserConfigurationException, SAXException {

		
		logger.info("Check the local");
		main.getIntoApps("maps");
		logger.info("Successfully check local");
		//driver.quit();
	}
	
	@When("Verify the lagauge offered by Google")
	@Test(priority = 2, enabled = true, description = "Login 10bis using Facebook")
	public void verifyLaguage() throws InterruptedException, IOException, ParserConfigurationException, SAXException {

		
		logger.info("Check the local");
		Assert.assertTrue(main.verifyLaguage("hebrew"));
		logger.info("Successfully check local");
		//driver.quit();
	}
	
	
	@Then("Verify the coordinate")
	@Test(priority = 2, enabled = true, description = "Login 10bis using Facebook")
	public void verifyCoordination() throws InterruptedException, IOException, ParserConfigurationException, SAXException {

		
		logger.info("Check the coordination");
		Assert.assertTrue(main.verifyCoordination("israel"));
		logger.info("Successfully check local");
		//driver.quit();
	}
	
	
	@Then("Quit browser")	
	@Test(priority = 2, enabled = true, description = "Login 10bis using Facebook")
	public void quit_browser() throws InterruptedException, IOException, ParserConfigurationException, SAXException {

		
		logger.info("Check the local");
		Assert.assertTrue(main.checkCountrylLable("ישראל"), "could not verify local country, check logs");
		
		logger.info("Successfully check local");
		driver.quit();
	}
	
	@Then("Quit browser after check")	
	@Test(priority = 2, enabled = true, description = "Login 10bis using Facebook")
	public void quit_browser_afterCheck() throws InterruptedException, IOException, ParserConfigurationException, SAXException {
		driver.quit();
	}

	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

	}

	@AfterClass
	public void afterClass() {
		

	}
	
}
