package MyProject.DeveloperVehicle;

public class Developer {

    private String name;
    private int age;

    public Developer() {
    }

    public Developer(String name, int age ) {
        this.age=age;
        this.name = name;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void takingVehicle( Vehicle vehicle){
        vehicle.run();
    }


}
