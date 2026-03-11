// Level 1: Person class
class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Instance method
    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Level 2: Employee class
class Employee extends Person {
    int empId;
    double salary;

    // Constructor
    Employee(String name, int age, int empId, double salary) {
        super(name, age); // call Person constructor
        this.empId = empId;
        this.salary = salary;
    }

    // Instance method
    void displayEmployee() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }
}

// Level 3: Manager class
class Manager extends Employee {
    String department;

    // Constructor
    Manager(String name, int age, int empId,
            double salary, String department) {
        super(name, age, empId, salary); // call Employee constructor
        this.department = department;
    }

    // Instance method
    void displayManager() {
        System.out.println("Department: " + department);
    }
}
public class TestMultilevelnheritance {
    public static void main(String[] args) {
        
        Manager m = new Manager(
                "Milap Vora",
                21,
                1002,
                900000,
                "IT"
        );

        m.displayPerson();    // from Person
        m.displayEmployee();  // from Employee
        m.displayManager();   // from Manager
    }
}
