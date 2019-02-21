package com.officeDepot.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.officeDepot.qa.base.TestBase;

public class SignInPage extends TestBase {
	
	//page Factory Object Repository (OR):
	
	@FindBy(xpath = "//a[text()='Login or Register']")
    WebElement logInKey;
    @FindBy(xpath = "//input[@name='loginName']")
    WebElement emailAddressOrLogIn;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@class='btn rounded w100 primary js_loginBtn']")
    WebElement signInSubmitButton;
	
	@FindBy(xpath ="//div[@id='od_omx_integration_logo']")
	WebElement officeDepotLogo;
	
	//Initializing the page
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions:
    public String validateSignInPageTitle() {
    	return driver.getTitle();  			
    }
    public boolean validateOfficeDepotLogo() {
    	return officeDepotLogo.isDisplayed();
    }
    public HomePage signIn(String un, String pwd) {
    	logInKey.click();
    	emailAddressOrLogIn.sendKeys(un);
    	passwordField.sendKeys(pwd);
    	signInSubmitButton.click();
    	return new HomePage();
    }
}
