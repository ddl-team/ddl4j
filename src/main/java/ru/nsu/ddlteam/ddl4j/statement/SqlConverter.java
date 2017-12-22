package ru.nsu.ddlteam.ddl4j.statement;

@FunctionalInterface
public interface SqlConverter<T, S, R> {
    R apply(T t, S s) throws StatementGeneratorException;
}
