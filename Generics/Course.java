// 3. Multi-Level University Course Management System
// Concepts: Generic Classes, Wildcards, Bounded Type Parameters
// Problem Statement:
// Develop a university course management system where different departments offer courses with different evaluation types (e.g., Exam-Based, Assignment-Based, Research-Based).
// Hints:
// Create an abstract class CourseType (e.g., ExamCourse, AssignmentCourse, ResearchCourse).
// Implement a generic class Course<T extends CourseType> to manage different courses.
// Use wildcards (List<? extends CourseType>) to handle any type of course dynamically.

import java.util.ArrayList;

abstract class CourseType{
    String courseType;
    public CourseType(String courseType){
        this.courseType = courseType;
    }
    public abstract void evaluate();
}
class ExamCourse extends CourseType{
    public ExamCourse(String courseType){
        super(courseType);
    }
    @Override
    public void evaluate(){
        System.out.print("Exam-Based Evaluation");
    }
}
class AssignmentCourse extends CourseType{
    public AssignmentCourse(String courseType){
        super(courseType);
    }
    
    @Override
    public void evaluate(){
        System.out.print("Assignment-Based Evaluation");
    }
}
class ResearchCourse extends CourseType{
    public ResearchCourse(String courseType){
        super(courseType);
    }
    @Override
    public void evaluate(){
        System.out.print("Research-Based Evaluation");
    }
}
public class Course<T extends CourseType> {
    private T course;
    public void evaluateCourse(){
        course.evaluate();
    }
    ArrayList<T> courseList = new ArrayList<>();
    public void addCourse(T course){
        courseList.add(course);
    }
    public void displayCourses(){
        for(T course : courseList){
            System.out.print(course.courseType + "\t Evaluation Type : ");
            course.evaluate();
            System.out.println();
        }
    }

   
    public static void main(String[] args) {
        Course<CourseType> University = new Course<>();
        University.addCourse(new ExamCourse("MCA"));
        University.addCourse(new AssignmentCourse("Food Science"));
        University.addCourse(new ResearchCourse("Phd in Nueral Networks"));
        University.displayCourses();
       
    }
}