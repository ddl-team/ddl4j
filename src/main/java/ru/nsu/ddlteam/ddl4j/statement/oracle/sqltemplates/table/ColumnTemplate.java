package ru.nsu.ddlteam.ddl4j.statement.oracle.sqltemplates.table;

import ru.nsu.ddlteam.ddl4j.model.impl.Column;
import ru.nsu.ddlteam.ddl4j.statement.oracle.sqltemplates.SqlTemplate;
import ru.nsu.ddlteam.ddl4j.statement.statementgenerator.NamedParameter;

public class ColumnTemplate implements SqlTemplate{
    private Column column;

    public ColumnTemplate(Column column) {
        this.column = column;
    }

    @Override
    public String getTemplate() {
        StringBuilder builder = new StringBuilder(":name :type");

        if (column.getSize() != null && column.getSize() > 0) {
            builder.append("(:size)");
        }

        if (column.getDefaultValue() != null && !column.getDefaultValue().isEmpty()) {
            builder.append(" DEFAULT :default");
        }

        if (column.isRequired()) {
            builder.append(" NOT NULL");
        }

        return builder.toString();
    }

    @NamedParameter(name = "name")
    private String name() {
        return column.getName();
    }

    @NamedParameter(name = "type")
    private String type() {
        return column.getType().toString();
    }

    @NamedParameter(name = "size")
    private String size() {
        return String.valueOf(column.getSize());
    }

    @NamedParameter(name = "default")
    private String defaultVal() {
        return column.getDefaultValue();
    }
}
