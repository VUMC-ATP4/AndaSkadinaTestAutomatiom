package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;
    private By checkoutComplete = By.cssSelector("span[class= 'title'");  // Checkout: Complete!
    private By backHomeButton = By.id("back-to-products");

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBackHomeButton(){
        return driver.findElement(backHomeButton);
    }

    public WebElement getCheckoutComplete(){
        return driver.findElement(checkoutComplete);
    }

}
