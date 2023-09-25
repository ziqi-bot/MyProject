package MyProject.DeveloperArrangementSystem.team.service;

import MyProject.DeveloperArrangementSystem.team.domain.*;

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
        if (total >= MAX_MEMBER) {
            throw new TeamException("Full team, cannot add new member!");
        }
//                * This employee is not a programmer, cannot be added!
        else if (!(e instanceof Programmer) ){


            throw new TeamException("This employee is not a programmer, cannot be added!");
        }
//                * This employee is working in other team, cannot be added!
//                * This employee is on vacation, cannot be added!
        Programmer p = (Programmer) e;
        boolean isExist = isExist(p);
        if (isExist) {
            throw new TeamException("This employee is currently working in the team!");
        }
        Status status = p.getStatus();
        switch (status) {
            case BUSY:
                throw new TeamException("This employee is working in other team, cannot be added!");
            case VOCATION:
                throw new TeamException("This employee is on vacation, cannot be added!");
        }

//                * This employee is working in the team!

//                * This team cannot have more than one Architect!
//                * This team cannot have more than two Designers!
//                * This team cannot have more than three Programmers!
        int proNum = 0, desNum = 0, arcNum = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                arcNum++;
            } else if (team[i] instanceof Designer) {
                desNum++;
            } else {
                proNum++;
            }

        }
//        *** Architect is instance of Designer, also is instance of Programmer.

        if (p instanceof Architect) {
            if (arcNum >= 1) {
                throw new TeamException("This team cannot have more than one Architect!");
            }
        } else if (p instanceof Designer) {
            if (desNum >= 2) {
                throw new TeamException("This team cannot have more than two Designers!");
            }
        } else {
            if (proNum >= 3) {
                throw new TeamException("This team cannot have more than three Programmer!");
            }
        }
        //then, no more Exceptions!
        team[total++] = p;// operate ++ in the end
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
    }

    private boolean isExist(Programmer p) {

        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    /*
     * remove member
     * */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total + 1; i++) {
            if (team[i].getMemberId() == memberId) {   // found this employee
                team[i].setStatus(Status.FREE);


                break;
            }
        }
        if (i == total) {
            throw new TeamException("Cannot find this employee! Delete failed!");
        }
        // change array
        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];

        }

//        team[total-1]=null;
//        total--
        team[--total] = null;


    }


    public TeamService() {
    }

    public TeamService(int counter, int total, Programmer[] team) {
        this.counter = counter;
        this.total = total;
        this.team = team;
    }


}