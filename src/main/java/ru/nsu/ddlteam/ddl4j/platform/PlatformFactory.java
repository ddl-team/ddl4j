package ru.nsu.ddlteam.ddl4j.platform;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.ddlteam.ddl4j.model.ConnectionProperties;
import ru.nsu.ddlteam.ddl4j.model.type.DatabaseType;
import ru.nsu.ddlteam.ddl4j.platform.impl.PlatformImpl;
import ru.nsu.ddlteam.ddl4j.statement.StatementConverter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PlatformFactory {
    private static Logger logger = LogManager.getLogger();

    private Properties connectionProperties;
    private Properties sqlProperties;

    {
        connectionProperties = new Properties();
        sqlProperties = new Properties();
        try {
            connectionProperties.load(PlatformFactory.class.getResourceAsStream("/connection.properties"));
            sqlProperties.load(PlatformFactory.class.getResourceAsStream("/sql.properties"));
        } catch (IOException e) {
            logger.error("Can't load config: {}", e);
        }
    }

    public Platform getPlatform(DatabaseType type, ConnectionProperties connection) {
        String url = this.connectionProperties.getProperty(type.toString());
        url = url.replace(":HOST", connection.getHostname())
                .replace(":PORT", connection.getPort())
                .replace(":SID", connection.getSid());

        String clazzName = this.sqlProperties.getProperty(type.toString());

        try {
            Class clazz = getClass().getClassLoader().loadClass(clazzName);
            Connection res = DriverManager.getConnection(url, connection.getUsername(), connection.getPassword());
            return new PlatformImpl(res, (StatementConverter) clazz.newInstance());
        } catch (SQLException e) {
            logger.error("Can't create connection");
            return null;
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            logger.error("Can't load class");
            return null;
        }
    }
}
