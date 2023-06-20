package stepsdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ExamPage;


public class Exam {
	
	WebDriver driver;
	private ExamPage examPage;
	

	@Given("User opens the Application")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();	
	}

	@When("User enters valid school {string} into the Search inbox field")
	public void user_enters_valid_school_into_the_search_inbox_field(String validSchoolText) {
		
		examPage = new ExamPage(driver);
		examPage.enterSearchSchool(validSchoolText);

	}
	
	@When("User click take me there button")
	public void user_click_take_me_there_button() {
		
		driver.getWindowHandle();
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();

		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;
		//System.out.println(driver.getTitle());
		examPage.clickTakeMeThereButton();
		
	
		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}

		//System.out.println(driver.getTitle());

	}
	               
	@When("User click guest registration button")
	public void User_click_guest_registration_button() {
		driver.switchTo().frame("login-iframe");
		examPage.clickGuestButton();
		
	}
	
	@When("User click on register here button")
	public void User_click_register_here_button() {
		examPage.clickRegisterHereButton();
		
	}
	
	@When("User enters the details into below fields")
	public void User_enters_the_details_into_below_fields(DataTable dataTable){
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		examPage.enterFullName(dataMap.get("fullName"));
		examPage.enterYourEmail(dataMap.get("email"));
		examPage.enterCreatePassword(dataMap.get("password"));
		examPage.enterConfirmPassword(dataMap.get("password"));
		
	}
	

	@And("User click on register button")
	public void User_click_register_button() {
		examPage.clickRegisterButton();
		
	}
	
	@Then("User account should be created successfully")
	public void User_account_should_be_created_successfully() {
		
		Assert.assertEquals("Email confirmation sent", examPage.getPageHead());
	}
	
	
	@When("User enters valid email {string} into the email field")
	public void User_enters_valid_email_into_the_email_field(String emailAddressText) {
		
		examPage.enterEmail(emailAddressText);
		
	}
	
	@When("User enters valid password {string} into the password field")
	public void User_enters_valid_password_into_the_password_field(String passwordText) {
		examPage.enterPassword(passwordText);
	}
	
	@And("User click on login button")
	public void User_click_on_login_button() {
		examPage.clickLoginButton();
	}
	
	
	@Then("User should successfully logged in")
	public void User_should_successfully_logged_in() {
		
		Assert.assertTrue(examPage.displayOfLogoutButton());
		
	}
	

	
}
