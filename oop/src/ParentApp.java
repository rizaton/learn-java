class ParentApp {
    public static void main(String[] args) {
        Child child = new Child();
        child.name = "Iza";
        child.test();
        System.out.println(child.name);

        Parent parent = child;
        parent.test();
        System.out.println(parent.name);
    }
}
