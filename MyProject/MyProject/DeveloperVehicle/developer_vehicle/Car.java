package MyProject.DeveloperVehicle.developer_vehicle;

public class Car extends Vehicle implements IPower{
    private String carNumber;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public Car(String brand, String colour, String carNumber) {
        super(brand, colour);
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("Car run");

    }


    @Override
    public void power() {
        System.out.println("Powered by gas engine");
    }
}
