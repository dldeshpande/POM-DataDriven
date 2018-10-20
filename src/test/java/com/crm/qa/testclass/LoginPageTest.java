package com.crm.qa.testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initilization();
		try {
			loginPage = new LoginPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=1)
	public void validtePageTitleTest()
	{
		String title = loginPage.validatePageTile();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	@Test(priority=2)
	public void validateImgTest()
	{
		boolean flag = loginPage.validateImglogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void validaeLoginTest() throws IOException
	{
		homePage=loginPage.validateLoginPg(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	}
	
