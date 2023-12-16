package kours.database.persistence.gambler_persistance;

import kours.database.database.MyDataBase;
import kours.database.persistence.GamblerPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SelectNameByIdTest {
    private final MyDataBase myDatabase = mock(MyDataBase.class);
    private final GamblerPersistence gamblerPersistence = new GamblerPersistence();

    @BeforeEach
    public void init() {
        gamblerPersistence.db = myDatabase;
    }

    @Test
    @DisplayName("when id exists in table return gambler's gamblers")
    public void whenIdExistsInDbThenReturnBolt() {
        final String definitelyName = "Killer2005";
        when(myDatabase.selectNameById(2, "name")).thenReturn(definitelyName);

        String trueResult = gamblerPersistence.selectNameById(2);

        Assertions.assertEquals(definitelyName, trueResult);
    }

    @Test
    @DisplayName("when student does not exist in table return their 0")
    public void whenIdDoesNotExistInDbThenReturn0() {
        String trueResult = gamblerPersistence.selectNameById(1);

        Assertions.assertNull(trueResult);
    }
}
