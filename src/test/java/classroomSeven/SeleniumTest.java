//package classroomSeven;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageObject.InventoryPage;
//import pageObject.LogginPage;
//
//import java.time.Duration;
//import java.util.List;
//
////koments
//public class SeleniumTest {
//    WebDriver driver;
//    WebDriverWait wait;
//    public final String SAUCELABS_URL = "https://www.saucedemo.com/"; //konstants
//
//    @BeforeMethod
//    public void setupBrowser(){
//        driver = new ChromeDriver();
//        // atvērt pilnā logā
//        driver.manage().window().maximize();
//        System.out.println("Pirms testa");
//        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));//otrs variants
//
//
//    }
//
//    @Test
//    public void localHTMLExerciseTest() throws InterruptedException {
//        driver.get("file://C:\\Users\\User\\Desktop\\Java\\AndaSkadinaTest2\\AndaSkadinaTestAutomatiom\\src\\test\\resources\\elements.html");
//        WebElement descriptionTextArea = driver.findElement(By.name("description"));
//        descriptionTextArea.clear();
//        descriptionTextArea.sendKeys("Šis ir teksts par mani, hello hello");
//        WebElement linkElements = driver.findElement(By.linkText("Link Text"));
//        linkElements.click();
//        WebElement isStudentChecbox = driver.findElement(By.id("studentID"));
//        Assert.assertEquals(isStudentChecbox.isSelected(), false);//atgriež boolean vērtību, tikai uz checkboxiem un radiobuttoniem
//        Thread.sleep(5000);
//        isStudentChecbox.click();
//        Assert.assertEquals(isStudentChecbox.isSelected(), true);
//        Select milakaKrasa = new Select(driver.findElement(By.id("colorsID")));
//        milakaKrasa.selectByIndex(0);
//        milakaKrasa.selectByIndex(3);
//        List<WebElement> sarakstsArKrasam = milakaKrasa.getOptions();//lidzigi ka masivs; šeit saraksts ar elementiem
//
//       for (int i = 0; i<sarakstsArKrasam.size();i++){
//           System.out.println(sarakstsArKrasam.get(i).getText());
//       }
//       WebElement nospiedmaniPoga = driver.findElement(By.id("checkDataID"));
//       nospiedmaniPoga.click();
//
//
//        WebElement vissIrLabiTeksts = driver.findElement(By.id("checkDataResultID"));
//        wait.until(ExpectedConditions.elementToBeClickable(vissIrLabiTeksts));//gaidi tikai uz šo viss ir labi teskts. uz pārējo nē
//
//        vissIrLabiTeksts.click();
//
//
//
//
//
//
//
//
//        //Thread.sleep(5000);
//
//    }
//
//    @Test
//    public void successFullLoginTest() throws InterruptedException {
//        driver.get(SAUCELABS_URL);
//        WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"
//        ));
//        System.out.println(acceptedUsernamesText.getText());
//        WebElement userNameInputField = driver.findElement(By.id("user-name"));
//        userNameInputField.sendKeys("standard_user");
//        WebElement passvordInputField = driver.findElement(By.id("password"));
//        passvordInputField.sendKeys("secret_sauce");
//        WebElement logginBaton = driver.findElement(By.id("login-button"));
//        logginBaton.click();
//        Thread.sleep(5000);
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
//        WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
//        Assert.assertEquals(pageTitleText.getText(), "PRODUCTS");
//        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
//        sortDropdown.selectByValue("hilo");
//        Thread.sleep(5000);
//        sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
//        sortDropdown.selectByIndex(1);
//        WebElement linkedInLink = driver.findElement(By.linkText("Facebook"));
//        linkedInLink.click();
//        Thread.sleep(5000);
//
//
//    }
//    @AfterMethod
//    public void tearDownBrowser(){
//        System.out.println("Pēc testa");
//        driver.close();
//
//    }
//    @Test
//    public void sucessLoginPageObject(){
//        driver.get(SAUCELABS_URL);
//        LogginPage loginPage = new LogginPage(driver);
////        loginPage.getUsernameInputField().sendKeys("standard_user");
////        loginPage.getPasswordInputField().sendKeys("secret_sauce");
////        loginPage.getLoginButton().click();
////        LogginPage.login("Juris","");
////        InventoryPage inventoryPage = new InventoryPage(driver);
////        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
////        inventoryPage.getLinkedinLink().click();
////
////    }
//
//
//
//
//
//    @Test
//    public void errorMessagePasswordEmotyPageObjectTest(){// šādi ir daudz lasāmāks nkeā tas garais
//        driver.get(SAUCELABS_URL);
//        LogginPage loginPage = new LogginPage(driver);
//        loginPage.getUsernameInputField().sendKeys("Juris");
//        loginPage.getPasswordInputField().sendKeys("");
//        loginPage.getLoginButton().click();
//        loginPage.getErrorText().getText();
//        Assert.assertEquals(loginPage.getErrorText().getText(),"Epic sadface: Password is required");
//
//
//
//}
//
//
//    @Test
//    public void errorMessagepasswordEmptyTest() throws InterruptedException {
//        System.out.println("Tests");
//       // driver.get("https://www.saucedemo.com/"); //šo var iznest kā konstantu. lai neatkārtojas kods. uztaisa public final string
//        driver.get(SAUCELABS_URL);
//        WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"
//    ));
//        System.out.println(acceptedUsernamesText.getText());
//        WebElement userNameInputField = driver.findElement(By.id("user-name"));//webelements ir jebkurš elements html, gan div, gan citi
//        userNameInputField.sendKeys("Anda");
//        WebElement passvordInputField = driver.findElement(By.id("password"));
//        passvordInputField.sendKeys("");
//        WebElement logginBaton = driver.findElement(By.id("login-button"));
//        logginBaton.click();
//        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        //String actualText = errorText.getText();
//        //String expectedText = "Epic sadface: Password is required";
//        Assert.assertEquals(errorText.getText(),"Epic sadface: Password is required");
//        Thread.sleep(5000);//liek pagulēt javai,lai var apskatīt izdarīto ja sleep sarkans pasvitrots, labias taust, izvelas Add except...
//
//    }
//
//    @Test
//    public void errorMessageUserNameEmptyTest() throws InterruptedException {
//        System.out.println("Tests");
//        // driver.get("https://www.saucedemo.com/"); //šo var iznest kā konstantu. lai neatkārtojas kods. uztaisa public final string
//        driver.get(SAUCELABS_URL);
//        WebElement userNameInputField = driver.findElement(By.id("user-name"));//webelements ir jebkurš elements html, gan div, gan citi
//        userNameInputField.sendKeys("");
//        WebElement passvordInputField = driver.findElement(By.id("password"));
//        passvordInputField.sendKeys("Parole");
//        WebElement logginBaton = driver.findElement(By.id("login-button"));
//        logginBaton.click();
//        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        //String actualText = errorText.getText();
//        //String expectedText = "Epic sadface: Password is required";
//        Assert.assertEquals(errorText.getText(),"Epic sadface: Username is required");
//        Thread.sleep(5000);//liek pagulēt javai,lai var apskatīt izdarīto ja sleep sarkans pasvitrots, labias taust, izvelas Add except...
//
//    }
//    @Test
//    public void errorMessageUserNamePasswordEmptyTest() throws InterruptedException {
//        System.out.println("Tests");
//        // driver.get("https://www.saucedemo.com/"); //šo var iznest kā konstantu. lai neatkārtojas kods. uztaisa public final string
//        driver.get(SAUCELABS_URL);
//        WebElement userNameInputField = driver.findElement(By.id("user-name"));//webelements ir jebkurš elements html, gan div, gan citi
//        userNameInputField.sendKeys("");
//        WebElement passvordInputField = driver.findElement(By.id(""));
//        passvordInputField.sendKeys("Parole");
//        WebElement logginBaton = driver.findElement(By.id("login-button"));
//        logginBaton.click();
//        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        //String actualText = errorText.getText();
//        //String expectedText = "Epic sadface: Password is required";
//        Assert.assertEquals(errorText.getText(),"Epic sadface: Username is required");
//        Thread.sleep(5000);//liek pagulēt javai,lai var apskatīt izdarīto ja sleep sarkans pasvitrots, labias taust, izvelas Add except...
//
//    }
//    @Test
//    public void errorMessageWrongCredentialsTest() throws InterruptedException {
//        System.out.println("Tests");
//        // driver.get("https://www.saucedemo.com/"); //šo var iznest kā konstantu. lai neatkārtojas kods. uztaisa public final string
//        driver.get(SAUCELABS_URL);
//        WebElement userNameInputField = driver.findElement(By.id("user-name"));//webelements ir jebkurš elements html, gan div, gan citi
//        userNameInputField.sendKeys("Anda");
//        WebElement passvordInputField = driver.findElement(By.id(""));
//        passvordInputField.sendKeys("Parole");
//        WebElement logginBaton = driver.findElement(By.id("login-button"));
//        logginBaton.click();
//        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        //String actualText = errorText.getText();
//        //String expectedText = "Epic sadface: Password is required";
//        Assert.assertEquals(errorText.getText(),"Epic sadface: Username and password do not match any user in this service");
//        Thread.sleep(5000);//liek pagulēt javai,lai var apskatīt izdarīto ja sleep sarkans pasvitrots, labias taust, izvelas Add except...
//
//    }
//
//}
