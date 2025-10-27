package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTest {

    @Test
    void testCreate() {
        var date1 = new Date();
        var date2 = new Date(System.currentTimeMillis());
        var date3 = new Date(date1.getTime());

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);

    }
}
