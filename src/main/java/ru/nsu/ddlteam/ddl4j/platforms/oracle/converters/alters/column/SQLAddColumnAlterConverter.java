package ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.alters.column;

import ru.nsu.ddlteam.ddl4j.model.Column;
import ru.nsu.ddlteam.ddl4j.model.alters.column.AddColumnAlter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.Converter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.SQLConverter;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.NamedParameter;

/**
 * Created by ilya on 08.05.17.
 */
@Converter(modelClass = AddColumnAlter.class)
public class SQLAddColumnAlterConverter implements SQLConverter {
    private AddColumnAlter addColumnAlter;

    public SQLAddColumnAlterConverter(AddColumnAlter addColumnAlter) {
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
