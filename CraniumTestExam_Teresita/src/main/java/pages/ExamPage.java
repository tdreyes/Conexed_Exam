package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class ExamPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public ExamPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(id="school-search")
	private WebElement searchField;
	
	@FindBy(xpath="//input[@id='login-text']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='password-text']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[contains(@class, 'btn btn-primary')]")
	private WebElement takeMeThereButton;
	
	@FindBy(xpath="//button[@id='craniumcafe-button']")
	private WebElement guestButton;
	
	@FindBy(xpath="//button[@id='register-toggle-button']")
	private WebElement registerHereButton;
	
	@FindBy(id="fullname-text")
	private WebElement fullNameField;
	
	@FindBy(id="email-text")
	private WebElement yourEmailField;

	
	@FindBy(id="create-password-text")
	private WebElement createPasswordField;

	
	@FindBy(id="confirm-password-text")
	private WebElement confirmPasswordField;
	
	@FindBy(id="register-button")
	private WebElement registerButton;
	
	
	@FindBy(xpath="//h3[normalize-space()='Email confirmation sent']")
	private WebElement pageHead;
	
	
	@FindBy(xpath="//button[@id='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@id='logout-button']")
	private WebElement logoutButton;
	
	
	public void enterSearchSchool(String searchText) {
		
		elementUtils.typeTextIntoElement(searchField, searchText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}
	

	public void clickTakeMeThereButton() {
		
		elementUtils.clickOnElement(takeMeThereButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);	
	}
	

	public void clickGuestButton() {
		
		elementUtils.clickOnElement(guestButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);	
	}
	
	public void clickRegisterHereButton() {
		
		elementUtils.clickOnElement(registerHereButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);	
	}
	
	public void enterFullName(String fullNameText) {
		
		elementUtils.typeTextIntoElement(fullNameField, fullNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}	
	
	public void enterYourEmail(String emailText) {
		
		elementUtils.typeTextIntoElement(yourEmailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}	
	
	public void enterCreatePassword(String passwordText) {
		
		elementUtils.typeTextIntoElement(createPasswordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}	

	public void enterConfirmPassword(String passwordText) {
		
		elementUtils.typeTextIntoElement(confirmPasswordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}	
	
	public void clickRegisterButton() {
		
		elementUtils.clickOnElement(registerButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}	
	

	public String getPageHead() {
		
		return elementUtils.getTextFromElement(pageHead, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	public void enterEmail(String emailText) {
		
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}	
	
	
	public void enterPassword(String passwordText) {
		
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
	}	
	
	public void clickLoginButton() {
		
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);	
	}
	
	public boolean displayOfLogoutButton() {
		
		return elementUtils.displayStatusOfElement(logoutButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
}
