package ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.table;

import ru.nsu.ddlteam.ddl4j.model.Table;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.Converter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.SQLConverter;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.NamedParameter;

/**
 * Created by Kirill Batalin (kir55rus).
 */
@Converter(modelClass = Table.class, action = "DROP")
public class SQLDropTableConverter implements SQLConverter {
    private static final String TEMPLATE = "DROP TABLE :table";
    private Table table;

    public SQLDropTableConverter(Table table) {
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
