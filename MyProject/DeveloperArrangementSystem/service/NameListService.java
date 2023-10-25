package MyProject.DeveloperArrangementSystem.service;

import MyProject.DeveloperArrangementSystem.domain.*;
import MyProject.DeveloperArrangementSystem.team.domain.*;

import static MyProject.DeveloperArrangementSystem.service.Data.*;

public class NameListService {
    private Employee[] employees;


    public NameListService() {

        employees = new Employee[Data.EMPLOYEES.length];


        for (int i = 0; i < employees.length; i++) {

            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            double bonus;
            Equipment equipment;
            if (Integer.parseInt(Data.EMPLOYEES[i][0]) == Data.EMPLOYEE) {
                employees[i] = new Employee(id, name, age, salary);

            } else if (Integer.parseInt(Data.EMPLOYEES[i][0]) == Data.PROGRAMMER) {
                equipment = createEquipment(i);


                employees[i] = new Programmer(id, name, age, salary, equipment);


            } else if (Integer.parseInt(Data.EMPLOYEES[i][0]) == Data.DESIGNER) {
                equipment = createEquipment(i);
                bonus = Double.parseDouble(EMPLOYEES[i][5]);
                employees[i] = new Designer(id, name, age, salary, equipment, bonus);

            } else {
                equipment = createEquipment(i);
                bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                int stock = Integer.parseInt(EMPLOYEES[i][6]);
                employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);

            }


        }

    }


    private Equipment createEquipment(int index) {
        int equipmentType = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        String modelOrName = Data.EQUIPMENTS[index][1];
        String priceOrDisplayOrType = Data.EQUIPMENTS[index][2];


        switch (equipmentType) {
            case PC:
                return new PC(modelOrName, priceOrDisplayOrType);

            case NOTEBOOK:
                double price = Double.parseDouble(priceOrDisplayOrType);
                return new NoteBook(modelOrName, price);

            case PRINTER:
                return new Printer(modelOrName, priceOrDisplayOrType);


        }
        return null;
    }

    public Employee[] getAllEmployees() {

        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (id == employees[i].getId()) {
                return employees[i];
            }

        }


        throw new TeamException("Cannot find this employee!");
    }

}
