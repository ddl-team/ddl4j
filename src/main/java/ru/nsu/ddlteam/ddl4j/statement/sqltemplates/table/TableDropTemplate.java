package ru.nsu.ddlteam.ddl4j.statement.sqltemplates.table;

import ru.nsu.ddlteam.ddl4j.model.impl.Table;
import ru.nsu.ddlteam.ddl4j.statement.sqltemplates.SqlTemplate;
import ru.nsu.ddlteam.ddl4j.statement.statementgenerator.NamedParameter;

public class TableDropTemplate implements SqlTemplate{
    private final String TEMPLATE = "DROP TABLE :table";
    private Table table;

    public TableDropTemplate(Table table) {
        this.table = table;
    }

    @Override
    public String getTemplate() {
        return TEMPLATE;
    }

    @NamedParameter(name = "table")
    private String table() {
        return table.getFullName();
    }
}
