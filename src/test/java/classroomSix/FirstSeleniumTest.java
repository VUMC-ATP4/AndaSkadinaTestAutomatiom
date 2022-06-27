package classroomSix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
@Test
public void checkPageTitle(){
    String URL = "https://www.saucedemo.com/";
    //atvērt Chrom
    WebDriver chromBrowseris = new ChromeDriver();
    chromBrowseris.get(URL);
    String expectedTitle = "Swag Labs";
    String actualTitle = chromBrowseris.getTitle();
    Assert.assertEquals(actualTitle,expectedTitle);//ja šeit kļūda, tālāk neiet
    chromBrowseris.quit();
}
}
