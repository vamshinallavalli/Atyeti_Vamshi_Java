import java.util.Arrays;
import java.util.List;

public class Person {
    public static void main(String[] args) {

        DeviceController tv=new DeviceController(new Tv());
        DeviceController projector=new DeviceController(new Projector());
        DeviceController soundSystem=new DeviceController(new SurroundSoundSystem());

        tv.execute();
        projector.execute();
        soundSystem.execute();
    }
}

