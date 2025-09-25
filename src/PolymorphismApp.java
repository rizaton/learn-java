public class PolymorphismApp {
    public static void main(String[] args) {
        Employee employee = new Employee("Tony");
        employee.sayHello("Iza");

        employee = new Manager("Riza");
        employee.sayHello("Michael");

        employee = new VicePresident("John");
        employee.sayHello("Jane");

        sayHello(new Employee("Tony"));
        sayHello(new Manager("Riza"));
        sayHello(new VicePresident("John"));

    }
    static void sayHello(Employee employee) {
        if (employee instanceof VicePresident) {
            VicePresident vicePresident = (VicePresident) employee;
            System.out.println("Hello VP " + vicePresident.name);
        } else if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            System.out.println("Hello Manager " + manager.name);
        } else {
            System.out.println("Hello Employee " + employee.name);
        }
    }
}
