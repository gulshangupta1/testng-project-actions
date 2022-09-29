import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CalculatorTest {
    Calculator calculator;
    int count=0;

    @BeforeMethod (alwaysRun = true)
    private void setup() {
        calculator = new Calculator();
//        System.out.println("hello");
    }

//    @DataProvider(name = "additionData")
//    private Object[][] additionDataMethod() {
//        return new Object[][]{{1,2,3},
//                {2,3,5},
//                {5,5,10}};
//    }

    @Test (dataProvider = "additionData", dataProviderClass = DataProviderExample.class, groups = {"simpleCalculation"})
    private void testAdditionOfTwoNumbers(int a, int b, int result){
        //Act
//        Calculator calculator = new Calculator();
//        calculator = new Calculator();
        int addition = calculator.add(a, b);

        //Assert
        Assert.assertEquals(addition, result);
    }

    @Test (groups = {"simpleCalculation"})
    private void testSubtractionOfTwoNumbers() {
        //Act
//        int subtraction = calculator.subtract(a, b);

        //Assert
//        Assert.assertEquals(subtraction, result);
        Assert.assertEquals(calculator.subtract(5, 2), 3);
    }

    @Test (groups = {"simpleCalculation"})
    private void testMultiplicationOfTwoNumbers() {
        Assert.assertEquals(calculator.multiply(10, 2), 20);
    }

    @Test (groups = {"simpleCalculation"})
    private void testDivisionOfTwoNumbers() {
        Assert.assertEquals(calculator.divide(4, 2), 2);
    }

    @Test (groups = {"complexCalculation"})
    private void testPercentageOfTwoNumbers() {
        Assert.assertEquals(calculator.percentage(100, 100), 100);
    }

    @Test(groups = {"complexCalculation"})
    private void testSquareOfNumbers() {
        Assert.assertEquals(calculator.square(5), 25);
    }

    @AfterMethod
    private void teardown() {
        count++;
        System.out.println("Number of Test method completed: "+ count);
    }
}
