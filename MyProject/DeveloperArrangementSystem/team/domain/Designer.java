package MyProject.DeveloperArrangementSystem.team.domain;

import MyProject.DeveloperArrangementSystem.team.service.Status;



public class Designer extends Programmer {
    private double bonus;
    private Status status = Status.FREE;

    public double getBonus() {
        return bonus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\tDesigner\t" + getStatus() + "\t" + getBonus() + "\t\t\t"
                + getEquipment().getDescription();
    }
}
