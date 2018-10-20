package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class HomePage extends TestBase {
	
	//OR
	
	@FindBy(xpath="(//td[contains(.,'User: Dhananjay Deshpande')])[2]")
	WebElement username;
	
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement Newcontactslink;
	
	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealslink;
	
	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement taskslink;

//initialization

	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateHomePageTitle() {
		
		return driver.getTitle();
	}
	public boolean validateusername()
	{
		return username.isDisplayed();
		
	}
	public ContactsPage validateContactslink() throws IOException
	{
		 contactslink.click();
		 return new ContactsPage();
	}
	public DealsPage validateDealslink() throws IOException
	{
		 dealslink.click();
		 return new DealsPage();
	}
	public TasksPage validateTaskslink()
	{
		 taskslink.click();
		 return new TasksPage();
	}
	public void clickOnNewContacts()
	{
		Actions act = new Actions(driver);
		act.moveToElement(contactslink).build().perform();
		Newcontactslink.click();
	}
	}

