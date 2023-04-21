package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_AccoutLoginPage extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		try
		{
		logger.info("***Starting TC_002_AccountLoginPage***");
		
		HomePage hp=new HomePage(driver);
		
		hp.clickmyaccount();
		
		logger.info("Clicked on My Account");
		hp.clickmylogin();
		logger.info("Clicked on Login link");

		
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing Login Details");

		
		lp.setemail(rb.getString("email"));
		lp.setpassword(rb.getString("password"));
		lp.login();
		logger.info("Clicked on Login Button");

		
		
		MyAccountPage myact=new MyAccountPage(driver);
		
		boolean targetpage=myact.myaccountexist();
		
		Assert.assertEquals(targetpage, true, "Invalid Login Data");
		}
		catch(Exception e) {
			
			Assert.fail();
			

		}
		
		logger.info("*****Finished TC_002_AccoutLoginPage*****");
	}
	
	
	
	
	
}
