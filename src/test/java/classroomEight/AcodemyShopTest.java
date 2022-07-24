package classroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcodemyShopTest {
    WebDriver driver;
    WebDriverWait wait;
    public final String ACODEMY_SHOP_URL = "http://shop.acodemy.lv/";

    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {
        //driver = new ChromeDriver();
        // atvērt pilnā logā
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("browserVersion", "103");
//        chromeOptions.setCapability("platformName", "Windows");
//        chromeOptions.setCapability("se:name", "My simple test");
        driver = new RemoteWebDriver(new URL("http://192.168.8.226:4444" ), chromeOptions);

//        SafariOptions browserOptions = new SafariOptions();
//        browserOptions.setCapability("platformName", "macOS 12");
//        browserOptions.setCapability("browserVersion", "15");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("build", "Juris Build 123");
//        sauceOptions.put("name", "Regressiontest run");
//        browserOptions.setCapability("sauce:options", sauceOptions);

//        InternetExplorerOptions browserOptions = new InternetExplorerOptions();
//        browserOptions.setCapability("platformName", "Windows 10");
//        browserOptions.setCapability("browserVersion", "11");
//        Map<String, Object> sauceOptions = new HashMap<>();
//        sauceOptions.put("build", "<your build id>");
//        sauceOptions.put("name", "<your test name>");
//        browserOptions.setCapability("sauce:options", sauceOptions);

          //driver = new RemoteWebDriver(
                //new URL("https://oauth-anda.skadina-341da:7ec563c7-3cfa-4b18-9a5e-c7dc7eeb0444@ondemand.eu-ce" +
                        //"ntral-1.saucelabs.com:443/wd/hub"), browserOptions);

        //driver = new WebDriver(new URL("https://oauth-anda.skadina-341da:7ec563c7-3cfa-4b18-9a5e-c7dc7eeb0444@ondemand.eu-central-1.saucelabs.com:443/wd/hub");

        driver.manage().window().maximize();
        System.out.println("Pirms testa");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));//otrs variants


    }

    @Test
    public void searchForItemTest() {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);

        //galvenaLapa.getSearchInputField().sendKeys("Beanie");//šis abas rindiņas iet kopā, tāpēc tās var ielikt Main
        //new Actions(driver).sendKeys(Keys.ENTER).perform();

        mainPage.setSearchProduct("Beanie");
        System.out.println("SearchResults count" + mainPage.getSearchResults().size());
        Assert.assertEquals (mainPage.getSearchResults().size(),2);
        List<WebElement> searchResults = mainPage.getSearchResults();
//        for (WebElement element : searchResults) {
//            System.out.println(element.findElement(By.cssSelector("h2")).getText());
//        }
        for (int i = 0; i < mainPage.getSearchResults().size(); i++) {
            System.out.println( mainPage.getSearchResults().get(i).findElement(By.cssSelector("h2")).getText());
            System.out.println(mainPage.getSearchResults().get(i).findElement(By.className("price")).getText());
        }


    }





    @Test
    public void searchForItemTest2() {
            driver.get(ACODEMY_SHOP_URL);
            MainPage mainPage = new MainPage(driver);
            mainPage.setSearchProduct("Hoodie");
            System.out.println("SearchResults count" + mainPage.getSearchResults().size());
            Assert.assertEquals(mainPage.getSearchResults().size(),3);


    }

    @Test
    public void switchTabsTest(){
        driver.get("https://www.w3schools.com/");
        System.out.println("Atverti tabi " + driver.getWindowHandles().size());
        driver.findElement(By.id("accept-choices")).click();
        driver.findElement(By.cssSelector("a[title='W3Schools on LinkedIn']")).click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        System.out.println("Atverti tabi " + driver.getWindowHandles().size());
        System.out.println();
    }

    @Test
    public void javaScriptExecutorExampleTest() throws InterruptedException {
        driver.get("https://www.lu.lv/");
        Thread.sleep(2000);//ja šeit ir 1000, tad nepaspēj uz click, jāliek 2000; jānomaina šiet būs uz Wait
        driver.findElement(By.cssSelector("button[id='ccm__footer__consent-bar-submit']")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);
        driver.findElement(By.className("footer__up")).click();
        Thread.sleep(2000);
        System.out.println();

        WebElement element = driver.findElement(By.linkText("Kontakti"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        WebElement menu = driver.findElement(By.className("menuContainer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", menu);
        Thread.sleep(2000);

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);



}

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        WebElement element = driver.findElement(By.cssSelector("div.dropdown2 button"));


        new Actions(driver).moveToElement(element).perform();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Link 1")).click();


    }

    @Test
    public void keyboardClickTest() throws InterruptedException {
        driver.get("https://www.microsoft.com/applied-sciences/projects/anti-ghosting-demo");
        driver.findElement(By.id("clickToUseButton")).click();
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.ALT)
                .perform();
        Thread.sleep(5000);
        new Actions(driver)
                .keyUp(Keys.ALT)
                .perform();

        Thread.sleep(5000);
        new Actions(driver)
                .sendKeys("J")
                .sendKeys("U")
                .sendKeys("R")
                .sendKeys("I")
                .sendKeys("S")
                .perform();
        Thread.sleep(5000);


    }


    @Test
    public void seleniumDocTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/");
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();
        Thread.sleep(5000);

        driver.findElement(By.id("docsearch-input")).sendKeys("Selenium");
        Thread.sleep(3000);

    }








    @AfterMethod
    public void tearDownBrowser(){
        System.out.println("Pēc testa");
        driver.quit();

    }
}

