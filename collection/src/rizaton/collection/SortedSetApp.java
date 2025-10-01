package rizaton.collection;

import rizaton.collection.Data.Person;
import rizaton.collection.Data.PersonComparator;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetApp {
    public static void main(String[] args) {

        SortedSet<Person> people = new TreeSet<>(new PersonComparator());
//        SortedSet<Person> people = new TreeSet<>(new PersonComparator().reversed());

        people.add(new Person("John"));
        people.add(new Person("Jane"));
        people.add(new Person("Julie"));

        for (Person person : people) {
            System.out.println(person.getName());
        }

        SortedSet<Person> sortedSet = Collections.unmodifiableSortedSet(people);
//        sortedSet.add(new Person("Rayleigh")); ERROR
//        sortedSet.remove(new Person("Julie")); ERROR

    }
}
