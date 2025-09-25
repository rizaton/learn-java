public class PersonApp {
    public static void main(String[] args) {
        var person = new Person("Iza", 18);

        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.country);
        person.sayHello("Tony");

        Person person1 = new Person("Tony", 22);
        Person person3;
        person3 = new Person();
        person3.name = person1.name;
        person3.sayHello("Juno");
    }
}