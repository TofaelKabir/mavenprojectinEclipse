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
    @FindBy(xpath ="//a[contains(text(),'Mohammad')]")
	WebElement userNameLabel;
  
    @FindBy(xpath ="//a[@id='bx-close-inside-752704']")
	WebElement alertCancel;
    @FindBy(css = ".bx-close-xsvg")
    public WebElement officeDepotPopUpCloseWindowWebElement;
	
	
	//Initializing the page object:
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions:
    public String validateSignInPageTitle() {
    	return driver.getTitle();  			
    }
    public boolean verifyCorrectUserName() {
    	return userNameLabel.isDisplayed();
    }
    public HomePage signIn(String un, String pwd) {
    	//WebDriverWait wait = new WebDriverWait(driver, 10);
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bx-close-xsvg"))).click();
    	//officeDepotPopUpCloseWindowWebElement.click();
    	logInKey.click();
    	emailAddressOrLogIn.sendKeys(un);
    	passwordField.sendKeys(pwd);
    	signInSubmitButton.click();
    	return new HomePage();
    }
    public void popUpHandling()throws InterruptedException{
        
        Thread.sleep(5000);
         
          officeDepotPopUpCloseWindowWebElement.click();
        
      }
}
