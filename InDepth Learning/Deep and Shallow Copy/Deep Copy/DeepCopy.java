//public class DeepCopy {
//    public static void main(String[] args) {
//
//        // Original object
//        Men originalMen = new Men("Vamshi", new City("Hyderabad"));
//
//        // Shallow copy
//        Men shallowCopyMen = new Men(originalMen);
//
//        // Modifying shallow copy
//        shallowCopyMen.setName("Balraju");
//        shallowCopyMen.getCity().setCityName("Mumbai");
//
//        // Printing results
//        System.out.println("Original Men: " + originalMen);
//        System.out.println("Shallow Copy Men: " + shallowCopyMen);
//    }
//}
//
//class Men {
//
//    private String name;
//    private City city;
//
//    // Copy constructor (Shallow Copy)
//    public Men(Men other) {
//        this.name = other.name;
//        this.city = other.city; // same reference
//    }
//
//    // Normal constructor
//    public Men(String name, City city) {
//        this.name = name;
//        this.city = city;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
//
//    @Override
//    public String toString() {
//        return "Men{name='" + name + "', city=" + city + "}";
//    }
//}
//
//class City {
//
//    private String cityName;
//
//    public City(String cityName) {
//        this.cityName = cityName;
//    }
//
//    public String getCityName() {
//        return cityName;
//    }
//
//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
//
//    @Override
//    public String toString() {
//        return "City{cityName='" + cityName + "'}";
//    }
//}