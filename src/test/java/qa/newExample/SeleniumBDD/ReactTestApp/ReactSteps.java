package qa.newExample.SeleniumBDD.ReactTestApp;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReactSteps {

	private WebDriver driver;
	private ExtentReports report;
	private ExtentTest test;
	Actions action;
	WebDriverWait wait;
	

	@Before
	public void setup() {

		System.setProperty("webdriver.gecko.driver", Constant.WEBDRIVER_LOCATION);
		driver = new FirefoxDriver();
		report = new ExtentReports(Constant.TEST_LOG_LOCATION);
		// Test Report
		test = report.startTest("Starting Test");
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);

	}

	@After
	public void teardown() {

		driver.close();

		report.endTest(test);
		report.flush();

	}

	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {

		test.log(LogStatus.INFO, "Navigated to" + Constant.REACT_APP_LOCATION);
		driver.get(Constant.REACT_APP_LOCATION);

	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form() {

		ReactHomepage page = PageFactory.initElements(driver, ReactHomepage.class);

		page.testLinkAction();

	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1) {

		TestPage page = PageFactory.initElements(driver, TestPage.class);

		page.dropdownFill(arg1, wait, action);

	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1) {

		TestPage page = PageFactory.initElements(driver, TestPage.class);

		page.emailFill(arg1);

	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1) {
		TestPage page = PageFactory.initElements(driver, TestPage.class);

		page.pass1Fill(arg1);
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) {
		TestPage page = PageFactory.initElements(driver, TestPage.class);

		page.pass2Fill(arg1);

	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message() {
		
		TestPage page = PageFactory.initElements(driver, TestPage.class);
		

		if(page.success().equals("Success!")) {
			test.log(LogStatus.PASS, "Test Passed");
		}
		
		assertEquals("Success!", page.success());
		
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1) {

		TestPage page = PageFactory.initElements(driver, TestPage.class);

		page.pass2Fill(arg1);
		
		
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {
		
		TestPage page = PageFactory.initElements(driver, TestPage.class);
		

		if(page.doNotMatch().equals("The passwords do not match")) {
			test.log(LogStatus.PASS, "Test Passed");
		}
		
		assertEquals("The passwords do not match", page.doNotMatch());
		
	}

}
