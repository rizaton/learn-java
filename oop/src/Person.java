class Person {
    String name;
    Integer age;
    final String country = "Indonesia";

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    Person(String name) {
        this(name, null);
    }

    Person() {
        this(null);
    }

    void sayHello(String name) {
        System.out.println("Hello " + name + " My Name is " + this.name);
    }
}
