package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    public WebDriver driver;
    private By checkoutButton = By.id("checkout");
    private By inputFirstName = By.id("first-name");
    private By inputLastName = By.id("last-name");
    private By inputPostalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By checkoutErrorText = By.cssSelector("h3[data-test='error']");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }
    public WebElement getInputFirstName(){
        return driver.findElement(inputFirstName);
    }
    public WebElement getInputLastName(){
        return driver.findElement(inputLastName);
    }
    public WebElement getInputPostalCode(){
        return driver.findElement(inputPostalCode);
    }
    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }

    public WebElement getCheckoutErrorText(){
        return driver.findElement(checkoutErrorText);
    }


public void checkInfo(String firstName, String lastName, String postalCode) throws InterruptedException {
        getCheckoutButton().click();
        getInputFirstName().sendKeys(firstName);
        Thread.sleep(1000);
        getInputLastName().sendKeys(lastName);
        Thread.sleep(1000);
        getInputPostalCode().sendKeys(postalCode);
        Thread.sleep(1000);
        getContinueButton().click();

    }

}