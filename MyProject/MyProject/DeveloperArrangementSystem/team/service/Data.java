package MyProject.DeveloperArrangementSystem.team.service;


public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
            {"10", "1", "Alen", "22", "3000"},
            {"13", "2", "Bill", "32", "18000", "15000", "2000"},
            {"11", "3", "Carol", "23", "7000"},
            {"11", "4", "David", "24", "7300"},
            {"12", "5", "Edward", "28", "10000", "5000"},
            {"11", "6", "Frank", "22", "6800"},
            {"12", "7", "Gabriel", "29", "10800", "5200"},
            {"13", "8", "Harry", "30", "19800", "15000", "2500"},
            {"12", "9", "Idris", "26", "9800", "5500"},
            {"11", "10", "Jack", "21", "6600"},
            {"11", "11", "Kevin", "25", "7100"},
            {"12", "12", "Luke", "27", "9600", "4800"}
    };


    //PC      :21, model, display
    //NoteBook:22, model, price
    //Printer :23, name, type 
    public static final String[][] EQUIPMENTS = {
            {},
            {"22", "LENOVO T4", "6000"},
            {"21", "DELL", "NEC17"},
            {"21", "DELL", "SAMSUNG 17"},
            {"23", "CANNON 2900", "LASER"},
            {"21", "ASHA", "SAMSUNG 17"},
            {"21", "ASHA", "SAMSUNG 17"},
            {"23", "EPSON 20K", "DOT"},
            {"22", "HPm6", "5800"},
            {"21", "DELL", "NEC 17"},
            {"21", "ASHA", "SAMSUNG 17"},
            {"22", "HPm6", "5800"}
    };
}
