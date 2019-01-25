package qa.newExample.SeleniumBDD.ReactTestApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReactHomepage {
	
	@FindBy(xpath = "/html/body/div/div/ul/li[10]/a")
	private WebElement testLink;
	
	public void testLinkAction() {
		
		testLink.click();
		
	}

}
