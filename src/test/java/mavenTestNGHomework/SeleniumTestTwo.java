package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTestTwo {

    //2.uzdevums

    // 2testi, kas atver mājas lapu
    String URL;
    WebDriver chromBrowseris;

    @BeforeMethod
    public void pirmsTestiem(){
        System.out.println("Pirms testa");
       chromBrowseris = new ChromeDriver();

    }


    @Test
    public void checkPageTitle() {

        chromBrowseris.get("https://www.vid.gov.lv/");
        String expectedTitle = "Valsts ieņēmumu dienests |";
        String actualTitle = chromBrowseris.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void checkPageTitleTwo() {

        chromBrowseris.get("https://www.citadele.lv/lv/private/");
        String expectedTitle = "Banka Citadele";
        String actualTitle = chromBrowseris.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        }

    @AfterMethod
    public void tearDownBrowser() {
        System.out.println("Pēc testa");
        chromBrowseris.close();
    }



}
