package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver driver;
    private By inventoryItemName = By.cssSelector("div[class='inventory_item_name']");
    private By paymentInformation = By.cssSelector("div[class='summary_info'] > div:nth-child(1) ");//Payment Information,
    private By paymentInformationNr = By.cssSelector("div[class='summary_info'] > div:nth-child(2) ");//SauceCard #31337,
    private By shippingInformation = By.cssSelector("div[class='summary_info'] > div:nth-child(3) ");//Shipping Information
    private By shippingInformationWhere = By.cssSelector("div[class='summary_info'] > div:nth-child(4)");//FREE PONY EXPRESS DELIVERY!

    private By itemTotal = By.cssSelector("div[class='summary_subtotal_label']");// Item total: $ 29.99
    private By tax = By.cssSelector("div[class='summary_tax_label']"); //Tax: $ 2.40
    private By total = By.cssSelector("div[class='summary_total_label']"); //Total: $ 32.39
    private By finishButton = By.id("finish");






    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;}

    public WebElement getInventoryItemName(){
        return driver.findElement(inventoryItemName);
    }
    public WebElement getpaymentInformation(){
        return driver.findElement(paymentInformation);
    }
    public WebElement getShippingInformation(){
        return driver.findElement(shippingInformation);
    }
    public WebElement getShippingInformationWhere(){
        return driver.findElement(shippingInformationWhere);
    }
    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }

    public WebElement getPaymentInformationNr(){
        return driver.findElement(paymentInformationNr);
    }
    public WebElement getItemTotal(){
        return driver.findElement(itemTotal);
    }
    public WebElement getTaxr(){
        return driver.findElement(tax);
    }

    public WebElement getTotal(){
        return driver.findElement(total);
    }
}
