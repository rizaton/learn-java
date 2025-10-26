package rizaton.i18n;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTest {

    @Test
    void testMessageFormat() {
        var pattern = "Hi {0}, Anda bisa mencari data anda dengan mengetikkan \"{0}\" di pencarian.";
        var messageFormat = new MessageFormat(pattern);

        var format = messageFormat.format(new Object[]{
                "Iza"
        });

        System.out.println(format);
    }

    @Test
    void testMessageFormatResourceBundle() {
        @SuppressWarnings("deprecation")
        var locale = new Locale("in","ID");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("welcome.message");

        var messageFormat = new MessageFormat(pattern);
        var format = messageFormat.format(new Object[]{
                "Iza", "IntelliJ IDEA Ultimate"
        });
        System.out.println(format);
    }

    @Test
    void testMessageFormatResourceBundleUSA() {
        @SuppressWarnings("deprecation")
        var locale = new Locale("en","US");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("welcome.message");

        var messageFormat = new MessageFormat(pattern);
        var format = messageFormat.format(new Object[]{
                "Iza", "IntelliJ IDEA Ultimate"
        });
        System.out.println(format);
    }
}
