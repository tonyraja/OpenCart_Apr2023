package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage (WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkmyaccount;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']")
	WebElement lnklogin;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	
	//Action methods
	public void clickmyaccount()
	{
		lnkmyaccount.click();
	}
	
	public void clickmyregister()
	{
		lnkRegister.click();
	}
	
	public void clickmylogin()
	{
		lnklogin.click();
	}
}
