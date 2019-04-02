package GmailLogin_All_TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import Utilities.ReadWritePropertiesFile;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GmailLogin_Test {

	GmailLogin_Page glp = new GmailLogin_Page();
	ReadWritePropertiesFile pr = new ReadWritePropertiesFile();
	

	@BeforeMethod
	public void beforeMethod() {
		glp.OpenBrowser();
		glp.OpenGmail();
	}

	@AfterMethod
	public void afterMethod() {
		glp.CloseBrowser();
	}

	@Test (priority=1)  // running
	public void LoginWithEmptyValue() throws InterruptedException, IOException {
		glp.EmptyEmail();
		Assert.assertEquals(pr.getobj("nullemailerror"), glp.EmptyEmailError());
		
	}

	@Test (priority=2) //running
	public void LoginWithIncorrectEmail() throws InterruptedException, IOException {
		glp.IncorrectEmail();
		Assert.assertEquals(pr.getobj("incorrectemailerror"), glp.ActEmailError());
	}

	@Test (priority=3) //running
	public void LoginWithIncorrectPhone() throws InterruptedException, IOException {

		glp.IncorrectPhone();
		Assert.assertEquals(pr.getobj("phoneerror"), glp.ActEmailError());
	}

	@Test (priority=4) //running
	public void LoginWithNotRegisteredPhone() throws InterruptedException, IOException {
		glp.NotRegisteredPhone();
		Assert.assertEquals(pr.getobj("phoneerror"), glp.ActEmailError());

	}

	@Test  (priority=5) // running
	public void LoginWithCorrectEmail_IncorrectPassword() throws InterruptedException, IOException {
		glp.CorrectEmail();
		glp.WrongPwd();
		Assert.assertEquals(pr.getobj("correctemail_phoneincorrectpassword"), glp.ActPwdError());

	}

	@Test (priority=6) //Not running
	public void LoginWithCorrectPhone_IncorrectPassword() throws InterruptedException, IOException {
		glp.CorrectPhone();
		glp.WrongPwd();
		Assert.assertEquals(pr.getobj("correctemail_phoneincorrectpassword"), glp.ActPwdError());
	}

	@Test  (priority=7) //running
	public void LoginWithCorrectEmail_CorrecrPassword() throws InterruptedException, IOException {

		glp.CorrectEmail();
		glp.CorrectPwd();
		Assert.assertEquals(pr.getobj("gmailpageurl"), glp.ActURL());
	}

	@Test (priority=8)
	public void LoginWithCorrectPhone_CorrecrPassword() throws InterruptedException, IOException {
		glp.CorrectPhone();
		glp.CorrectPwd();
		Assert.assertEquals(pr.getobj("gmailpageurl"), glp.ActURL());
	}

}
