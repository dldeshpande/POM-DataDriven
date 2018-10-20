package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.testbase.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsTitle;
	
	@FindBy(id="first_name")
	WebElement firstnametxt;
	
	@FindBy(id="surname")
	WebElement lastnametxt;
	
	@FindBy(name="client_lookup")
	WebElement companytxt;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement saveBtn;
	
	public ContactsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean verifycontactslbl()
	{
		return contactsTitle.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[.= '"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::"
				+ "td[@class='datalistrow']//input[@name='contact_id']")).click();	
		}

	public void createNewConntacts(String title,String fname,String lname,String company)
	{
		Select sel = new Select(driver.findElement(By.name("title")));
		sel.selectByVisibleText(title);
		firstnametxt.sendKeys(fname);
		lastnametxt.sendKeys(lname);
		companytxt.sendKeys(company);
		saveBtn.click();
	}
	
	
}
