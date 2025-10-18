package util;

public class InputUtil {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static String input(String info){
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

}
