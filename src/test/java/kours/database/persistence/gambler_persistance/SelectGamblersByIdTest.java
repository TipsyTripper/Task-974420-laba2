package kours.database.persistence.gambler_persistance;

import kours.database.database.MyDataBase;
import kours.database.persistence.GamblerPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SelectGamblersByIdTest {
    private final MyDataBase myDatabase = mock(MyDataBase.class);
    private final GamblerPersistence gamblerPersistence = new GamblerPersistence();

    @BeforeEach
    public void init() {
        gamblerPersistence.db = myDatabase;
    }

    @Test
    @DisplayName("when id exists in table return gambler's gamblers")
    public void whenIdExistsInDbThenReturnGamblers() {
        int definitelyGamblersCount = 4;
        when(myDatabase.selectColumnById(2, "gamblers")).thenReturn(definitelyGamblersCount);

        int trueResult = gamblerPersistence.selectGamblersById(2);

        Assertions.assertEquals(definitelyGamblersCount, trueResult);
    }

    @Test
    @DisplayName("when student does not exist in table return their 0")
    public void whenIdDoesNotExistInDbThenReturn0() {
        int trueResult = gamblerPersistence.selectGamblersById(1);

        Assertions.assertEquals(0, trueResult);
    }
}
