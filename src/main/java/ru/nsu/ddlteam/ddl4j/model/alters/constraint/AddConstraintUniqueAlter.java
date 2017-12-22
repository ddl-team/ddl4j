package ru.nsu.ddlteam.ddl4j.model.alters.constraint;

import ru.nsu.ddlteam.ddl4j.model.Column;
import ru.nsu.ddlteam.ddl4j.model.Table;
import ru.nsu.ddlteam.ddl4j.model.alters.AlterBaseImpl;

import java.util.List;

/**
 * Created by ilya on 18.05.17.
 */
public class AddConstraintUniqueAlter extends AlterBaseImpl {
    private String name;
    private List<Column> columns;

    public AddConstraintUniqueAlter(Table table, String name, List<Column> columns) {
        super(table);
        this.name = name;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
