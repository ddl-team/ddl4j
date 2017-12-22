package ru.nsu.ddlteam.ddl4j.statement;

public interface Statement {
    String getTemplate();

    String getSql(Object... args);
}
