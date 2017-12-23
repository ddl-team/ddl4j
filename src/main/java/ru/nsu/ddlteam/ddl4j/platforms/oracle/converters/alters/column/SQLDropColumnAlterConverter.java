package ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.alters.column;

import ru.nsu.ddlteam.ddl4j.model.alters.column.DropColumnAlter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.Converter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.SQLConverter;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.NamedParameter;

/**
 * Created by ilya on 18.05.17.
 */
@Converter(modelClass = DropColumnAlter.class)
public class SQLDropColumnAlterConverter implements SQLConverter {
    private static final String TEMPLATE = "ALTER TABLE :table DROP COLUMN :column";
    private final DropColumnAlter dropColumnAlter;

    public SQLDropColumnAlterConverter(DropColumnAlter dropColumnAlter) {
        this.dropColumnAlter = dropColumnAlter;
    }

    @Override
    public String getTemplate() {
        return TEMPLATE;
    }

    @NamedParameter(name = "table")
    private String table() {
        return dropColumnAlter.getTable().getFullName();
    }

    @NamedParameter(name = "column")
    private String column() {
        return dropColumnAlter.getColumn().getName();
    }


}
