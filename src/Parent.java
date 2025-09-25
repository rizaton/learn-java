class Parent {
    String name;
    void test() {
        System.out.println("Test in Parent");
    }
}

class Child extends Parent {
    String name;
    void test() {
        System.out.println("Test in Child");
        System.out.println("Parent name is " + super.name);
    }
}