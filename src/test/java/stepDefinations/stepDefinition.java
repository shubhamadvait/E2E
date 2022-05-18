package stepDefinations;



import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;





import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resourses.base;

import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class stepDefinition extends base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver=intializerDriver();
    }
    @Given("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        driver.get(strArg1);
    }

    @Given("^Click on login link in home page to land on Secure sign in the Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_the_page() throws Throwable {
    LandingPage l=new LandingPage(driver);
  if(  l.getPopupSize().size()>0)
  {
	  l.getPopup().click();
  }
  l.getLogin().click();
    }
    @When("^User enters (.+) and (.+) and logs in $")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	 }

    @Then("^Verify that user is successfully logged in $")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
    	  portalHomePage p=new portalHomePage(driver);
    	   Assert.assertTrue(p.getSearchBox().isDisplayed());
    }

  
    @And("^close browser$")
    public void close_browser() throws Throwable {
       driver.close();
    }


}