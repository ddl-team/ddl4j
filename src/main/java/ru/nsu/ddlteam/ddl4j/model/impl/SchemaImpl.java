package ru.nsu.ddlteam.ddl4j.model.impl;

import ru.nsu.ddlteam.ddl4j.model.Schema;

public class SchemaImpl implements Schema {
    private String name;

    public SchemaImpl() {
    }

    public SchemaImpl(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null ? name.toUpperCase() : null;
    }

    @Override
    public String toString() {
        return name;
    }
}
