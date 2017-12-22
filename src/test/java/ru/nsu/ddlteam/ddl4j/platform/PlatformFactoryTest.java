package ru.nsu.ddlteam.ddl4j.platform;

import org.junit.Test;
import ru.nsu.ddlteam.ddl4j.model.ConnectionProperties;
import ru.nsu.ddlteam.ddl4j.model.type.DatabaseType;

public class PlatformFactoryTest {
    @Test
    public void testCreation() {
        PlatformFactory factory = new PlatformFactory();
        factory.getPlatform(DatabaseType.ORACLE, new ConnectionProperties("","","","",""));
    }
}
