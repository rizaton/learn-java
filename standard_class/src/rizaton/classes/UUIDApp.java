package rizaton.classes;

import java.util.UUID;

public class UUIDApp {
    public static void main(String[] args) {

        for (var i = 0; i < 100; i++) {
            UUID uuid = UUID.randomUUID();
            String key =  uuid.toString().replace("-", "");
            System.out.println(key);
        }
    }
}
