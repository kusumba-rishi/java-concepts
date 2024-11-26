package misc.EqualsAndHashCode;

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

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && Objects.equals(getName(), employee.getName());
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
        Set<Employee> set = new HashSet<>();
        set.add(new Employee(101, "anil"));
        set.add(new Employee(101, "anil"));
        System.out.println(set);
    }
}
