package MyProject.DeveloperArrangementSystem.team.domain;

import MyProject.DeveloperArrangementSystem.team.service.Status;

public class Architect extends Designer {
    private int stock;
    private Status status = Status.FREE;

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public Architect() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return getDetails() + "\tArchitect\t" + getStatus() + "\t" + getBonus() + "\t" + getStock() + "\t"
                + getEquipment().getDescription();

    }

    public String getDetailsForTeam(){
        return getBasicDetailsForTeam()+"\t Architect\t"+getBonus()+"\t"+getStock();

    }
}
