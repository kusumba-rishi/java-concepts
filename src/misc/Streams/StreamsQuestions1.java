package misc.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
                + department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
    }
}

public class StreamsQuestions1 {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        System.out.println("How many male and female employees are there in the organization?");
        Map<String, Long> q1 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(q1);
        System.out.println("----------");

        System.out.println("Print the name of all departments in the organization?");
        List<String> q2 = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .toList();
        System.out.println(q2);
        System.out.println("----------");

        System.out.println("What is the average age of male and female employees?");
        Map<String, Double> q3 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(q3);
        System.out.println("----------");

        System.out.println("Get the details of highest paid employee in the organization?");
        Employee q4 = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(q4);
        System.out.println("----------");

        System.out.println("Get the names of all employees who have joined after 2015?");
        List<String> q5 = employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .toList();
        System.out.println(q5);
        System.out.println("----------");

        System.out.println("Count the number of employees in each department?");
        Map<String, Long> q6 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(q6);
        System.out.println("----------");

        System.out.println("What is the average salary of each department?");
        Map<String, Double> q7 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(q7);
        System.out.println("----------");

        System.out.println("Get the details of youngest male employee in the product development department?");
        Employee q8 = employeeList.stream()
                .filter(employee -> employee.getGender().equals("Male") &&
                        employee.getDepartment().equals("Product Development"))
                .min(Comparator.comparing(Employee::getAge)).get();
        System.out.println(q8);
        System.out.println("----------");

        System.out.println("Who has the most working experience in the organization?");
        Employee q9 = employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining)).get();
        System.out.println(q9);
        System.out.println("----------");

        System.out.println("What is the average salary of male and female employees?");
        Map<String, Double> q10 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(q10);
        System.out.println("----------");

        System.out.println("How many male and female employees are there in the sales and marketing team?");
        Map<String, Long> q11 = employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(q11);
        System.out.println("----------");

        System.out.println("Who is the oldest employee in the organization? What is his age " +
                "and which department he belongs to?");
        Employee q12 = employeeList.stream()
                .max(Comparator.comparing(Employee::getAge))
                .get();
        System.out.println(q12);
        System.out.println("----------");

        System.out.println("What is the average salary and total salary of the whole organization?");
        DoubleSummaryStatistics q13 = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println("Average salary: " + q13.getAverage());
        System.out.println("Total salary: " + q13.getSum());
        System.out.println("----------");

        System.out.println("List down the names of all employees in each department?");
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((key, value) -> {
                    System.out.print(key + " - ");
                    value.stream()
                            .map(Employee::getName)
                            .forEach(name -> System.out.print(name + " | "));
                    System.out.println();
                });
        System.out.println("----------");

        System.out.println("Separate the employees who are younger or equal to 25 years from " +
                "those employees who are older than 25 years.");
        employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge() <= 25))
                .forEach((key, value) -> {
                    if (key)
                        System.out.println("Employees younger or equal to 25 - ");
                    else
                        System.out.println("Employees older than 25");
                    value.stream()
                            .sorted(Comparator.comparing(Employee::getAge))
                            .forEach(System.out::println);
                });

    }
}


