package HWS.HW10;

public class Developer extends Employee {

    public Developer(String name, String address, double salary) {
        super(name, address, salary, "Software developer");
    }

    @Override
    public void calculateBonus() {
        System.out.println("Bonus is: " + this.salary * 0.4);
    }

    @Override
    public void employeeJobDescription() {
        System.out.println("This employee can create new software and improve existing software applications");
    }
}
