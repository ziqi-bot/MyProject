package MyProject.DAO;

/*

DAO: database access object, with CRUD operations

CRUD:
create
read
update
delete

 */

import java.util.List;

public class DAO<T> {
    //create
    public void insert(T bean) {

    }//write bean into database using sql

    //delete
    public T deleteById(int id) {
        return null;
    }


    //update
    public void update(int id, T bean) {

    }


    //read
    public T queryForInstance(int id) {  //query one instance


        return null;
    }

    public List<T> queryForList(int id) {  //query all the instances and put them into List
        return null;
    }



    public <E> E getValue(String sql) {   //E:Long or Date, can be defined in different need.
        return null;
    }


}
