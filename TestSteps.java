package stepDef;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {
	public ChromeDriver driver;
	String leadID;
@Given("open the chrome browser and load the url")
 public void openApp() {
	 System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
 }
@And("Enter the username as (.*) and password as (.*)")
 public void enterCreds(String username,String password) {
		WebElement eleUsername = driver.findElementById("username");
		eleUsername.sendKeys(username);
		WebElement elePassword = driver.findElementById("password");
		elePassword.sendKeys(password);
 }
@Given("Click the login button")
public void login() {
	driver.findElementByClassName("decorativeSubmit").click();
}
@And("Click the CRMSFA link")
public void crmsfa() {
	driver.findElementByLinkText("CRM/SFA").click();
}
@And("Click the Leads link")
public void lead() {
	driver.findElementByLinkText("Leads").click();
}
@And("Click the createlead link")
public void createLead() {
	driver.findElementByLinkText("Create Lead").click();
}
@And("Enter the company name as Testleaf")
public void companyName()
{
	WebElement eleCompanyname = driver.findElementByXPath("//input[@id='createLeadForm_companyName']");
	eleCompanyname.sendKeys("Testleaf");
	}
@And("Enter the first name as Balaji")
public void fName() {
	WebElement eleFirstname = driver.findElementByXPath("//input[@id='createLeadForm_firstName']");
	eleFirstname.sendKeys("Balaji");
}
@And("Enter the last name as C")
public void lName() {
	WebElement eleLastname = driver.findElementByXPath("//input[@id='createLeadForm_lastName']");
	eleLastname.sendKeys("C");
}
@When("Click on the create lead button")
public void createLeadButton() {
	driver.findElementByXPath("//input[@name='submitButton']").click();
}
@Then("verify the lead creation")
public void leadVerify() {
System.out.println("Lead created successfully");
}
@Then("close the browser")
public void close() {
	driver.close();
}
@Given("Click the Findlead link")
public void findLead() {
	driver.findElementByLinkText("Find Leads").click();
}
@And("Click Phone tab and Enter the Phone number as (.*)")
public void phoneNumb(String phoneNumber)
{
	driver.findElementByXPath("//span[text()='Phone']").click();
	driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phoneNumber);
	}
@And("Click on the find leads button")
public void fButton() throws InterruptedException {
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(2000);
}
@And("Click on the first resulted lead and store it in a string 'leadID'")
public void firstLead() {
	leadID = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
}
@And("Click on the delete lead button")
public void deleteLeadButton() {
	driver.findElementByLinkText("Delete").click();
}
@And("Click on the find leads button again")
public void findButton() {
	driver.findElementByLinkText("Find Leads").click();
}
@And("In the name tab, pass the string 'leadID'")
public void passString() {
	driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
}
@When("Click on the find leads button to recheck")
public void findLeadButton() {
	driver.findElementByXPath("//button[text()='Find Leads']").click();
}
@Then("verify that no match with the leadID is found")
public void deleteVerify() {
	String text = driver.findElementByClassName("x-paging-info").getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
	
}
@And("Click on the first resulted lead")
public void fstResult() {
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
}
@And("Click on the duplicate lead button")
public void dupButton() {
	driver.findElementByLinkText("Duplicate Lead").click();
}

@When("Click on the Submit button")
public void submitButton() {
	driver.findElementByName("submitButton").click();
}
@Then("verify duplicate lead is created")
public void verifyDup() {
	System.out.println("Duplicate lead created");
}
@And("Click on the Edit button")
public void editButton() {
	driver.findElementByLinkText("Edit").click();
}
@And("In Company name tab,Enter the company name as (.*)")
public void cName(String compName) {
	driver.findElementById("updateLeadForm_companyName").sendKeys(compName);
}
@When("Click on Submit button")
public void submitBut() {
	driver.findElementByName("submitButton").click();
}
@Then("verify the lead company name is Edited successfully")
public void verifyEdit() {
	System.out.println("Lead Company name is Edited successfully");
}
@Given("Click the Merge lead link")
public void mergeLink() {
	driver.findElementByLinkText("Merge Leads").click();
}
@And("Click on Widget of From lead")
public void fromWidget() {
	driver.findElementByXPath("//img[@alt='Lookup']").click();
}
@And("Enter First name as (.*) and Click on First Resulting lead")
public void fname(String firstName) throws InterruptedException {
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	driver.findElementByXPath("//input[@name='firstName']").sendKeys(firstName);
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(1000);
	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").getText();
	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
	driver.switchTo().window(allhandles.get(0));
}
@And("Click on Widget of To lead")
public void toWidget() {
	driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
}
@And("Enter fname as (.*) and Click on First Resulting lead")
public void firstName(String fName) throws InterruptedException {
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
	driver.findElementByXPath("//input[@name='firstName']").sendKeys(fName);
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(1000);
	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
	driver.switchTo().window(allhandles2.get(0));
}
@And("Click on Merge button")
public void mergeButton() {
	driver.findElementByXPath("//a[text()='Merge']").click();
}
@When("Accept the Alert")
public void acceptAlert() {
	driver.switchTo().alert().accept();
}
@Then("Verify the title of the page")
public void pageTitle() {
	System.out.println("Title:"+ driver.getTitle());
}
}