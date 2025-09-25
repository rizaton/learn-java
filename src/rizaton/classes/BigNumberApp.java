package rizaton.classes;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberApp {
    public static void main(String[] args) {

//        Long valueLong = 1000000000000000000000;

        BigInteger value1 = new BigInteger("1000000000000000000000");
        BigInteger value2 = new BigInteger("1000000000000000000000");

        BigInteger value3 = value1.add(value2);

        System.out.println(value3);
    }
}
