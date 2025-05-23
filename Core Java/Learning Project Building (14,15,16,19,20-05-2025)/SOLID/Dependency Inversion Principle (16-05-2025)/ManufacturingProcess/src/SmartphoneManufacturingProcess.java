public class SmartphoneManufacturingProcess implements GeneraManufacturingProcess{
    @Override
    public void launchProcess() {
        System.out.println("Launching Phone...");
    }

    @Override
    public void assembleDevice() {
        System.out.println("Assembling Phone...");
    }

    @Override
    public void testDevice() {
        System.out.println("Testing Phone...");
    }

    @Override
    public void packageDevice() {
        System.out.println("Packing Phone...");
    }

    @Override
    public void storeDevice() {
        System.out.println("Phone is Storing...");
    }
}
