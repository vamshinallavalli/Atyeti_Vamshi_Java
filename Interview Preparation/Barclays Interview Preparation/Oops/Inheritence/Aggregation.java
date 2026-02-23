public class Aggregation {
    public static void main(String[] args) {

        Address addr = new Address("Hyderabad"); // Created outside

        Employee emp = new Employee(addr);       // Injected

        System.out.println(emp.address.city);
    }
}

// Address can exist without Employee.

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Employee {
    Address address;  // Injected

    Employee(Address address) {
        this.address = address;
    }
}
