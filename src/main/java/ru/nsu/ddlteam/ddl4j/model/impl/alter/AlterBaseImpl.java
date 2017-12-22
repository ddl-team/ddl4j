package ru.nsu.ddlteam.ddl4j.model.impl.alter;

import ru.nsu.ddlteam.ddl4j.model.Alter;
import ru.nsu.ddlteam.ddl4j.model.impl.Table;

/**
 * Created by ilya on 08.05.17.
 */
public class AlterBaseImpl implements Alter {
    private Table table;

    protected AlterBaseImpl(Table table) {
        this.table = table;
    }

    @Override
    public Table getTable() {
        return table;
    }
}
