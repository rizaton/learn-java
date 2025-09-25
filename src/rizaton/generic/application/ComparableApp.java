package rizaton.generic.application;

import rizaton.generic.Person;

import java.util.Arrays;

public class ComparableApp {
    public static void main(String[] args) {

        Person[] people = {
                new Person("Iza", "Japan"),
                new Person("Riza", "Indonesia"),
                new Person("John", "America"),
        };

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));

    }
}
