package rizaton.classes;

public class NumberApp {
    public static void main(String[] args) {

        Integer intValue = 10;

        Long longValue = intValue.longValue();
        Double doubleValue = longValue.doubleValue();
        Short shortValue = doubleValue.shortValue();

        String example = "10000.10";

        Double exampleInt = Double.valueOf(example);

        System.out.println(exampleInt);
    }
}
