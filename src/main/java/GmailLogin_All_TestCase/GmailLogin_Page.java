package GmailLogin_All_TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Enter;

public class GmailLogin_Page {	

	private WebElement actPwdError;
	
	@FindBy (id = "identifierId")
	public static WebElement email;
	
	@FindBy (xpath="//span[contains(text(),'Next')]")
	public static WebElement emailNext;
	
	@FindBy (className = "GQ8Pzc")
	public static WebElement nullEmailErr;
	
	@FindBy (className = "GQ8Pzc")
	public static WebElement actEmailErr;
	
	@FindBy (xpath="//input[@name='password']")
	public static WebElement pass;
	
	@FindBy (xpath="//div[@id='passwordNext']//content[@class='CwaK9']")
	public static WebElement passNext;
	
	@FindBy (xpath="//div[@jsname='B34EJ']")
	public static WebElement actPwdErr;	
	
	public WebDriver driver;
	
	public void OpenBrowser() 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\\\selenium_jars\\\\geckodriver-v0.24.0-win64\\\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		PageFactory.initElements(driver, this);
	}
	public void OpenGmail() 
	{
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}
	public void CloseBrowser() 
	{
		driver.quit();
	}
	public void EmptyEmail() throws InterruptedException 
	{
		email.sendKeys("");
		emailNext.click();
		Thread.sleep(400);
	}
	public String EmptyEmailError()
	{
		String EmptyEmailError = nullEmailErr.getText();
		System.out.println(EmptyEmailError);
		return EmptyEmailError;
	}
	public String ActEmailError()
	{
		String ActEmailError = actEmailErr.getText();
		System.out.println(ActEmailError);
		return ActEmailError;
	}
	public void IncorrectEmail() throws InterruptedException 
	{
		email.sendKeys("x4");
		emailNext.click();
		Thread.sleep(400);
	}
	public void IncorrectPhone() throws InterruptedException 
	{
		email.sendKeys("123456789");
		emailNext.click();
		Thread.sleep(400);		
	}
	public void NotRegisteredPhone() throws InterruptedException 
	{
		email.sendKeys("9558498103");
		emailNext.click();
		Thread.sleep(400);
	}
	public void CorrectEmail() throws InterruptedException 
	{
		email.sendKeys("shivangi.shah9192");
		emailNext.click();
		Thread.sleep(400);
	}
	public void CorrectPhone() throws InterruptedException 
	{
		email.sendKeys("6475350530");
		emailNext.click();
		Thread.sleep(400);
	}
	public void WrongPwd() throws InterruptedException 
	{
		pass.sendKeys("7d7d7d");		
		/*driver.findElement(By.xpath("//div[@id='passwordNext']//content[@class='CwaK9']")).click();
		Thread.sleep(400);*/		
		passNext.click();
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments [0].scrollIntoView(true);",element);*/			
		Thread.sleep(400);
	}
	public String ActPwdError()
	{
		String ActPwdError = actPwdErr.getText();
		System.out.println(ActPwdError);
		return ActPwdError;
	}
	public void CorrectPwd() 
	{
		pass.sendKeys("bjs@10962");		
		passNext.click();		
	}	
	public String ActURL() {
		String ActURL = driver.getCurrentUrl();
		System.out.println(ActURL);
		return ActURL;
		
	}
	
}
