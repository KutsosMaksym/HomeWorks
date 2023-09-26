package HW7;

import org.testng.annotations.Test;

public class CalculatorTest {
    int a = 10;
    int b = 5;
    double c = 12.4;
    double d = 1.1;

    @Test(priority = 1)
    public void addCheck() {
        System.out.println("add");
        System.out.println(Calculator.add(a, b));
        System.out.println(Calculator.add(c, d));
    }

    @Test(priority = 2)
    public void subtractCheck() {
        System.out.println("subtract");
        System.out.println(Calculator.subtract(a, b));
        System.out.println(Calculator.subtract(c, d));
    }

    @Test(priority = 3)
    public void multiplyCheck() {
        System.out.println("multiply");
        System.out.println(Calculator.multiply(a, b));
        System.out.println(Calculator.multiply(c, d));
    }

    @Test(priority = 4)
    public void divideCheck() {
        System.out.println("divide");
        System.out.println(Calculator.divide(a, b));
        System.out.println(Calculator.divide(c, d));
    }

}
