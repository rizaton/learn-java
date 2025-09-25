package rizaton.classes;

import java.util.Arrays;
import java.util.Base64;

public class Base64App {
    public static void main(String[] args) {
        String value = "This() is() a Test()";

        String encode = Base64.getEncoder().encodeToString(value.getBytes());
        System.out.println(Arrays.toString(value.getBytes()));
        System.out.println(encode);

        byte[] decoded = Base64.getDecoder().decode(encode);
        String decode = new String(decoded);
        System.out.println(decode);
    }
}
