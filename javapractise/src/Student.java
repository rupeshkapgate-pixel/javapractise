import java.util.*;

// Define the Student class
public class Student {
    String name;
    Integer age;

    // Constructor
    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    // Method to print student details
    @Override
    public String toString() {
        return name + " : " + age;
    }
}