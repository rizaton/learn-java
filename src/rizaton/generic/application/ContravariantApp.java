package rizaton.generic.application;

import rizaton.generic.MyData;

public class ContravariantApp {
    // Parent Class -> Child Class
    // Can Read, but when Overwrite data needs to be careful
    public static void main(String[] args) {

        MyData<Object> data = new MyData<>("Hello");
        data.setData(1000);
        MyData<? super String> data2 = data;

        System.out.println(data.getData());
        process(data);
        System.out.println(data.getData());

    }
    public static void process(MyData<? super String> data) {
        Object value = data.getData();
        System.out.println("Processing data: " + value);

        data.setData("Test");
    }
}
