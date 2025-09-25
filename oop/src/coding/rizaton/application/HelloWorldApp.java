package coding.rizaton.application;

import coding.rizaton.data.HelloWorld;

public class HelloWorldApp {
    public static void main(String[] args) {

        HelloWorld english = new HelloWorld() {
            public void sayHello() {
                System.out.println("Hello World");
            }

            public void sayHello(String name) {
                System.out.println("Hello " + name);
            }
        };

        HelloWorld indonesia = new HelloWorld() {
            public void sayHello() {
                System.out.println("Halo Dunia");
            }

            public void sayHello(String name) {
                System.out.println("Halo " + name);
            }
        };

        english.sayHello();
        english.sayHello("Riza");

        indonesia.sayHello();
        indonesia.sayHello("Iza");

    }
}
