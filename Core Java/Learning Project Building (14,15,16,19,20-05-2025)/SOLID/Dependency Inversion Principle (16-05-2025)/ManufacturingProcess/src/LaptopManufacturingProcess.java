public class LaptopManufacturingProcess implements GeneraManufacturingProcess{
    @Override
    public void launchProcess() {
        System.out.println("Launching Laptop...");
    }

    @Override
    public void assembleDevice() {
        System.out.println("Assembling Laptop...");
    }

    @Override
    public void testDevice() {
        System.out.println("Testing Laptop...");
    }

    @Override
    public void packageDevice() {
        System.out.println("Packing Laptop...");
    }

    @Override
    public void storeDevice() {
        System.out.println("Laptop is Storing...");
    }
}
