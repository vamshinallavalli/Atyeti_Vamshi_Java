class DeepCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {

        Human original = new Human("Vamshi", new City("Jubilee Hills"));

        // Deep copy using clone
        Human deepCopy = original.clone();

        deepCopy.getAddress().setStreet("Mumbai");
        deepCopy.setName("Balayya");

        System.out.println("Original: " + original);
        System.out.println("Deep Copy: " + deepCopy);
    }
}

class Human implements Cloneable {

    private String name;
    private City address;

    public Human(String name, City address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public City getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(City address) {
        this.address = address;
    }

    @Override
    public Human clone() throws CloneNotSupportedException {
        Human cloned = (Human) super.clone();

        // Deep copy of mutable object
        cloned.address = address.clone();

        return cloned;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class City implements Cloneable {

    private String street;

    public City(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public City clone() {
        try {
            return (City) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "street='" + street + '\'' +
                '}';
    }
}