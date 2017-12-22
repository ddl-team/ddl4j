package ru.nsu.ddlteam.ddl4j.statement;

import ru.nsu.ddlteam.ddl4j.model.Entity;
import ru.nsu.ddlteam.ddl4j.model.SQLable;
import ru.nsu.ddlteam.ddl4j.model.type.ActionType;

public interface SqlConverter {
    Statement apply(SQLable t, ActionType s) throws StatementGeneratorException;
}
