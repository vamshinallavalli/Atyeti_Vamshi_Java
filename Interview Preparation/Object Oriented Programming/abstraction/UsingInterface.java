package abstraction;

interface UsingInterface {
    void hello();
}

class Students implements UsingInterface{
    public static void main(String[] args) {
        Students s = new Students();
        s.hello();
    }

    @Override
    public void hello() {
        System.out.println("Hello.....");
    }
}
