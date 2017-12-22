package ru.nsu.ddlteam.ddl4j.statement.oracle;

import ru.nsu.ddlteam.ddl4j.model.SQLable;
import ru.nsu.ddlteam.ddl4j.model.Table;
import ru.nsu.ddlteam.ddl4j.model.type.ActionType;
import ru.nsu.ddlteam.ddl4j.statement.SqlConverter;
import ru.nsu.ddlteam.ddl4j.statement.Statement;
import ru.nsu.ddlteam.ddl4j.statement.StatementConverter;
import ru.nsu.ddlteam.ddl4j.statement.StatementGeneratorException;
import ru.nsu.ddlteam.ddl4j.statement.sql_converters.TableConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class OracleStatementConverter implements StatementConverter {
    private Map<Class, SqlConverter<SQLable, ActionType, Statement>> statementsMap = new HashMap<>();

    public OracleStatementConverter() {
        statementsMap.put(Table.class, TableConverter::convert);
    }

    public Statement getStatement(SQLable object, ActionType actionType) throws StatementGeneratorException {
        SqlConverter<SQLable, ActionType, Statement> converter = statementsMap.get(object.getClass());

        if (converter == null) {
            throw new StatementGeneratorException("No converter for class: " + object.getClass());
        }

        return converter.apply(object, actionType);
    }
}
