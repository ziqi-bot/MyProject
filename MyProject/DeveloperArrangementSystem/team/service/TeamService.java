package MyProject.DeveloperArrangementSystem.team.service;

import MyProject.DeveloperArrangementSystem.team.domain.Employee;
import MyProject.DeveloperArrangementSystem.team.domain.Programmer;

public class TeamService {
    private int counter = 1; //static variable, generate unique memberID for new team member
    private final int MAX_MEMBER = 5; //maximum number of development member
    private int total = 0; // record actual number of member
    private Programmer[] team = new Programmer[MAX_MEMBER];


    // return all the member of this development team, including array
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];

        }
        return team;
    }

    /*
     * add members exception:
     *
     * */
    public void addMember(Employee e) throws TeamException {
//                * Full team, cannot add new member!

//                * This employee is not a developer, cannot be added!
//                * This employee is working in other team, cannot be added!
//                * This employee is on vacation, cannot be added!
//                * This employee is working in the team!
//                * This team cannot have more than one Architect!
//                * This team cannot have more than two Designers!
//                * This team cannot have more than three Programmers!
    }

    /*
     * remove member
     * */
    public void removeMember(int memberId) throws TeamException {

    }


    public TeamService() {
    }

    public TeamService(int counter, int total, Programmer[] team) {
        this.counter = counter;
        this.total = total;
        this.team = team;
    }
}
