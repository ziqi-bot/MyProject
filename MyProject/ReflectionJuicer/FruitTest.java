package ReflectionJuicer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;


public class FruitTest {

    @Test
    public void test1() throws Exception {
        // read config info
        Properties properties = new Properties();
        File file = new File("src\\config.properties");
        FileInputStream fileInputStream = new FileInputStream(file);

        properties.load(fileInputStream);

        String fruitName = properties.getProperty("fruitName");

        //create instance via reflection


        Class clazz = Class.forName(fruitName);

        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Fruit fruit = (Fruit) constructor.newInstance();

        //invoke run() via juicer instance
        Juicer juicer=new Juicer();
        juicer.run(fruit);


    }
}
