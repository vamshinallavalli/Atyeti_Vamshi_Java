public class DeviceFactory {
    public static void main(String[] args) {
        GeneraManufacturingProcess generaManufacturingProcess=new LaptopManufacturingProcess();
        generaManufacturingProcess.packageDevice();
        generaManufacturingProcess.launchProcess();
        generaManufacturingProcess.assembleDevice();
        generaManufacturingProcess.storeDevice();
        generaManufacturingProcess.testDevice();

        GeneraManufacturingProcess generaManufacturingProcess1=new SmartphoneManufacturingProcess();
        generaManufacturingProcess1.packageDevice();
        generaManufacturingProcess1.launchProcess();
        generaManufacturingProcess1.assembleDevice();
        generaManufacturingProcess1.storeDevice();
        generaManufacturingProcess1.testDevice();
    }
}