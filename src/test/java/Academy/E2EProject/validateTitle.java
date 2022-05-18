package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.facebookLanding;
import resourses.base;

public class validateTitle extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage l;
	facebookLanding fb;
	@Test
	public void basePageNavigation() throws IOException {

		// driver.get("https://rahulshettyacademy.com/sign_in/");
		 l = new LandingPage(driver);
		String actualTitle = l.getTitle().getText();
		Assert.assertEquals(actualTitle, "FEATURED 11COURSES");
		log.info("Successfully validated text message");

	}
	@Test
	public void baseHeader() throws IOException {

		// driver.get("https://rahulshettyacademy.com/sign_in/");
		 l = new LandingPage(driver);
		String actualTitle = l.getHeader().getText();
		Assert.assertEquals(actualTitle, "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Successfully validated text message");

	}
	@Test
	public void  courseDetails()
	{
		l = new LandingPage(driver);
	Dimension courses=	l.getCourse().getSize();
	System.out.println(courses);
	Assert.assertEquals(courses, 49);
	log.info("Successfully validated courses");
	}
@Test
public void seleniumCourse()
{
	l = new LandingPage(driver);
	boolean text=l.getseleniumCourse().getText().isEmpty();
	Assert.assertFalse(text);
}
	@BeforeTest
	public void intializer() throws IOException {
		driver = intializerDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homePage");

	}
	
	@Test
	public void facebooklink()
	{
		l = new LandingPage(driver);
		l.getfacebookpath();
		facebookLanding fb=new facebookLanding(driver);
		boolean getfblink=fb.getfacebooklink().getText().contains("QAClick Academy on Facebook");
		Assert.assertTrue(getfblink);
	}

	@AfterTest
	public void tear() {
		driver.close();
	}

}
