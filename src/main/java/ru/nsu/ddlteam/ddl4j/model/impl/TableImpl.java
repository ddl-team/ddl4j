package ru.nsu.ddlteam.ddl4j.model.impl;

import ru.nsu.ddlteam.ddl4j.model.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableImpl implements Table, Cloneable {
    private List<ColumnImpl> columns = new ArrayList<>();
    private Map<String, ColumnImpl> columnMap = new HashMap<>();
    private String name;
    private SchemaImpl schema;

    public void addColumn(ColumnImpl column) {
        columns.add(column);
        columnMap.put(column.getName(), column);
    }

    public List<ColumnImpl> getColumns() {
        return columns;
    }

    public ColumnImpl getColumn(String name) {
        return columnMap.get(name);
    }

    @Override
    public TableImpl clone() throws CloneNotSupportedException {
        TableImpl cloneTable = (TableImpl)super.clone();
        cloneTable.setName(name);
        for (ColumnImpl c : columns) {
            cloneTable.addColumn(c.clone());
        }
        return cloneTable;
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

    public SchemaImpl getSchema() {
        return schema;
    }

    public void setSchema(SchemaImpl schema) {
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
