package HWS.HW10;

import java.util.Objects;
import java.util.Random;

public abstract class Employee {
    String name;
    String address;
    double salary;
    String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public abstract void calculateBonus();

    public void performanceReport() {
        System.out.println("Assessment for work for " + jobTitle + " " + name + ": " + getEvaluation());
    }


    public abstract void employeeJobDescription();

    @Override
    public int hashCode() {
        return Objects.hash(name, address, salary, jobTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        Employee employee1 = (Employee) o;
        return (address.equals(employee1.address) && name.equals(employee.name) &&
                jobTitle.equals(employee.jobTitle) && salary == (employee.salary));

    }

    @Override
    public String toString() {
        return "Employee " + name + " works as a " + jobTitle + ". Salary: " + salary + " Address: " + address;
    }

    public static Evaluation getEvaluation() {
        Random rand = new Random();
        return switch (rand.nextInt(5)) {
            case 0 -> Evaluation.EXCELLENT;
            case (1) -> Evaluation.VERY_GOOD;
            case (2) -> Evaluation.GOOD;
            case (3) -> Evaluation.BAD;
            case (4) -> Evaluation.VERY_BAD;
            default -> null;
        };
    }
}
