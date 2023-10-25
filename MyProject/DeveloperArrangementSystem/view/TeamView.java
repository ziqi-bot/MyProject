package MyProject.DeveloperArrangementSystem.view;

import MyProject.DeveloperArrangementSystem.domain.Employee;
import MyProject.DeveloperArrangementSystem.service.NameListService;
import MyProject.DeveloperArrangementSystem.service.TeamException;
import MyProject.DeveloperArrangementSystem.service.TeamService;
import MyProject.DeveloperArrangementSystem.domain.Programmer;


public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    /**
     * main menu
     */
    public void enterMainMenu() {

        boolean isFlag = true;
        char menu = 0;
        do {
            if (menu != '1') {
                listAllEmployees();

            }

            System.out.print("1-Member list  2-Add team member  3-Remove team member 4-Exit   Please select (1-4): ");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("Exit confirm ? (Y/N): ");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;
            }

        } while (isFlag);

    }

    /**
     * list all the members
     */
    private void listAllEmployees() {
        System.out.println("-------------------------------Developers Arrangement System--------------------------------\n");

        Employee[] employees = listSvc.getAllEmployees();
        if (employees.length == 0) {
            System.out.println("Employee list is empty!");
            System.out.println("--------------------------------------------------------------");
        } else {
            System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tEquipment");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
            System.out.println("--------------------------------------------------------------");

        }
    }

    /**
     * Team members
     */
    private void getTeam() {
        System.out.println("--------------------List of Team members---------------------");


        Programmer[] team = teamSvc.getTeam();
        if (team.length == 0) {
            System.out.println("No member is in the team!");

        } else {
            System.out.println("TID/ID\tName\tage\tsalary\tposition\tbonus\tstock");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());

            }
        }
        System.out.println("-----------------------------------------------------");
    }

    /**
     * add member
     */
    private void addMember() {
        System.out.println("---------------------Add Member---------------------");
        System.out.print("Please input member ID: ");
        int id = TSUtility.readInt();
        try {
            Employee emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("Add Successfully!");
        } catch (TeamException e) {
            System.out.println("Add failed:" + e.getMessage());

        }
        //enter...
        TSUtility.readReturn();
    }

    /**
     * remove member
     */
    private void deleteMember() {
        System.out.println("---------------------Remove Member---------------------");

        System.out.print("Please input member TID:");
        int memberId = TSUtility.readInt();
        System.out.print("Remove confirm? (Y/N):");
        char delOrNot = TSUtility.readConfirmSelection();
        if (delOrNot == 'Y') {
            try {
                teamSvc.removeMember(memberId);
                System.out.println("Remove Successfully! ");

            } catch (TeamException e) {
                System.out.println("Delete failed: " + e.getMessage());
            }
            //enter...
            TSUtility.readReturn();
        }

    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

}
