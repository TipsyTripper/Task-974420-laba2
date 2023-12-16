package kours.database.config.database_properties;

import kours.database.config.DatabaseProperties;
import kours.database.config.PropertiesFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetPasswordTest {
    @Test
    @DisplayName("The only variant and answer")
    public void areaOfFigure4Invalid() {
        DatabaseProperties databaseProperties = PropertiesFactory.getProperties();
        String answer = databaseProperties.getPassword();
        Assertions.assertEquals("Password", answer);
    }
}
