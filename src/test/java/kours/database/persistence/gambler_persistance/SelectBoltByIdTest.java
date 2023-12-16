package kours.database.persistence.gambler_persistance;

import kours.database.database.MyDataBase;
import kours.database.persistence.GamblerPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SelectBoltByIdTest {

    private final MyDataBase myDatabase = mock(MyDataBase.class);
    private final GamblerPersistence gamblerPersistence = new GamblerPersistence();

    @BeforeEach
    public void init() {
        gamblerPersistence.db = myDatabase;
    }

    @Test
    @DisplayName("when id exists in table return gambler's bolt")
    public void whenIdExistsInDbThenReturnBolt() {
        final int definitelyBolt = 50;
        when(myDatabase.selectColumnById(2, "bolt")).thenReturn(definitelyBolt);

        int trueResult = gamblerPersistence.selectBoltById(2);

        Assertions.assertEquals(definitelyBolt, trueResult);
    }

    @Test
    @DisplayName("when student does not exist in table return their 0")
    public void whenIdDoesNotExistInDbThenReturn0() {
        int trueResult = gamblerPersistence.selectBoltById(1);

        Assertions.assertEquals(0, trueResult);
    }
}
