package rizaton.generic.application;

import rizaton.generic.MyData;

public class InvariantApp {
    public static void main(String[] args) {

        MyData<String> myData = new MyData<>("Hello");
//        doIt(myData); // Error
//        MyData<Object>  myData2 = myData; // Error

        MyData<Object> myData2 = new MyData<>(1000);
//        MyData<Integer> myData3 = myData2; // Error
//        doItInteger(myData2); // Error

    }
    public static void doIt(MyData<Object> myData) {
        // do nothing
    }
    public static void doItInteger(MyData<Integer> myData) {
        // do nothing
    }
}
