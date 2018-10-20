package com.crm.qa.testclass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.UtilTest.UtilTest1;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	UtilTest1 utilTest1;
	ContactsPage contactsPage;

	public ContactPageTest() throws Exception
	{
		super();
	}
	@BeforeMethod
	public void setUP() throws Exception
	{
		Initilization();
		loginPage = new LoginPage();
		homePage=loginPage.validateLoginPg(prop.getProperty("username"), prop.getProperty("password"));
		
		UtilTest1.switchToFram();
		contactsPage= homePage.validateContactslink();
	}
	@Test(priority=1)
	public void verifyContactLbl()
	{
		boolean flag = contactsPage.verifycontactslbl();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=2)
	public void verifycontactLbl1()
	{
		boolean flag = contactsPage.verifycontactslbl();
		Assert.assertTrue(flag,"The Contacts Title doesn't Match");
	}
	@Test(priority=2)
	public void selectContacts()
	{
		contactsPage.selectContactByName("Dhananjay Deshpande");
	}
	
	@DataProvider
	public Object[][] dataprovide() throws IOException, Exception {
		Object data[][]= UtilTest1.getTestData("contacts");
		return data;
	}
	
	@Test(priority = 3,dataProvider ="dataprovide" )
	public void getCRMData(String title,String fname,String lname,String company)
	{
		homePage.clickOnNewContacts();
		contactsPage.createNewConntacts(title, fname, lname, company);
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	{
		
	}
}
