package ru.nsu.ddlteam.ddl4j.platform;

import ru.nsu.ddlteam.ddl4j.model.*;
import ru.nsu.ddlteam.ddl4j.model.impl.Column;
import ru.nsu.ddlteam.ddl4j.model.impl.Schema;
import ru.nsu.ddlteam.ddl4j.model.impl.Table;
import ru.nsu.ddlteam.ddl4j.statement.StatementConverter;

import java.sql.Connection;
import java.util.List;

public interface Platform {
    Connection getConnection();

    StatementConverter getStatementConverter();

    List<Database> loadDatabases();

    List<Schema> loadSchemas(Requestable entity);

    List<Table> loadTables(Requestable entity);

    List<Column> loadColumns(Requestable entity);

    List<Constraint> loadConstraint(Requestable requestable); // unique, primarykey, foreign key, check

    List<PrimaryKey> loadPrimaryKeys(Requestable requestable);

    List<Check> loadChecks(Requestable requestable);

    List<Unique> loadUnique(Requestable requestable);

    void create(Entity entity);

    void update(Alter alter);

    void drop(Entity entity);
}
