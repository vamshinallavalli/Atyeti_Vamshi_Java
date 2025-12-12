package encapsulation;

public class UsingEncapsulation {
    public static void main(String[] args) {
        Employee employee1=new Employee(1209,"Vijay","Developer");
        Employee employee2=new Employee(1210,"Kumar","Devops");

        Employee employees[]={employee1,employee2};

        for (Employee emp : employees) {
            System.out.println(emp.getEmployeeId() + " " + emp.getName() + " " + emp.getDesignation());
        }
    }
}

 class Employee{
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

     public Employee(long employeeId, String name, String designation) {
         this.employeeId = employeeId;
         this.name = name;
         this.designation = designation;
     }
 }
