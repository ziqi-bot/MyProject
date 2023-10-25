package MyProject.DeveloperVehicle;

public class VehicleTest {
    public static void main(String[] args) {

        Developer developer = new Developer();

        Vehicle[] vehicles = new Vehicle[3];//array type[] array name=new array type[numbers]
        vehicles[0] = new Bicycle("Giant", "Red");
        vehicles[1] = new ElectricVehicle("TESLA", "Black");
        vehicles[2] = new Car("Subaru", "Blue", "nfs-heat"); //ctrl+p, show hint parameter of method

        for (int i = 0; i < vehicles.length; i++) {

            developer.takingVehicle(vehicles[i]);
            if (vehicles[i] instanceof IPower) {   //instanceof can be used in the interface condition
                ((IPower) vehicles[i]).power();  //
            }

        }
    }
}

