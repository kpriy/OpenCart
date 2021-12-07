package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
	@Test(groups={"regression","master"})
	public void test_account_Registration()
	{
		
		try {
		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed ");
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistration regpage=new AccountRegistration(driver);
		
		regpage.setFirstName("John");
		logger.info("First Name entered ");
		regpage.setLastName("Canedy");
		logger.info("Last Name entered ");
		regpage.setEmail(randomestring()+"@gmail.com");
		logger.info("Email entered ");
		regpage.setTelephone("65656565");
		logger.info("Telephone entered");
		regpage.setPassword("abcxyz");
		logger.info("Password has been set ");
		regpage.setConfirmPassword("abcxyz");
		logger.info("Password has been confirmed ");
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			logger.info("Account Registration is successful! "); 
		}
		else
		{
			logger.info("Account Registration failed "); 
			captureScreen(driver, "test_accout_Registration"); //Capturing screenshot
			Assert.assertTrue(false);
		}
	  }
		
		catch(Exception e)
		{
			logger.fatal("Account Registration Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_001_AccountRegistration ");
		
	}

}
