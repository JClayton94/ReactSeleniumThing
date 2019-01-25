package qa.newExample.SeleniumBDD.ReactTestApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage {

	@FindBy(xpath = "/html/body/div/div/div/div/button")
	private WebElement country;

	@FindBy(xpath = "/html/body/div/div/div/p[10]")
	private WebElement doNotMatch;

	@FindBy(xpath = "/html/body/div/div/div/h1")
	private WebElement success;

	@FindBy(xpath = "/html/body/div/div/div/div/div")
	private WebElement dropDown;

	@FindBy(xpath = "/html/body/div/div/div/div/div/a[1]")
	private WebElement drop1;

	@FindBy(xpath = "/html/body/div/div/div/div/div/a[2]")
	private WebElement drop2;

	@FindBy(xpath = "/html/body/div/div/div/div/div/a[3]")
	private WebElement drop3;

	@FindBy(xpath = "/html/body/div/div/div/input[1]")
	private WebElement nameField;

	@FindBy(id = "nameInput")
	private WebElement emailField;

	@FindBy(id = "passInput")
	private WebElement passInput1;

	@FindBy(id = "passInput2")
	private WebElement passInput2;

	@FindBy(xpath = "/html/body/div/div/div/button")
	private WebElement button;

	public void dropdownFill(String arg1, WebDriverWait wait, Actions action) {
		
		action.moveToElement(country).perform();
 
//		country.click();

		if (arg1.contains(drop1.getAttribute("innerHTML"))) {

			WebElement drop1w = wait.until(ExpectedConditions.elementToBeClickable(drop1));
			drop1w.click();

		} else if (arg1.contains(drop2.getAttribute("innerHTML"))) {
			WebElement drop2w = wait.until(ExpectedConditions.elementToBeClickable(drop2));
			drop2w.click();

		} else if (arg1.contains(drop3.getAttribute("innerHTML"))) {
			WebElement drop3w = wait.until(ExpectedConditions.elementToBeClickable(drop3));
			drop3w.click();

		} else {

		}
	}

	public void emailFill(String arg1) {

		emailField.sendKeys(arg1);

	}

	public void pass1Fill(String arg1) {

		passInput1.sendKeys(arg1);
	}

	public void pass2Fill(String arg1) {

		passInput2.sendKeys(arg1);
		button.click();
	}

	public String success() {

		return success.getText();

	}

	public String doNotMatch() {

		return doNotMatch.getText();

	}

}
