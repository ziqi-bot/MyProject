package MyProject.DeveloperVehicle.developer_vehicle;

public abstract class Vehicle {
    private String brand;
    private String colour;

    public Vehicle() {
    }

    public Vehicle(String brand, String colour) {
        this.brand = brand;
        this.colour = colour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public abstract void run();
}
