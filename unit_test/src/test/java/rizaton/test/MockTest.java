package rizaton.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {
    // IntelliJ IDEA Running args
    // -ea -javaagent:$MAVEN_REPOSITORY$/org/mockito/mockito-core/5.20.0/mockito-core-5.20.0.jar

    @Test
    public void testMock(){


        var list = Mockito.mock(List.class);

        Mockito.when(list.getFirst()).thenReturn("1");
        Mockito.when(list.get(100)).thenReturn("100");

        System.out.println(list.getFirst());
//        System.out.println(list.getFirst());
        System.out.println(list.get(100));

        Mockito.verify(list, Mockito.times(1)).getFirst();

    }

}
