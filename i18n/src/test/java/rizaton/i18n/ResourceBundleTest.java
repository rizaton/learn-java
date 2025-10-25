package rizaton.i18n;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    @Test
    void testResourceBundle() {

        var rb = ResourceBundle.getBundle("message");
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("goodbye"));
    }

    @Test
    void testResourceBundleLocale() {
        @SuppressWarnings("deprecation")
        Locale indonesia = new Locale("in", "ID");
        ResourceBundle rb = ResourceBundle.getBundle("message", indonesia);

        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("goodbye"));
    }

    @Test
    void testResourceBundleNotFound() {
        @SuppressWarnings("deprecation")
        Locale japan = new Locale("ja", "JP");
        ResourceBundle rb = ResourceBundle.getBundle("message", japan);

        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("goodbye"));
    }

    @Test
    void testResourceBundleMultipleTimes() {
        @SuppressWarnings("deprecation")
        Locale japan = new Locale("ja", "JP");
        ResourceBundle rb = ResourceBundle.getBundle("message", japan);
        ResourceBundle rb2 = ResourceBundle.getBundle("message", japan);

        System.out.println(rb == rb2);
    }
}
