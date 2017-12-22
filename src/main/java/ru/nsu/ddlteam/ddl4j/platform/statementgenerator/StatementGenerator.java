package ru.nsu.ddlteam.ddl4j.platform.statementgenerator;

import ru.nsu.ddlteam.ddl4j.platform.oracle.sqltemplates.SqlTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by ilya on 11.05.17.
 */
@SuppressWarnings(value = "unchecked")
public class StatementGenerator {
    
    public static String generate(SqlTemplate converter) throws StatementGeneratorException {
        try {
            String template = converter.getTemplate();
            Class c = converter.getClass();
            Method[] methods = c.getDeclaredMethods();

            for (Method m : methods) {
                NamedParameter annotation = m.getAnnotation(NamedParameter.class);
                if (annotation != null) {
                    // TODO: 21.12.17 CREATE SHIELDING
                    m.setAccessible(true);

                    Object value = m.invoke(converter);
                    String valueStr;
                    if (value instanceof List) {
                        valueStr = String.join(", ", (List)value);
                    } else {
                        valueStr = value != null ? value.toString() : "";
                    }
                    template = template.replaceAll(":" + annotation.name(), valueStr);

                }

            }

            return template;

        } catch (IllegalAccessException | InvocationTargetException e) {
           throw new StatementGeneratorException("Can't generate statement", e);
        }
    }

}
