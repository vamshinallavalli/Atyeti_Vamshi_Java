package ImmutableClassAndMutableFields;

import java.time.LocalDate;
import java.util.Date;

public final class Employee {
    private final String id;
    private  final String name;
    private final Date joiningDate;
    private final double salary;


    public Employee(String id, String name, Date joiningDate, double salary) {
        this.id = id;
        this.name = name;
        this.joiningDate = new Date(joiningDate.getTime());
        this.salary = new Double(salary);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getJoiningDate() {
        return new Date(joiningDate.getTime());
    }

    public double getSalary() {
        return new Double(salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                '}';
    }
}
