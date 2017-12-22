package ru.nsu.ddlteam.ddl4j.statement.oracle;

import ru.nsu.ddlteam.ddl4j.model.SQLable;
import ru.nsu.ddlteam.ddl4j.model.impl.Table;
import ru.nsu.ddlteam.ddl4j.model.type.ActionType;
import ru.nsu.ddlteam.ddl4j.statement.SqlConverter;
import ru.nsu.ddlteam.ddl4j.statement.StatementConverter;
import ru.nsu.ddlteam.ddl4j.statement.StatementGeneratorException;
import ru.nsu.ddlteam.ddl4j.statement.sqlconverters.TableConverter;

import java.util.HashMap;
import java.util.Map;

public class OracleStatementConverter implements StatementConverter {
    private Map<Class, SqlConverter> statementsMap = new HashMap<>();

    public OracleStatementConverter() {
        statementsMap.put(Table.class, TableConverter::convert);
    }

    public String getStatement(SQLable sqlable, ActionType actionType) throws StatementGeneratorException {
        SqlConverter converter = statementsMap.get(sqlable.getClass());

        if (converter == null) {
            throw new StatementGeneratorException("No converter for class: " + sqlable.getClass());
        }

        return converter.apply(sqlable, actionType);
    }
}
