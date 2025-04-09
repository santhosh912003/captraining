import java.util.*;

// College class
class College {
    private String collegeName;
    private List<Teacher> teachers;
    private List<Student> students;

    public College(String name) {
        this.collegeName = name;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayDetails() {
        System.out.println("College: " + collegeName);
        System.out.println("Teachers:");
        for (Teacher t : teachers) {
            System.out.println("- " + t.getName() + " (" + t.getSubject() + ")");
        }

        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName() + " (" + s.getCourse() + ")");
        }
    }
}

// Teacher class
class Teacher {
    public String name;
    public String subject;
    public College college;

    public Teacher(String name, String subject, College college) {
        this.name = name;
        this.subject = subject;
        this.college = college;
        college.addTeacher(this); // automatically link to college
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public void display() {
        System.out.println(name + " teaches " + subject + " at " + college.getCollegeName());
    }
}

// Student class
class Student {
    public String name;
    public String course;
    public College college;

    public Student(String name, String course, College college) {
        this.name = name;
        this.course = course;
        this.college = college;
        college.addStudent(this); // automatically link to college
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void display() {
        System.out.println(name + " is studying " + course + " at " + college.getCollegeName());
    }
}

// Main class
public class sample3 {
    public static void main(String[] args) {
        College myCollege = new College("ABC Engineering College");

        Teacher t1 = new Teacher("Dr. Ramesh", "Mathematics", myCollege);
        Teacher t2 = new Teacher("Ms. Priya", "Computer Science", myCollege);

        Student s1 = new Student("Anu", "CSE", myCollege);
        Student s2 = new Student("Vikram", "ECE", myCollege);

        myCollege.displayDetails();

        System.out.println("\nIndividual Details:");
        t1.display();
        s1.display();
    }
}