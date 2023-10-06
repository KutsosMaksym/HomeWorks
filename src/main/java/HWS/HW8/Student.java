package HWS.HW8;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student (){
        this.name = "Max";
        this.age = 29;
    }

    public static void displayStudentInfo(Student student) {
        try {
            System.out.println("Student name is " + student.name + ", he is " + student.age);
        } catch (NullPointerException e) {
            System.out.println("There are no data for this student");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
