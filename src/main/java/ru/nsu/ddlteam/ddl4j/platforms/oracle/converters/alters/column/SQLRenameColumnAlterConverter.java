package ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.alters.column;

import ru.nsu.ddlteam.ddl4j.model.alters.column.RenameColumnAlter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.Converter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.SQLConverter;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.NamedParameter;

/**
 * Created by ilya on 18.05.17.
 */
@Converter(modelClass = RenameColumnAlter.class)
public class SQLRenameColumnAlterConverter implements SQLConverter {
    private static final String TEMPLATE = "ALTER TABLE :table RENAME COLUMN :old_name TO :new_name";
    private RenameColumnAlter renameColumnAlter;

    public SQLRenameColumnAlterConverter(RenameColumnAlter renameColumnAlter) {
        this.renameColumnAlter = renameColumnAlter;
    }

    @Override
    public String getTemplate() {
        return TEMPLATE;
    }

    @NamedParameter(name = "table")
    private String table() {
        return renameColumnAlter.getTable().getFullName();
    }

    @NamedParameter(name = "old_name")
    private String old_name() {
        return renameColumnAlter.getOldColumn().getName();
    }

    @NamedParameter(name = "new_name")
    private String new_name() {
        return renameColumnAlter.getNewColumn().getName();
    }
}
