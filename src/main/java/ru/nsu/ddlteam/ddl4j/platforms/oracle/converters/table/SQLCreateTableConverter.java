package ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.table;

import ru.nsu.ddlteam.ddl4j.model.Column;
import ru.nsu.ddlteam.ddl4j.model.Table;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.Converter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.SQLConverter;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.NamedParameter;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.StatementGenerator;
import ru.nsu.ddlteam.ddl4j.platforms.statementgenerator.StatementGeneratorException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill Batalin (kir55rus) on 08.05.17.
 */
@Converter(modelClass = Table.class)
public class SQLCreateTableConverter implements SQLConverter {
    private static final String TEMPLATE = "CREATE TABLE :table (:columns)";
    private Table table;

    public SQLCreateTableConverter(Table table) {
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
            SQLConverter columnConverter = new SQLColumnConverter(column);
            columnsSQL.add(StatementGenerator.generate(columnConverter));
        }

        return String.join(", ", columnsSQL);
    }
}
