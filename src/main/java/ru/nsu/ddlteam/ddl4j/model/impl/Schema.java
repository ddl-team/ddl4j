package ru.nsu.ddlteam.ddl4j.model.impl;

import ru.nsu.ddlteam.ddl4j.model.Requestable;
import ru.nsu.ddlteam.ddl4j.model.SQLable;

public class Schema implements Requestable, SQLable {
    private String name;

    public Schema() {
    }

    public Schema(String name) {
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
