package rizaton.collection.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    private String name;

    private final List<String> hobbies;

    public Person(String name) {
        this.name = name;
        this.hobbies = new ArrayList<>();
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public List<String> getHobbies() {
        return Collections.unmodifiableList(this.hobbies);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
