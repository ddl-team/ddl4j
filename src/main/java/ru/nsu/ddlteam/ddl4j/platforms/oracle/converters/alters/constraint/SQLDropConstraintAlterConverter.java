package ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.alters.constraint;

import ru.nsu.ddlteam.ddl4j.model.alters.constraint.DropConstraintAlter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.Converter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.SQLConverter;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.NamedParameter;

/**
 * Created by ilya on 22.05.17.
 */
@Converter(modelClass = DropConstraintAlter.class)
public class SQLDropConstraintAlterConverter implements SQLConverter {
    private static final String TEMPLATE = "ALTER TABLE :table DROP CONSTRAINT :name";
    private DropConstraintAlter dropConstraintAlter;

    public SQLDropConstraintAlterConverter(DropConstraintAlter dropConstraintAlter) {
        this.dropConstraintAlter = dropConstraintAlter;
    }

    @Override
    public String getTemplate() {
        return TEMPLATE;
    }

    @NamedParameter(name = "table")
    private String table() {
        return dropConstraintAlter.getTable().getFullName();
    }

    @NamedParameter(name = "name")
    private String name() {
        return dropConstraintAlter.getConstraintName();
    }
}
