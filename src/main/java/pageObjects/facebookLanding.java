package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class facebookLanding {

	WebDriver driver;
	By facebooklink=By.xpath("//span[contains(text(),'See more of QAClick Academy on Facebook')]");
	
	
	public facebookLanding(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
	public WebElement getfacebooklink()
	{
		return driver.findElement(facebooklink);
	}
}
