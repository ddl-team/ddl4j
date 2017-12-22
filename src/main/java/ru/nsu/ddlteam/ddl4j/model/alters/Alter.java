package ru.nsu.ddlteam.ddl4j.model.alters;

import ru.nsu.ddlteam.ddl4j.model.SQLConvertible;
import ru.nsu.ddlteam.ddl4j.model.Table;

/**
 * Created by ilya on 07.05.17.
 */
public interface Alter extends SQLConvertible {
    Table getTable();
}
