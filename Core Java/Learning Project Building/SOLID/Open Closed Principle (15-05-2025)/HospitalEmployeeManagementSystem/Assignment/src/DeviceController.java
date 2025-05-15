public class DeviceController {
    private RemoteControl remoteControl;

    public DeviceController(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    public void execute() {
        remoteControl.turningOn();
        remoteControl.turningOff();
    }
}

