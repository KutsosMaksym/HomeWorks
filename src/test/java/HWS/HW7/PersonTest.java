package HWS.HW7;

import HWS.HW7.Person;
import org.testng.annotations.Test;

public class PersonTest {

    @Test
    void checkPersonsFields () {
        Person person1 = new Person("Ben", 34);
        Person person2 = new Person("John", 29);
        System.out.println(person1);
        System.out.println(person2);
    }
}
