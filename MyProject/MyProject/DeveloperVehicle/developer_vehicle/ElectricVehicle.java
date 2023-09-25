package MyProject.DeveloperVehicle.developer_vehicle;

public class ElectricVehicle extends Vehicle implements IPower{

    @Override
    public void run() {
        System.out.println("ElectricVehicle run");
    }

    public ElectricVehicle() {
    }

    public ElectricVehicle(String brand, String colour) {
        super(brand, colour);
    }

    @Override
    public void power() {
        System.out.println("Powered by electricity ");
    }
}
