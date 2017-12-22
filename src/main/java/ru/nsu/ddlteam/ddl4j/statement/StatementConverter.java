package ru.nsu.ddlteam.ddl4j.statement;

import ru.nsu.ddlteam.ddl4j.model.SQLable;
import ru.nsu.ddlteam.ddl4j.model.type.ActionType;

public interface StatementConverter {
    String getStatement(SQLable object, ActionType actionType) throws StatementGeneratorException;
}
