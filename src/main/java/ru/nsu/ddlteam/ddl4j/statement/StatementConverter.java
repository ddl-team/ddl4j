package ru.nsu.ddlteam.ddl4j.statement;

import ru.nsu.ddlteam.ddl4j.model.SQLable;
import ru.nsu.ddlteam.ddl4j.model.type.ActionType;
import ru.nsu.ddlteam.ddl4j.platform.statementgenerator.StatementGeneratorException;

public interface StatementConverter {
    String getStatement(SQLable object, ActionType actionType) throws StatementGeneratorException;
}
