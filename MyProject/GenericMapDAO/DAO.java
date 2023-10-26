package MyProject.GenericMapDAO;

import java.util.*;

public class DAO<T> {
//    Map<String, T> map;// null pointer, only claim
//    Map<String, T> map=new HashMap<>();// null pointer, only claim
   Map<String, T> map;// non-static code block
    {
        map=new HashMap<>();
    }


    // create
    public void save(String id, T entity) {

        if (!map.containsKey(id)) {
            map.put(id, entity);
        }

    }

    //read
    public T get(String id) {
        return map.get(id);
    }

    //update
    public void update(String id, T entity) {

        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    //read
    public List<T> list() {   //return all the T objects (values) in the map
        Collection<T> values = map.values();
//        return (List<T>)values;  //class cast exception
        ArrayList<T> list = new ArrayList<>(values);
        return list;

    }

    //delete
    public void delete(String id) {
        if (map.containsKey(id)) {
            map.remove(id);
        }
    }


}
