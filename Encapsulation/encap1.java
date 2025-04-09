public class encap1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

    
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee("Alice", 101, 50000, 5);
        fullTimeEmp.assignDepartment("Software Engineering");
        fullTimeEmp.calculateSalary(); 
        fullTimeEmp.displayDetails();
        fullTimeEmp.displayDepartmentDetails();

        System.out.println(); 
        PartTimeEmployee partTimeEmp = new PartTimeEmployee("Bob", 202, 100, 20);
        partTimeEmp.assignDepartment("Customer Support");
        partTimeEmp.calculateSalary();
        partTimeEmp.displayDetails();
        partTimeEmp.displayDepartmentDetails();
    }
}

abstract class Employee {
    int employeeId;
    String name;
    double baseSalary;

    public Employee(String name, int employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    void getName() {
        System.out.println(this.name);
    }

    void getId() {
        System.out.println(this.employeeId);
    }

    void getSalary() {
        System.out.println(this.baseSalary);
    }

    void setName(String nname) {
        this.name = nname;
    }

    void setId(int id) {
        this.employeeId = id;
    }

    void setSalary(double sal) {
        this.baseSalary = sal;
    }

    abstract void calculateSalary();

    void displayDetails() {
        System.out.println("The employee name is: " + this.name);
        System.out.println("The employee's ID is: " + this.employeeId);
        System.out.println("The employee's base salary is: " + this.baseSalary);
    }
}


interface Department {
    void assignDepartment(String dept);
    void displayDepartmentDetails();
}


class FullTimeEmployee extends Employee implements Department {
    int yoe;
    String department;

    public FullTimeEmployee(String name, int id, double baseSalary, int yoe) {
        super(name, id, baseSalary);
        this.yoe = yoe;
    }

    @Override
    public void assignDepartment(String val) {
        department = val;
    }

    @Override
    public void displayDepartmentDetails() {
        System.out.println("The department of the employee is: " + department);
    }

    @Override
    void calculateSalary() {
        double salary = this.baseSalary + (this.baseSalary * (this.yoe * 0.1)); 
        this.baseSalary = salary;
    }
}


class PartTimeEmployee extends Employee implements Department {
    int hrs;
    String department;

    public PartTimeEmployee(String name, int id, double baseSalary, int hrs) {
        super(name, id, baseSalary);
        this.hrs = hrs;
    }

    @Override
    void calculateSalary() {
        double salary = this.baseSalary * this.hrs; 
        this.baseSalary = salary;
    }

    @Override
    public void assignDepartment(String val) {
        department = val;
    }

    @Override
    public void displayDepartmentDetails() {
        System.out.println("The department of the employee is: " + department);
    }
}