package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calculator {

    CalculatorTo calculator;

//    @BeforeTest
//    public void pirmsTests() {
//        System.out.println("Sakas tests");
//        calculator = new Calculator();
//    }
    @BeforeMethod
    public void pirmsTests() {
        System.out.println("Sākas tests");
        calculator = new CalculatorTo();
    }

    @Test
    public void testSum() {
        int actualResult = calculator.add(13, 25);
        int expectedResult = 38;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(calculator.multiply(5, 5), 25);
    }
    @Test
    public void testSubstract() {
        Assert.assertEquals(calculator.substract(15, 5), 10);
    }
    @Test
    public void testDivide() {
        Assert.assertEquals(calculator.divide(25, 5), 5);
    }
}

