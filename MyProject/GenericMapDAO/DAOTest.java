package MyProject.GenericMapDAO;

import java.util.List;

public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001", new User(1, 23, "Tom"));
        dao.save("1002", new User(2, 22, "Jerry"));



        dao.update("1001", new User(3, 24, "Harry"));
        List<User> list1 = dao.list();
        for (User u : list1) {
            System.out.println(u);
        }
    }
}
