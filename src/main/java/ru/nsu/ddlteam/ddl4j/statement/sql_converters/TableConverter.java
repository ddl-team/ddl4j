package ru.nsu.ddlteam.ddl4j.statement.sql_converters;

import ru.nsu.ddlteam.ddl4j.model.SQLable;
import ru.nsu.ddlteam.ddl4j.model.Table;
import ru.nsu.ddlteam.ddl4j.model.type.ActionType;
import ru.nsu.ddlteam.ddl4j.statement.Statement;
import ru.nsu.ddlteam.ddl4j.statement.StatementGeneratorException;

public class TableConverter {
    public static Statement convert(SQLable sqlable, ActionType type) throws StatementGeneratorException {

        if (!(sqlable instanceof Table)) {
            throw new StatementGeneratorException("Wrong converter for table");
        }

        Table table = (Table)sqlable;

        switch (type) {
            case CREATE: return convertCreate(table);
            case READ: return convertRead(table);
            case UPDATE: return convertUpdate(table);
            case DELETE: return convertDelete(table);
            default:
                throw new IllegalArgumentException("No case for ActionType: " + type);
        }

    }

    public static Statement convertCreate(Table table) {
        return null;
    }

    public static Statement convertRead(Table table) {
        return null;
    }

    public static Statement convertUpdate(Table table) {
        return null;
    }

    public static Statement convertDelete(Table table) {
        return null;
    }
}
