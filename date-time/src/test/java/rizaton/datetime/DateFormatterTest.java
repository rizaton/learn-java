package rizaton.datetime;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatterTest {

    @Test
    void parse() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2018 10 10", formatter);
        System.out.println(localDate);
    }

    @Test
    void format() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2018 10 10", formatter);
        String format = localDate.format(formatter);
        System.out.println(format);
    }

    @Test
    void defaultFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");

        LocalDate localDate = LocalDate.parse("2018 10 10", formatter);
        String format = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(format);
    }

    @Test
    void internationalization() {
        @SuppressWarnings("deprecation")
        Locale locale = new Locale("in", "ID");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd", locale);

        LocalDate localDate = LocalDate.of(2025, 1, 1);
        String format = localDate.format(formatter);

        System.out.println(format);
    }
}
