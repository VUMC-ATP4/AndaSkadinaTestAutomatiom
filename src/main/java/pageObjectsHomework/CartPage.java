package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver driver;
    private By cartLink = By.className("shopping_cart_link");
    private By cartContentsSaucelabsBackpack = By.cssSelector("div[class ='inventory_item_name']");


    public CartPage(WebDriver driver) {
        this.driver = driver;}

    public WebElement getCartLink(){
        return driver.findElement(cartLink);
        }
    public WebElement getCartContentsSauceLabsBackpack(){

        return driver.findElement(cartContentsSaucelabsBackpack);
    }
    public WebElement getCartContentsSaucelabsBackpack(){
        return driver.findElement(cartContentsSaucelabsBackpack);
    }



}
