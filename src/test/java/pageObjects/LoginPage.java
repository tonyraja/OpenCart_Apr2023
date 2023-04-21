package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(name="email")
	WebElement txtemail;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement txtlogin;
	
	
	
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void login()
	{
		txtlogin.click();
	}
	
}
