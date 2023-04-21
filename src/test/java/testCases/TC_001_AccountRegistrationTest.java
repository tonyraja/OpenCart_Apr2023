package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration()
	{
		logger.info("**** Starting TC_001_AccountRegistrationTest *****");
		
		HomePage hp=new HomePage(driver);
				
		hp.clickmyaccount();
		logger.info("Clicked on my account link");
		hp.clickmyregister(); 
		logger.info("Clicked on register link");

		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("providing customer data");

		
		regpage.setfirstname(randomstring().toUpperCase());
		
		regpage.setlastname(randomstring().toUpperCase());
		
		regpage.setemail(randomstring()+"@gmail.com");
		
		regpage.password(randomalphanumeric());
		
		
		regpage.clickagree();
		
		regpage.clickcontinue();
		
		logger.info("Clicked on continue");


		String confmsg=regpage.getconfirmationmsg();
		
		logger.info("Validating expected message");

		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Not getting expected message");
				
	
	
	}

	
	
	
}
