package rizaton.lambda.app;

import java.util.function.Supplier;

public class LazyApp {
    public static void main(String[] args) {
        testScore(70, LazyApp::getName);
    }

//    public static void testScore(int score, String name){
//        if (score > 80) {
//            System.out.println("Congratulations " + name + " You've passed!");
//        } else {
//            System.out.println("Try again next time");
//        }
//    }
    public static void testScore(int score, Supplier<String> name) {
        if (score > 80) {
            System.out.println("Congratulations " + name.get() + " You've passed!");
        } else {
            System.out.println("Try again next time");
        }
    }

    public static String getName(){
        System.out.println("Method getName() called");
        return "Iza";
    }
}
