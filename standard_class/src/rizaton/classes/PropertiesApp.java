package rizaton.classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp {
    public static void main(String[] args) {

        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("application.properties"));

            System.out.println( prop.getProperty("name.first") );
            System.out.println( prop.getProperty("name.last") );
            System.out.println( prop.getProperty("database.host") );
            System.out.println( prop.getProperty("database.port") );
            System.out.println( prop.getProperty("database.password") );

            prop.put("hobby", "code");
            prop.store(new FileOutputStream("application.properties"), null);

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
