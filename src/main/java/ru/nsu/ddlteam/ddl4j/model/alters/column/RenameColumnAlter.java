package ru.nsu.ddlteam.ddl4j.model.alters.column;

import ru.nsu.ddlteam.ddl4j.model.Column;
import ru.nsu.ddlteam.ddl4j.model.Table;

/**
 * Created by ilya on 18.05.17.
 */
public class RenameColumnAlter extends ModifyColumnAlter{
    public RenameColumnAlter(Table table, Column oldColumn, Column newColumn) {
        super(table, oldColumn, newColumn);
    }
}
