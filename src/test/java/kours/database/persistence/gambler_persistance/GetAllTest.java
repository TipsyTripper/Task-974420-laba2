package kours.database.persistence.gambler_persistance;

import kours.database.database.MyDataBase;
import kours.database.persistence.GamblerPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetAllTest {

    private final MyDataBase myDatabase = mock(MyDataBase.class);
    private final GamblerPersistence gamblerPersistence = new GamblerPersistence();

    @BeforeEach
    public void init() {
        gamblerPersistence.db = myDatabase;
    }

    @Test
    @DisplayName("when id exists in table return all information")
    public void whenIdExistsInDbThenReturnBolt() {
        Map<Integer, String> answer = new HashMap<>();
        answer.put(1, "Killer2005 | 4 | 50");
        answer.put(2, "Pro100Hackr | 4 | 50");
        when(myDatabase.selectAll("name", "bolt", "gamblers")).thenReturn(answer);

        Map<Integer, String> trueResult = gamblerPersistence.getAll();

        Assertions.assertEquals(answer, trueResult);
    }
}
