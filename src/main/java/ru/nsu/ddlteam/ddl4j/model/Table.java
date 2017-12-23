package ru.nsu.ddlteam.ddl4j.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Kirill Batalin (kir55rus) on 06.05.17.
 */
public class Table implements SQLConvertible {
    private List<Column> columns = new ArrayList<>();
    private Map<String, Column> columnMap = new HashMap<>();
    private String name;
    private Schema schema;

    public void addColumn(Column column) {
        columns.add(column);
        columnMap.put(column.getName(), column);
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Column getColumn(String name) {
        return columnMap.get(name);
    }

    public Table() {
    }

    public Table(Table table) {
        this.name = table.name;
        this.schema = table.schema;
        this.columns = table.columns.stream().map(Column::new).collect(Collectors.toList());
        this.columnMap = this.columns.stream().collect(Collectors.toMap(Column::getName, Function.identity()));
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        if (name == null || name.isEmpty()) {
            return null;
        }

        if (schema == null || schema.getName() == null || schema.getName().isEmpty()) {
            return name;
        }

        return schema.getName() + "." + name;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public void setName(String name) {
        this.name = name != null ? name.toUpperCase() : null;
    }

    @Override
    public String toString() {
        return name;
    }
}
