package ru.nsu.ddlteam.ddl4j.model;

import ru.nsu.ddlteam.ddl4j.model.impl.Table;

public interface Alter extends SQLable {
    Table getTable();
}
