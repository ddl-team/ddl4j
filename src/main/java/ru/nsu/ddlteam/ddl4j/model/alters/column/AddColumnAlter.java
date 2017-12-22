package ru.nsu.ddlteam.ddl4j.model.alters.column;

import ru.nsu.ddlteam.ddl4j.model.Column;
import ru.nsu.ddlteam.ddl4j.model.Table;
import ru.nsu.ddlteam.ddl4j.model.alters.AlterBaseImpl;

/**
 * Created by ilya on 07.05.17.
 */
public class AddColumnAlter extends AlterBaseImpl {
    private Column column;

    public AddColumnAlter(Table table, Column column) {
        super(table);
        this.column = column;
    }

    public Column getColumn() {
        return column;
    }
}
