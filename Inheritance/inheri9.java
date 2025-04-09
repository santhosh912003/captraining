public class inheri9 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice", 35, "Mathematics");
        Student student = new Student("Bob", 16, "10th Grade");
        Staff staff = new Staff("Charlie", 40, "Administration");

        teacher.displayRole();
        student.displayRole();
        staff.displayRole();
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Teacher: " + name + " teaches " + subject);
    }
}

class Student extends Person {
    String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Student: " + name + " is in " + grade);
    }
}

class Staff extends Person {
    String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Staff: " + name + " works in the " + department + " department");
    }
}