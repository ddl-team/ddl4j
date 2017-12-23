package ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.table;

import ru.nsu.ddlteam.ddl4j.model.Column;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.SQLConverter;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.NamedParameter;

/**
 * Created by Kirill Batalin (kir55rus).
 */

public class SQLColumnConverter implements SQLConverter {
    private Column column;

    public SQLColumnConverter(Column column) {
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
