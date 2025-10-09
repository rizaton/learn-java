package rizaton.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import rizaton.test.data.Person;
import rizaton.test.repository.PersonRepository;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    // IntelliJ IDEA Running args
    // -ea -javaagent:$MAVEN_REPOSITORY$/org/mockito/mockito-core/5.20.0/mockito-core-5.20.0.jar

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    public void setup() {
        personService = new PersonService(personRepository);
    }

    @Test
    public void testGetNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            personService.get("not found");
        });
    }

    @Test
    public void testGerPersonSuccess() {
        // Adding behavior to mock object
        Mockito.when(personRepository.selectById("iza"))
                .thenReturn(new Person("iza", "Iza"));

        var person = personService.get("iza");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("iza",person.getId());
        Assertions.assertEquals("Iza",person.getName());
    }

    @Test
    public void testCreateSuccess() {
        var person = personService.register("Iza");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Iza", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Iza"));

    }

}
