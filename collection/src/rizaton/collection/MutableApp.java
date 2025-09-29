package rizaton.collection;

import rizaton.collection.Data.Person;

import java.util.List;

public class MutableApp {
    public static void main(String[] args) {

        Person person = new Person("Iza");

        person.addHobby("Game");
        person.addHobby("Code");

        doSomething(person.getHobbies());

        System.out.println(person.getHobbies());

    }

    public static void doSomething(List<String> hobbies) {
//        hobbies.add("Test");
    }

}
