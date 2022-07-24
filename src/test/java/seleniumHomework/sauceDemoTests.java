package seleniumHomework;


import io.cucumber.java.bs.A;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.WebElement;
import pageObjectsHomework.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class sauceDemoTests {
    WebDriver driver;
    WebDriverWait wait;
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Pirms testa");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }
    //1.Scenārijs
    @Test
    public void sucessLoginPageObject() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
        inventoryPage.getAddToCartButtonBackpack().click();
        Thread.sleep(1000);

        CartPage cartPage = new CartPage(driver);
        cartPage.getCartLink().click();
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getCartContentsSaucelabsBackpack().getText(),"Sauce Labs Backpack");
        Thread.sleep(1000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutButton().click();
        Thread.sleep(1000);
        checkoutPage.getInputFirstName().sendKeys("Anda");
        Thread.sleep(1000);
        checkoutPage.getInputLastName().sendKeys("Skadina");
        Thread.sleep(1000);
        checkoutPage.getInputPostalCode().sendKeys("LV3018");
        Thread.sleep(1000);
        checkoutPage.getContinueButton().click();
        Thread.sleep(1000);

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
       Assert.assertEquals(checkoutOverviewPage.getInventoryItemName().getText(),"Sauce Labs Backpack");
       Assert.assertEquals(checkoutOverviewPage.getpaymentInformation().getText(),"Payment Information:");
       Assert.assertEquals(checkoutOverviewPage.getPaymentInformationNr().getText(),"SauceCard #31337");
        Assert.assertEquals(checkoutOverviewPage.getShippingInformation().getText(),"Shipping Information:");
        Assert.assertEquals(checkoutOverviewPage.getShippingInformationWhere().getText(), "FREE PONY EXPRESS DELIVERY!");
        Assert.assertEquals(checkoutOverviewPage.getItemTotal().getText(),"Item total: $29.99");
        Assert.assertEquals(checkoutOverviewPage.getTaxr().getText(),"Tax: $2.40");
        Assert.assertEquals(checkoutOverviewPage.getTotal().getText(),"Total: $32.39");
        checkoutOverviewPage.getFinishButton().click();
        Thread.sleep(1000);

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getCheckoutComplete().getText(),"CHECKOUT: COMPLETE!");
        checkoutSuccessPage.getBackHomeButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");




    }

     //2.scenārijs
    @Test
    public void errorCheckoutEmptyAll() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartLink().click();
        Thread.sleep(1000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkInfo("", "", "");
        Assert.assertEquals(checkoutPage.getCheckoutErrorText().getText(), "Error: First Name is required");
        Thread.sleep(1000);
    }
    @Test
    public void errorCheckoutEmptyFirstName() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartLink().click();
        Thread.sleep(1000);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkInfo("", "Skadina", "LV31018");
        Assert.assertEquals(checkoutPage.getCheckoutErrorText().getText(), "Error: First Name is required");
        Thread.sleep(1000);
    }
    @Test
    public void errorCheckoutEmptyLastname() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartLink().click();
        Thread.sleep(1000);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkInfo("Anda", "", "LV3018");
        Assert.assertEquals(checkoutPage.getCheckoutErrorText().getText(), "Error: Last Name is required");
        Thread.sleep(1000);
    }
    @Test
    public void errorCheckoutEmptyPostalcodee() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartLink().click();
        Thread.sleep(1000);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkInfo("Anda", "Skadina", "");
        Assert.assertEquals(checkoutPage.getCheckoutErrorText().getText(), "Error: Postal Code is required");
        Thread.sleep(1000);
    }
//
    @Test
    public void errorCheckoutEmptyFirsLastName() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        CartPage cartPage = new CartPage(driver);
        cartPage.getCartLink().click();
        Thread.sleep(1000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkInfo("", "", "LV3018");
        Assert.assertEquals(checkoutPage.getCheckoutErrorText().getText(), "Error: First Name is required");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDownBrowser(){
        System.out.println("Pēc testa");
        driver.close();

    }

}
