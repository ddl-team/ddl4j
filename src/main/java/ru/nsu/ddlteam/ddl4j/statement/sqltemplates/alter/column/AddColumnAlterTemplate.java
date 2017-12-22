package ru.nsu.ddlteam.ddl4j.statement.sqltemplates.alter.column;

import ru.nsu.ddlteam.ddl4j.model.impl.Column;
import ru.nsu.ddlteam.ddl4j.model.impl.alter.column.AddColumnAlter;
import ru.nsu.ddlteam.ddl4j.statement.sqltemplates.SqlTemplate;
import ru.nsu.ddlteam.ddl4j.statement.statementgenerator.NamedParameter;

public class AddColumnAlterTemplate implements SqlTemplate {
    private AddColumnAlter addColumnAlter;

    public AddColumnAlterTemplate(AddColumnAlter addColumnAlter) {
        this.addColumnAlter = addColumnAlter;
    }

    @Override
    public String getTemplate() {
        StringBuilder builder = new StringBuilder("ALTER TABLE :table ADD (:column :type");

        Column column = addColumnAlter.getColumn();
        if (column.getSize() != null && column.getSize() > 0) {
            builder.append("(:size)");
        }

        if (column.getDefaultValue() != null && !column.getDefaultValue().isEmpty()) {
            builder.append(" DEFAULT :default");
        }

        if (column.isRequired()) {
            builder.append(" NOT NULL");
        }

        builder.append(")");

        return builder.toString();
    }

    @NamedParameter(name = "table")
    private String table() {
        return addColumnAlter.getTable().getFullName();
    }

    @NamedParameter(name = "column")
    private String column() {
        return addColumnAlter.getColumn().getName();
    }

    @NamedParameter(name = "type")
    private String type() {
        return addColumnAlter.getColumn().getType().toString();
    }

    @NamedParameter(name = "size")
    private String size() {
        return String.valueOf(addColumnAlter.getColumn().getSize());
    }

    @NamedParameter(name = "default")
    private String defaultVal() {
        return addColumnAlter.getColumn().getDefaultValue();
    }

}