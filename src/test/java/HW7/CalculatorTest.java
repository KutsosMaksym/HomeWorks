package HW7;

import org.testng.annotations.Test;

public class CalculatorTest {
    int a = 10;
    int b = 5;
    double c = 12.4;
    double d = 1.1;
    Calculator calculator = new Calculator();

    @Test(priority = 1)
    public void addCheck() {
        System.out.println("add");
        System.out.println(calculator.add(a, b));
        System.out.println(calculator.add(c, d));
    }

    @Test(priority = 2)
    public void subtractCheck() {
        System.out.println("subtract");
        System.out.println(calculator.subtract(a, b));
        System.out.println(calculator.subtract(c, d));
    }

    @Test(priority = 3)
    public void multiplyCheck() {
        System.out.println("multiply");
        System.out.println(calculator.multiply(a, b));
        System.out.println(calculator.multiply(c, d));
    }

    @Test(priority = 4)
    public void divideCheck() {
        System.out.println("divide");
        System.out.println(calculator.divide(a, b));
        System.out.println(calculator.divide(c, d));
    }

}
