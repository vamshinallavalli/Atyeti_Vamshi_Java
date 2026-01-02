import java.util.Objects;

public class EqualsAndHashCode {
    public static void main(String[] args) {
        Reference obj1=new Reference(1,"vamshi");
        Reference obj2=new Reference(1,"vamshi");

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode()==obj2.hashCode());
    }
}

class Reference{
    int id;
    String name;

    public Reference(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reference reference = (Reference) o;
        return id == reference.id && Objects.equals(name, reference.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
