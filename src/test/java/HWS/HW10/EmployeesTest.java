package HWS.HW10;

import org.testng.annotations.Test;

public class EmployeesTest {
    @Test
    public void qaTest() {
        QA qa = new QA("Bob", "LA", 1000);
        QA qa2 = new QA("Bob", "LA", 1000);
        QA qa3 = new QA("Ben", "LA", 1000);
        System.out.println("Is " + qa + " equals to " + qa2 + " " + qa.equals(qa2));
        System.out.println("Is " + qa + " equals to " + qa3 + " " + qa.equals(qa3));
        qa.performanceReport();
        qa.employeeJobDescription();
        qa.calculateBonus();
    }

    @Test
    public void managerTest() {
        Manager manager = new Manager("Bob", "LA", 1000);
        Manager manager2 = new Manager("Bob", "LA", 1000);
        Manager manager3 = new Manager("Bob", "NY", 1000);
        System.out.println("Is " + manager + " equals to " + manager2 + " " + manager.equals(manager2));
        System.out.println("Is " + manager + " equals to " + manager3 + " " + manager.equals(manager3));
        manager.performanceReport();
        manager.employeeJobDescription();
        manager.calculateBonus();
    }

    @Test
    public void developerTest() {
        Developer developer1 = new Developer("Bob", "LA", 1000);
        Developer developer2 = new Developer("Bob", "LA", 1000);
        Developer developer3 = new Developer("Bob", "NY", 900);
        System.out.println("Is " + developer1 + " equals to " + developer2 + " " + developer1.equals(developer2));
        System.out.println("Is " + developer1 + " equals to " + developer3 + " " + developer1.equals(developer3));
        developer1.performanceReport();
        developer1.employeeJobDescription();
        developer1.calculateBonus();
    }
}
