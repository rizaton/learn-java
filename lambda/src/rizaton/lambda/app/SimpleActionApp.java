package rizaton.lambda.app;

import rizaton.lambda.SimpleAction;

public class SimpleActionApp {
    public static void main(String[] args) {

        SimpleAction simpleaction = new SimpleAction() {
            @Override
            public String action() {
                return "Iza";
            }
        };
        System.out.println(simpleaction.action());

        SimpleAction simpleaction1 = () -> {
            return "Hello";
        };
        System.out.println(simpleaction1.action());

    }
}
