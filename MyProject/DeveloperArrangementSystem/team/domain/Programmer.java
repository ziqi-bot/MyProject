package MyProject.DeveloperArrangementSystem.team.domain;

import MyProject.DeveloperArrangementSystem.team.service.Status;
import jdk.jshell.Snippet;

public class Programmer extends Employee {
    private int memberId;
    private Status status=Status.FREE;
    private Equipment equipment;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Programmer() {
    }



    @Override
    public String toString() {
        return getDetails()+"\tProgrammer\t"+status+"\t\t\t\t\t"+equipment.getDescription();
    }
}
