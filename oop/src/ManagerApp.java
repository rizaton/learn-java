public class ManagerApp {
    public static void main(String[] args) {
        var manager = new Manager("Iza");
        manager.sayHello("Tony");

        var vicePresident = new VicePresident("John");
        vicePresident.sayHello("Jane");

        System.out.println(manager);
        System.out.println(vicePresident);
    }
}
