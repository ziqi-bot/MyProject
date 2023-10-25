package MyProject.DeveloperVehicle;

public class Bicycle extends Vehicle implements IPower {

    public Bicycle() {
    }

    public Bicycle(String brand, String colour) {
        super(brand, colour);
    }

    @Override
    public void run() {
        System.out.println("Bicycle run");
    }

    public void power() {  //subclass can override interface methods
        System.out.println("powered by human");
    }
}
