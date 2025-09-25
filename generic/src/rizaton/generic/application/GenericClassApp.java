package rizaton.generic.application;

import rizaton.generic.MyData;

public class GenericClassApp {
    public static void main(String[] args) {

        MyData<String> stringMyData = new MyData<String>("Hello");
        MyData<Integer> integerMyData = new MyData<Integer>(123);

        String stringValue = stringMyData.toString();
        Integer integerValue = integerMyData.getData();

        System.out.println(stringValue);
        System.out.println(integerValue);

    }
}
