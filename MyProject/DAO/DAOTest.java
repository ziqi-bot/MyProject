package MyProject.DAO;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1() {
        CustomerDAO dao1 = new CustomerDAO();
        dao1.insert(new Customer());
        Customer customer = dao1.queryForInstance(1);


    }

    @Test
    public void test2() {
        OrderDAO dao1 = new OrderDAO();
        dao1.insert(new Order());
        List<Order> orders = dao1.queryForList(1);

    }

}
