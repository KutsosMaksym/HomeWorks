package HWS.HW10;

public class Manager extends Employee {

    public Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }

    @Override
    public void calculateBonus() {
        System.out.println("Bonus is: " + this.salary * 0.5);
    }

    @Override
    public void employeeJobDescription() {
        System.out.println(jobTitle + " " + " has the responsibility of the planning, procurement and execution of a project");
    }
}
