package MyProject.DeveloperArrangementSystem.junit;

import MyProject.DeveloperArrangementSystem.domain.Employee;
import MyProject.DeveloperArrangementSystem.service.NameListService;
import MyProject.DeveloperArrangementSystem.service.TeamException;
import org.junit.Test;

public class NameListServiceTest {

    @Test
    public void testGetAllEmployees() {
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }
    }

    @Test
    public void testGetEmployee() {
        try {
            NameListService nameListService = new NameListService();
            int id = 0;
            Employee oneEmployee = nameListService.getEmployee(id);
            System.out.println(oneEmployee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();

        }

    }

}
