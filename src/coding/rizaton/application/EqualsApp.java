package coding.rizaton.application;

public class EqualsApp {
    public static void main(String[] args) {

        String first = "Iza";
        first = first + " " + "Riza";

        System.out.println(first);

        String second = "Iza Riza";
        System.out.println(second);

        System.out.println(first == second);
        System.out.println(first.equals(second));

        String third = "Iza Riza";

        System.out.println(second == third);
    }
}
