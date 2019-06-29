package com.formseleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormNewSD {

	WebDriver driver;

	By fNameLOC = By.xpath("//div/input[@type='text'][@ng-model='FirstName']");
	By lNameLOC = By.xpath("//div/input[@type='text'][@ng-model='LastName']");
	By addressLOC = By.xpath("//div/textarea[@ng-model='Adress']");
	By eMailLOC = By.xpath("//div/input[@type='email'][@ng-model='EmailAdress']");
	By phoneLOC = By.xpath("//div/input[@type='tel'][@ng-model='Phone']");
	By radioMaleLOC = By.xpath("//div/label/input[@type='radio'][@value='Male']");
	By radioFeMaleLOC = By.xpath("//div/label/input[@type='radio'][@value='FeMale']");
	By chkCricketLOC = By.xpath("//div/input[@type ='checkbox'][@id='checkbox1']");
	By chkMoviesLOC = By.xpath("//div/input[@type ='checkbox'][@id='checkbox2']");
	By chkHockeyLOC = By.xpath("//div/input[@type ='checkbox'][@id='checkbox3']");
	By langaugeLOC = By.xpath("//multi-select/div[@id='msdd']");
	By skillsLOC = By.xpath("//div/select[@type = 'text'][@id='Skills']");
	By countryLOC = By.xpath("//div/select[@type = 'text'][@id='countries']");
	By selCountryLOC = By.xpath("//span/span[@role='combobox']");
	By dobYearLOC = By.xpath("//div/select[@type = 'text'][@id = 'yearbox']");
	By dobMonthLOC = By.xpath("//div/select[@type = 'text'][@placeholder = 'Month']");
	By dobDayLOC = By.xpath("//div/select[@type = 'text'][@placeholder = 'Day']");
	By passwordLOC = By.xpath("//div/input[@id='firstpassword']");
	By passwordConfirmLOC = By.xpath("//div/input[@id='secondpassword']");
	By submitBtnLOC = By.xpath("//div/button[@id='submitbtn']");
	By refreshBtnLOC = By.xpath("//div/button[@id='Button1']");
	
	
	@Given("launch the browser with application")
	public void launch_the_browser_with_application(){
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\JyotiRadicalB18\\RadicalSoftware\\Selenium\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver",
//				"E:\\JyotiRadicalB18\\RadicalSoftware\\Selenium\\geckodriver-v0.18.0-win64\\geckodriver.exe");
//				driver = new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
	}
	
	@When("user enter \"([^\"]*)\" as first name and \"([^\"]*)\" as lasst name")
	public void user_enter_first_name_and_last_name(String fName,String lName){
		System.out.println(fName);
		System.out.println(lName);
		try{
			driver.findElement(fNameLOC).sendKeys(fName);
			Thread.sleep(1000);
			driver.findElement(lNameLOC).sendKeys(lName);
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@When("user enter \"([^\"]*)\" as address and \"([^\"]*)\" as mail and \"([^\"]*)\" as phnumber")
	public void user_enter_address_and_mail_and_phnumber(String add,String mail,String ph){
		System.out.println(add);
		System.out.println(mail);
		System.out.println(ph);
		try{
			driver.findElement(addressLOC).sendKeys(add);
			Thread.sleep(1000);
			driver.findElement(eMailLOC).sendKeys(mail);
			Thread.sleep(1000);
			driver.findElement(phoneLOC).sendKeys(ph);
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Then("user select female as gender")
	public void user_select_female_as_gender(){
		driver.findElement(radioFeMaleLOC).click();
	}
	
	@When("user check for select hobbies")
	public void user_check_for_select_hobbies(){
		driver.findElement(chkCricketLOC).click();
		driver.findElement(chkMoviesLOC).click();
	}
	
	/*need to check for langauge as it select one lag different then array list*/
	@Then("user select language")
	public void user_select_language(){
		String lang[]={"Danish","English","French"};
		try{
			for(int i = 0 ;i<lang.length;i++)
			{
				driver.findElement(langaugeLOC).click();
				Thread.sleep(1000);
				String lagNm = lang[i].toString();
				System.out.println(lagNm);
				driver.findElement(By.xpath("//div/ul/li/a[text()='"+lagNm+"']")).click();
				
				Thread.sleep(1000);
			}
		}catch(Exception e){
			
		}		
	}
	
	@Then("user select \"([^\"]*)\" as skills")
	public void user_select_skills(String skillName){
		try{
			driver.findElement(skillsLOC).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div/select[@type = 'text'][@id='Skills']/option[@value='"+skillName+"']")).click();
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@When("user select \"([^\"]*)\" as country")
	public void user_select_country(String cntName){
		try{
			driver.findElement(countryLOC).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div/select[@type = 'text'][@id='countries']/option[@value='"+cntName+"']")).click();
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	@Then("user select \"([^\"]*)\" as second country")
	public void user_select_second_country(String secCntName){
		try{
			driver.findElement(selCountryLOC).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span/span[@role='combobox']/span[@title='"+secCntName+"']")).click();
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	////div/select[@type = 'text'][@id = 'yearbox']/option[@value='2000']
	@When("user select \"([^\"]*)\" as DOB year")
	public void user_select_DOB_year(String yearBirth){
		try{
			driver.findElement(dobYearLOC).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div/select[@type = 'text'][@id = 'yearbox']/option[@value='"+yearBirth+"']")).click();
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Then("user select \"([^\"]*)\" as month")
	public void user_select_month(String monthBirth){
		try{
			driver.findElement(dobMonthLOC).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div/select[@type = 'text'][@placeholder = 'Month']/option[@value='"+monthBirth+"']")).click();
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Then("user select \"([^\"]*)\" as day")
	public void user_select_day(String dayBirth){
		try{
			driver.findElement(dobDayLOC).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div/select[@type = 'text'][@placeholder = 'Day']/option[@value='"+dayBirth+"']")).click();
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@When("user enter \"([^\"]*)\" as password")
	public void user_enter_password(String pwd){
		try{
			driver.findElement(passwordLOC).sendKeys(pwd);
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@When("user enter \"([^\"]*)\" as confirm password")
	public void user_enter_confirm_password(String pwdConf){
		try{
			driver.findElement(passwordConfirmLOC).sendKeys(pwdConf);
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}