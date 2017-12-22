package ru.nsu.ddlteam.ddl4j.statement.oracle.sqlconverters;

import ru.nsu.ddlteam.ddl4j.model.SQLable;
import ru.nsu.ddlteam.ddl4j.model.impl.Table;
import ru.nsu.ddlteam.ddl4j.model.type.ActionType;
import ru.nsu.ddlteam.ddl4j.statement.StatementGeneratorException;
import ru.nsu.ddlteam.ddl4j.statement.oracle.sqltemplates.table.TableCreateTemplate;
import ru.nsu.ddlteam.ddl4j.statement.oracle.sqltemplates.table.TableDropTemplate;
import ru.nsu.ddlteam.ddl4j.statement.statementgenerator.StatementGenerator;

public class TableConverter {
    public static String convert(SQLable sqlable, ActionType type) throws StatementGeneratorException {

        if (!(sqlable instanceof Table)) {
            throw new StatementGeneratorException("Wrong converter for table");
        }

        Table table = (Table)sqlable;

        switch (type) {
            case CREATE: return StatementGenerator.generate(new TableCreateTemplate(table));
            case DELETE: return StatementGenerator.generate(new TableDropTemplate(table));

            default:
                throw new IllegalArgumentException("No case for ActionType: " + type);
        }
    }

}
