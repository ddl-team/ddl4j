package ru.nsu.ddlteam.ddl4j.platform.impl;

import ru.nsu.ddlteam.ddl4j.model.*;
import ru.nsu.ddlteam.ddl4j.model.impl.Column;
import ru.nsu.ddlteam.ddl4j.model.impl.Schema;
import ru.nsu.ddlteam.ddl4j.model.impl.Table;
import ru.nsu.ddlteam.ddl4j.platform.Platform;
import ru.nsu.ddlteam.ddl4j.statement.StatementConverter;

import java.sql.Connection;
import java.util.List;

public class PlatformImpl implements Platform {
    private Connection connection;
    private StatementConverter statementConverter;

    public PlatformImpl(Connection connection, StatementConverter statementConverter) {
        this.connection = connection;
        this.statementConverter = statementConverter;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public StatementConverter getStatementConverter() {
        return statementConverter;
    }

    @Override
    public List<Database> loadDatabases() {
        return null;
    }

    @Override
    public List<Schema> loadSchemas(Requestable entity) {
        return null;
    }

    @Override
    public List<Table> loadTables(Requestable entity) {
        return null;
    }

    @Override
    public List<Column> loadColumns(Requestable entity) {
        return null;
    }

    @Override
    public List<Constraint> loadConstraint(Requestable requestable) {
        return null;
    }

    @Override
    public List<PrimaryKey> loadPrimaryKeys(Requestable requestable) {
        return null;
    }

    @Override
    public List<Check> loadChecks(Requestable requestable) {
        return null;
    }

    @Override
    public List<Unique> loadUnique(Requestable requestable) {
        return null;
    }

    @Override
    public void create(Entity entity) {

    }

    @Override
    public void update(Alter alter) {

    }

    @Override
    public void drop(Entity entity) {

    }
}
