package ru.nsu.ddlteam.ddl4j.statement.sqlconverters;

import ru.nsu.ddlteam.ddl4j.statement.SqlConverter;
import ru.nsu.ddlteam.ddl4j.statement.StatementGeneratorException;
import ru.nsu.ddlteam.ddl4j.statement.sqltemplates.SqlTemplate;
import ru.nsu.ddlteam.ddl4j.statement.statementgenerator.StatementGenerator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TemplateConverter {
    public static <T extends SqlTemplate> SqlConverter convert(Class<T> templateClass) throws StatementGeneratorException {
        return (sqlable, action) -> {
            try {
                Constructor constructor = templateClass.getConstructor(sqlable.getClass());
                return StatementGenerator.generate((SqlTemplate)constructor.newInstance(sqlable));
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                throw new StatementGeneratorException(e);
            }
        };
    }
}
