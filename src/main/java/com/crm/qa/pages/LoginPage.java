package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.UtilTest.UtilTest1;
import com.crm.qa.testbase.TestBase;

public class LoginPage extends TestBase {

	//OR
	
	//Page Object//OR:
	
		@FindBy(name = "username")
		private WebElement username;
		
		@FindBy(name = "password")
	    private WebElement password;
		
		@FindBy(xpath = "(//img[contains(@class,'img-responsive')])[1]")
		private WebElement imgLogo;
		
		@FindBy(xpath = "//input[(@type='submit')]")
		private WebElement loginBtn;

	//Initilazation

		public LoginPage() throws IOException
			
		{
			PageFactory.initElements(driver, this);
		}
		
public String validatePageTile()
{
	return driver.getTitle();
}
public boolean validateImglogo()
{
	return imgLogo.isDisplayed();
}
	public HomePage validateLoginPg(String un,String pwd) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		//UtilTest1.clcikByname(driver, "//input[@class='btn btn-small']");
		loginBtn.click();
		return new HomePage();
	}
}
