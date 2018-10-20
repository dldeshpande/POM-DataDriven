package com.crm.qa.testclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.UtilTest.UtilTest1;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class HomePageTest extends TestBase {

  LoginPage loginPage;
  HomePage homePage;
  ContactsPage contactsPage;
  
  public HomePageTest() throws IOException {
	super();
}

  @BeforeMethod
  public void setUP() throws Exception
  {
	  Initilization();
	  
	  loginPage = new LoginPage();
	  homePage = loginPage.validateLoginPg(prop.getProperty("username"), prop.getProperty("password"));
	  
	 
	  }
  @Test(priority=1)
  public void verifyHomepageTitle()
  {
	  String title = homePage.validateHomePageTitle();
	  Assert.assertEquals(title, "CRMPRO");
  }
  @Test(priority=2)
  public void verifyUsername()
  {
	  UtilTest1.switchToFram();
	  boolean flag = homePage.validateusername();
	  Assert.assertTrue(flag);
  }
  @Test(priority=3)
  public void verifycontactslink() throws IOException
  {
	  UtilTest1.switchToFram();
	 contactsPage = homePage.validateContactslink();
	 }
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
}
