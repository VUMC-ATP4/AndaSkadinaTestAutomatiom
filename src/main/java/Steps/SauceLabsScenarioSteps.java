package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.LogginPage;
import pageObjectsHomework.*;

import java.time.Duration;

public class SauceLabsScenarioSteps {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        //Initilaize page objects for login
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);

    }
    @After
    public void tearDown(){
        driver.quit();
    }


    @Given("user is loged in")
    public void userIsLogedIn() {
        driver.get(SAUCELABS_URL);
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
        loginPage.getUsernameInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();


    }

//    @Then("user sees inventory page")
//    public void user_sees_inventory_page() {
//        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
//    }

    @When("user clicks Add to cart  Sauce labs backpack")
    public void userClicksAddToCartSauceLabsBackpack() throws InterruptedException {
        inventoryPage.getAddToCartButtonBackpack().click();
        Thread.sleep(1000);
    }


    @And("user clicks Cart link")
    public void user_clicks_cart_link() throws InterruptedException {
        cartPage.getCartLink().click();
        Thread.sleep(1000);

    }

    @Then("user sees in Cart product {string}")
    public void user_sees_in_cart_product(String product) throws InterruptedException {
        Assert.assertEquals(cartPage.getCartContentsSaucelabsBackpack().getText(),product);
        Thread.sleep(1000);
    }

    @When("user clicks Checkout button")
    public void user_clicks_checkout_button() throws InterruptedException {
        checkoutPage.getCheckoutButton().click();
        Thread.sleep(1000);

    }


    @And("user enters  {string}, {string},{string}")
    public void user_enters(String FirstName, String LastName, String PostalCode) throws InterruptedException {
        checkoutPage.getInputFirstName().sendKeys(FirstName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        checkoutPage.getInputLastName().sendKeys(LastName);
        Thread.sleep(1000);
        checkoutPage.getInputPostalCode().sendKeys(PostalCode);
        Thread.sleep(1000);


    }

    @And("user clicks continue button")
    public void user_clicks_continue_button() throws InterruptedException {
        checkoutPage.getContinueButton().click();
        Thread.sleep(1000);
    }

    @Then("user sees product {string}")
    public void user_sees_product(String productName) {
        Assert.assertEquals(checkoutOverviewPage.getInventoryItemName().getText(),productName);

    }

    @And("user sees payment text {string}")
    public void userSeesPaymentTextPaymentInformation(String paymentInfo) {
        Assert.assertEquals(checkoutOverviewPage.getpaymentInformation().getText(),paymentInfo);
    }



    @And("user sees in the next row payment detal ext {string}")
    public void userSeesInTheNextRowPaymentDetalExtSauceCard(String paymentInfoDetal) {
        Assert.assertEquals(checkoutOverviewPage.getPaymentInformationNr().getText(),paymentInfoDetal);
    }
    @And("user sees shiping text {string}")
    public void userSeesShipingTextShippingInformation(String shipingInfo) {
        Assert.assertEquals(checkoutOverviewPage.getShippingInformation().getText(),shipingInfo);
    }
    @And("user sees in the next row shipingdetal text {string}")
    public void userSeesInTheNextRowShipingdetalTextFREEPONYEXPRESSDELIVERY(String shipingInfoDetal) {
        Assert.assertEquals(checkoutOverviewPage.getShippingInformation().getText(),shipingInfoDetal);
    }
    @And("user sees in the next row  item total sum text {string}")
    public void userSeesInTheNextRowItemTotalSumTextItemTotal$(String itemTotal) {
        Assert.assertEquals(checkoutOverviewPage.getShippingInformation().getText(),itemTotal);
    }

    @And("user sees in the next row  tax sum text {string}")
    public void userSeesInTheNextRowTaxSumTextTax$(String tax) {
        Assert.assertEquals(checkoutOverviewPage.getShippingInformation().getText(),tax);
    }
    @And("user sees in the next row  total sum text {string}")
    public void userSeesInTheNextRowTotalSumTextTotal$(String total) {
        Assert.assertEquals(checkoutOverviewPage.getShippingInformation().getText(),total);
    }

    @When("user clicks FINISH button")
    public void user_clicks_finish_button() throws InterruptedException {
        checkoutOverviewPage.getFinishButton().click();
        Thread.sleep(1000);

    }
    @Then("user sees page {string}")
    public void userSeesPageCHECKOUTCOMPLETE(String chComp) {
        Assert.assertEquals(checkoutSuccessPage.getCheckoutComplete().getText(),chComp);

    }


    @When("user clicks BACK HOME button")
    public void user_clicks_back_home_button() throws InterruptedException {
        checkoutSuccessPage.getBackHomeButton().click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

    }


    //2.SCENARIJS
    @Then("user sees error message  {string}")
    public void user_sees_error_message(String string) {

    }

    @Given("user sees checkout page")
    public void user_sees_checkout_page() {

    }

    @When("user enter {string},{string},{string}")
    public void user_enter(String string, String string2, String string3) {

    }



}
