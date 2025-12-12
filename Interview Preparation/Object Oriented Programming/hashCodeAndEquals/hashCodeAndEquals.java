package hashCodeAndEquals;

import java.util.Objects;

public class hashCodeAndEquals {
    public static void main(String[] args) {
//        Employees employee1=new Employees(1209,"Vijay","Developer");
//        Employees employee2=new Employees(1210,"Kumar","Devops");

        Employees employee1=new Employees(1209,"Vijay","Developer");
        Employees employee2=new Employees(1209,"Vijay","Developer");


        System.out.println(employee1.equals(employee2));
    }
}

class Employees{
    private long employeeId;
    private String name;
    private String designation;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Employees(long employeeId, String name, String designation) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return employeeId == employees.employeeId && Objects.equals(name, employees.name) && Objects.equals(designation, employees.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, name, designation);
    }


//    public boolean equals(Object obj) {
//        return (this == obj);  // == on objects means "same memory address?"
//    }
}
