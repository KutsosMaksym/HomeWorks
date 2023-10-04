package HWS.HW7;

import HWS.HW7.Rectangle;
import org.testng.annotations.Test;

public class RectangleTest {

    @Test
    void checkRectangleMeasurements() {
        Rectangle rectangle = new Rectangle(5, 10);
        Rectangle square = new Rectangle(29.4);

        System.out.println("Area of rectangle is " + rectangle.area());
        System.out.println("Perimeter of rectangle is " + rectangle.perimeter());
        System.out.println("Area of square is " + square.area());
        System.out.println("Perimeter of square is " + square.perimeter());
    }
}
