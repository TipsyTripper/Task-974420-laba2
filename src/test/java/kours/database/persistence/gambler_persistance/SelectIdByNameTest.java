package kours.database.persistence.gambler_persistance;

import static org.mockito.Mockito.*;

import kours.database.database.MyDataBase;
import kours.database.persistence.GamblerPersistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelectIdByNameTest {
    private final MyDataBase myDatabase = mock(MyDataBase.class);
    private final GamblerPersistence gamblerPersistence = new GamblerPersistence();

    @BeforeEach
    public void init() {
        gamblerPersistence.db = myDatabase;
    }

    @Test
    @DisplayName("when student exists in table return their id")
    public void whenStudentIsExistsInDbThenReturnId() {
        int definitelyId = 4;
        int definitelyId2 = 3;
        when(myDatabase.selectSomeColumnByName("name1", "id")).thenReturn(definitelyId);
        when(myDatabase.selectSomeColumnByName("name2", "id")).thenReturn(definitelyId2);

        int trueResult = gamblerPersistence.selectIdByName("name1");
        int trueResult2 = gamblerPersistence.selectIdByName("name2");

        Assertions.assertEquals(4, trueResult);
        Assertions.assertEquals(3, trueResult2);
    }

    @Test
    @DisplayName("when student does not exist in table return their 0")
    public void whenStudentIsNotExistsInDbThenReturn0() {
        int trueResult = gamblerPersistence.selectIdByName("name2");

        Assertions.assertEquals(0, trueResult);
    }
}
