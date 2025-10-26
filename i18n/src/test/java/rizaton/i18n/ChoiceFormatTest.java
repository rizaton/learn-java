package rizaton.i18n;

import org.junit.jupiter.api.Test;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChoiceFormatTest {

    @Test
    void testChoiceFormat() {
        String pattern = "-1#negatif | 0#kosong | 1#satu | 1<banyak";

        var choiceFormat = new ChoiceFormat(pattern);

        System.out.println(choiceFormat.format(-2));
        System.out.println(choiceFormat.format(-1));
        System.out.println(choiceFormat.format(0));
        System.out.println(choiceFormat.format(1));
        System.out.println(choiceFormat.format(2));
        System.out.println(choiceFormat.format(3));
    }

    @Test
    void testChoiceFormatInMessageFormat() {
        @SuppressWarnings("deprecation")
        var locale = new Locale("in", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("balance");

        var messageFormat = new MessageFormat(pattern, locale);;
        System.out.println(messageFormat.format(new Object[]{-1000000}));
        System.out.println(messageFormat.format(new Object[]{0}));
        System.out.println(messageFormat.format(new Object[]{1000000}));
    }

    @Test
    void testChoiceFormatInMessageFormatUSA() {
        @SuppressWarnings("deprecation")
        var locale = new Locale("en", "US");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("balance");

        var messageFormat = new MessageFormat(pattern, locale);;
        System.out.println(messageFormat.format(new Object[]{-1000000}));
        System.out.println(messageFormat.format(new Object[]{0}));
        System.out.println(messageFormat.format(new Object[]{1000000}));
    }
}
