package ru.nsu.ddlteam.ddl4j.statement.oracle;

import ru.nsu.ddlteam.ddl4j.model.SQLable;
import ru.nsu.ddlteam.ddl4j.model.impl.Table;
import ru.nsu.ddlteam.ddl4j.model.impl.alter.column.AddColumnAlter;
import ru.nsu.ddlteam.ddl4j.model.type.ActionType;
import ru.nsu.ddlteam.ddl4j.statement.SqlConverter;
import ru.nsu.ddlteam.ddl4j.statement.StatementConverter;
import ru.nsu.ddlteam.ddl4j.statement.StatementGeneratorException;
import ru.nsu.ddlteam.ddl4j.statement.sqlconverters.TableConverter;
import ru.nsu.ddlteam.ddl4j.statement.sqlconverters.TemplateConverter;
import ru.nsu.ddlteam.ddl4j.statement.sqltemplates.alter.column.AddColumnAlterTemplate;

import java.util.HashMap;
import java.util.Map;

public class OracleStatementConverter implements StatementConverter {
    private Map<Class, SqlConverter> statementsMap = new HashMap<>();

    public OracleStatementConverter() throws StatementGeneratorException {
        statementsMap.put(Table.class, TableConverter::convert);
        statementsMap.put(AddColumnAlter.class, TemplateConverter.convert(AddColumnAlterTemplate.class));
    }

    public String getStatement(SQLable sqlable, ActionType actionType) throws StatementGeneratorException {
        SqlConverter converter = statementsMap.get(sqlable.getClass());

        if (converter == null) {
            throw new StatementGeneratorException("No converter for class: " + sqlable.getClass());
        }

        return converter.apply(sqlable, actionType);
    }

    public String getStatement(SQLable sqlable) throws StatementGeneratorException {
        return getStatement(sqlable, ActionType.CREATE);
    }

    public static void main(String[] args) {
//        try {
//            OracleStatementConverter converter = new OracleStatementConverter();
//            Column c1 = new Column();
//            c1.setName("c1");
//            c1.setType(new DBType("INTEGER"));
//
//            Column c2 = new Column();
//            c1.setName("c2");
//            c1.setType(new DBType("INTEGER"));
//
//            Table t = new Table();
//            t.addColumn(c1);
//            t.setName("t1");
//
//            AddColumnAlter aca = new AddColumnAlter(t, c2);
//            System.out.println(converter.getStatement(aca));
//        } catch (StatementGeneratorException e) {
//            e.printStackTrace();
//        }
    }

}
