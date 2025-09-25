package rizaton.generic.application;

import rizaton.generic.MyData;

public class WildcardApp {
    public static void main(String[] args) {
        print(new MyData<>("HelloWorld"));
        print(new MyData<>(123));
        print(new MyData<MultipleConstraintApp.Manager>(new MultipleConstraintApp.Manager()));

    }
    public static void print(MyData<?> myData){
        System.out.println(myData.getData());
    }
}
