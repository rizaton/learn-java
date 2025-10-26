package rizaton.i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {

    @Test
    void testCurrencyIndonesia() {
        @SuppressWarnings("deprecation")
        var indonesia = new Locale("in", "ID");
        var currency = Currency.getInstance(indonesia);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(indonesia));
    }

    @Test
    void testCurrencyUSA() {
        @SuppressWarnings("deprecation")
        var america = new Locale("en", "US");
        var currency = Currency.getInstance(america);

        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(america));
    }

    @Test
    void testNumberFormatCurrencyIndonesia() {
        @SuppressWarnings("deprecation")
        var indonesia = new Locale("in", "ID");
        var numberFormat = NumberFormat.getCurrencyInstance(indonesia);

        var format = numberFormat.format(1000000);
        System.out.println(format);
    }

    @Test
    void testNumberFormatCurrencyParseIndonesia() {
        @SuppressWarnings("deprecation")
        var indonesia = new Locale("in", "ID");
        var numberFormat = NumberFormat.getCurrencyInstance(indonesia);

        try {
            var result = numberFormat.parse("Rp1.000.000,00").doubleValue();
            System.out.println(result);
        } catch (ParseException e) {
            System.out.println("Error Parsing Format: " + e.getMessage() );
        }
    }
}
