package rizaton.i18n;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

    @Test
    void testDateFormat() {
        var pattern = "EEEE dd MMMM yyyy";
        var dateFormat = new SimpleDateFormat(pattern);

        var format = dateFormat.format(new Date());
        System.out.println(format);
    }

    @Test
    void testDateFormatLocale() {
        var pattern = "EEEE dd MMMM yyyy";
        @SuppressWarnings("deprecation")
        Locale indonesia = new Locale("in", "ID");
        var dateFormat = new SimpleDateFormat(pattern, indonesia);

        var format = dateFormat.format(new Date());
        System.out.println(format);
    }

    @Test
    void testDateFormatLocaleJP() {
        var pattern = "EEEE dd MMMM yyyy";
        @SuppressWarnings("deprecation")
        Locale japan = new Locale("ja", "JP");
        var dateFormat = new SimpleDateFormat(pattern, japan);

        var format = dateFormat.format(new Date());
        System.out.println(format);
    }

    @Test
    void testDateFormatParseIndonesia() {
        var pattern = "EEEE dd MMMM yyyy";
        @SuppressWarnings("deprecation")
        Locale japan = new Locale("in", "ID");
        var dateFormat = new SimpleDateFormat(pattern, japan);

        try {
            Date date = dateFormat.parse("Sabtu 25 Oktober 2025");
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("Error parsing : " +  e.getMessage());
        }
    }


    @Test
    void testDateFormatParseJapan() {
        var pattern = "EEEE dd MMMM yyyy";
        @SuppressWarnings("deprecation")
        Locale japan = new Locale("ja", "JP");
        var dateFormat = new SimpleDateFormat(pattern, japan);

        try {
            Date date = dateFormat.parse("土曜日 25 10月 2025");
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("Error parsing : " +  e.getMessage());
        }
    }
}
