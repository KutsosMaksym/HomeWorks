package HWS.HW10;

public class QA extends Employee {

    public QA(String name, String address, double salary) {
        super(name, address, salary, "QA");
    }

    @Override
    public void calculateBonus() {
        System.out.println("Bonus is: " + this.salary * 0.25);
    }

    @Override
    public void employeeJobDescription() {
        System.out.println("This employee can create tests that identify issues with software before a product launch");
    }
}
