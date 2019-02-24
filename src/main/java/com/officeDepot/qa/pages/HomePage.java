package com.officeDepot.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.officeDepot.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//a[@class='deals_icon nav_a1']")
    WebElement deals;
    @FindBy(xpath = "//div[@class='context_modal ideas loaded']")
    WebElement ideas;
    @FindBy(xpath = "//span[contains(text(),'Chat or Call')]")
    WebElement chatOrCall;
    @FindBy(xpath ="//div[@id='od_omx_integration_logo']")
	WebElement officeDepotLogo;
  
    //Initializing the page object:
    public HomePage() {
    	PageFactory.initElements(driver, this);
    }
    //Actions:
    public String validateHomePageTitle() {
    	return driver.getTitle();  			
    }
    public DealsPage clickOnDealsLink() {
    	deals.click();
    	return new DealsPage();
    }
    public IdeasPage clickOnIdeasLink() {
    	ideas.click();
    	return new IdeasPage();
    }
    public ChatOrCallPage clickOnChatOrCallLink() {
    	chatOrCall.click();
    	return new ChatOrCallPage();
    }
    public boolean validateOfficeDepotLogo() {
    	return officeDepotLogo.isDisplayed();
    }

}
