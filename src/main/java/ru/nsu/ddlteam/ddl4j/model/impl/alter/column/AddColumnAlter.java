package ru.nsu.ddlteam.ddl4j.model.impl.alter.column;

import ru.nsu.ddlteam.ddl4j.model.impl.Column;
import ru.nsu.ddlteam.ddl4j.model.impl.Table;
import ru.nsu.ddlteam.ddl4j.model.impl.alter.AlterBaseImpl;

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
