package HWS.HW8;

import org.testng.annotations.Test;

public class StudentTest {

    @Test
    public void checkStudentInfo() {
        Student student = new Student();
        Student.displayStudentInfo(student);
        student.setName(null);
        Student.displayStudentInfo(student);
        student = null;
        Student.displayStudentInfo(student);
    }
}
