package rizaton.generic.application;

import rizaton.generic.MyData;

public class CovariantApp {
    // Child Class -> Parent Class
    // Can Read, but cannot write
    public static void main(String[] args) {

        MyData<String> data = new MyData<>("Hello");
        process(data);

        MyData<? extends Object> data2 = data;

    }
    public static void process(MyData<? extends Object> data) {
        System.out.println(data.getData());
//        data.setData("Hello"); // Cannot
    }
}
