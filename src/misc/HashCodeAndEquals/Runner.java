package misc.HashCodeAndEquals;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getName().equals(employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Runner {
    public static void main(String[] args) {
//        If two objects content is same, then its hashcode must also be the same. Hence we need to
//        override hashcode too when we override equals
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee(101, "Anil"));
        employees.add(new Employee(101, "Anil"));
        employees.add(new Employee(104, "Anup"));
        System.out.println(employees);
    }
}
