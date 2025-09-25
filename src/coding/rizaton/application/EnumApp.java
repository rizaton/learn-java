package coding.rizaton.application;

import coding.rizaton.data.Customer;
import coding.rizaton.data.Level;

public class EnumApp {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Iza");
        customer.setLevel(Level.PREMIUM);

        System.out.println(customer.getName());
        System.out.println(customer.getLevel());
        System.out.println(customer.getLevel().getDescription());

        String levelName = Level.VIP.name();
        System.out.println(levelName);

        Level level = Level.valueOf("PREMIUM");
        System.out.println(level);

        Level[] levels = Level.values();

        System.out.println("Print Levels");
        for (Level level1 : levels) {
            System.out.println(level1);
        }
    }
}
