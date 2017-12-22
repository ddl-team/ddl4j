package ru.nsu.ddlteam.ddl4j.statement.oracle.sqltemplates.table;

import ru.nsu.ddlteam.ddl4j.model.impl.Column;
import ru.nsu.ddlteam.ddl4j.model.impl.Table;
import ru.nsu.ddlteam.ddl4j.statement.StatementGeneratorException;
import ru.nsu.ddlteam.ddl4j.statement.oracle.sqltemplates.SqlTemplate;
import ru.nsu.ddlteam.ddl4j.statement.statementgenerator.NamedParameter;
import ru.nsu.ddlteam.ddl4j.statement.statementgenerator.StatementGenerator;

import java.util.ArrayList;
import java.util.List;

public class TableCreateTemplate implements SqlTemplate{
    private final String TEMPLATE = "CREATE TABLE :table (:columns)";
    private Table table;

    public TableCreateTemplate(Table table) {
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

    @NamedParameter(name = "columns")
    private String columns() throws StatementGeneratorException {
        List<String> columnsSQL = new ArrayList<>();
        for (Column column : table.getColumns()) {
            SqlTemplate columnConverter = new ColumnTemplate(column);
            columnsSQL.add(StatementGenerator.generate(columnConverter));
        }

        return String.join(", ", columnsSQL);
    }
}
