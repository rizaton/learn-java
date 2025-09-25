package rizaton.classes;

public class StringBuilderApp {
    public static void main(String[] args) {

//        String name = "Iza";
//
//        name = name + " " + "Riza";
//
//        name = name + " " + "Rizaton";
//
//        System.out.println(name);

        StringBuilder builder = new StringBuilder();
        builder.append("Iza");
        builder.append(" ");
        builder.append("Riza");

        String name = builder.toString();

        System.out.println(name);
    }
}
