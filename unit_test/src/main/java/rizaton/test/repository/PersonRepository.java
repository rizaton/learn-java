package rizaton.test.repository;

import rizaton.test.data.Person;

public interface PersonRepository {

    Person selectById(String id);

}
