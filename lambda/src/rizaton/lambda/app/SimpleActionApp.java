package rizaton.lambda.app;

import rizaton.lambda.SimpleAction;

public class SimpleActionApp {
    public static void main(String[] args) {

//        SimpleAction simpleaction = new SimpleAction() {
//            @Override
//            public String action(String name) {
//                return "Iza";
//            }
//        };
//        System.out.println(simpleaction.action("Iza"));
//
//        SimpleAction simpleaction1 = (String name) -> {
//            return "Hello";
//        };
//        System.out.println(simpleaction1.action("Iza"));

        SimpleAction simpleAction = (String value) -> {
          return "Hello " + value;
        };
        SimpleAction simpleAction1 = (name) -> {
          return "Hello " + name;
        };

        SimpleAction simpleAction2 = (String name) -> "Hello " + name;
        SimpleAction simpleAction3 = (name) -> "Hello " + name;
        SimpleAction simpleAction4 = name -> "Hello " + name;

    }
}
