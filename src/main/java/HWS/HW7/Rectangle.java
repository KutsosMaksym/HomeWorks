package HWS.HW7;

public class Rectangle {
    private double high;
    private double widh;

    public Rectangle(double high, double widh) {
        this.high = high;
        this.widh = widh;
    }

    public Rectangle(double side) {
        this.high = side;
        this.widh = side;
    }

    public double area() {
        return high * widh;
    }

    public double perimeter() {
        return 2 * (high + widh);
    }
}
