package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(name = "firstname")
	WebElement txtfirstname;
	
	@FindBy(name = "lastname")
	WebElement txtlastname;
	
	@FindBy(name = "email")
	WebElement txtemail;
	
	@FindBy(name = "password")
	WebElement txtpassword;
	
	@FindBy(name="agree")
	WebElement chkpolicy;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btncontinue;
	
	////button[normalize-space()='Continue']
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confmsg;

	
	public void setfirstname(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
		
	}
	
	public void password(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	
	public void clickagree()
	{
		
		chkpolicy.click();
		
	}
	
	
	
	
	public void clickcontinue()
	{
		btncontinue.click();
	}
	
	public String getconfirmationmsg() {
		try
		{
			return(confmsg.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	
}
