package ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.alters.constraint;

import ru.nsu.ddlteam.ddl4j.model.Column;
import ru.nsu.ddlteam.ddl4j.model.alters.constraint.AddConstraintPrimaryAlter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.Converter;
import ru.nsu.ddlteam.ddl4j.platforms.oracle.converters.SQLConverter;
import ru.nsu.ddlteam.ddl4j.platforms.statement_generator.NamedParameter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ilya on 18.05.17.
 */
@Converter(modelClass = AddConstraintPrimaryAlter.class)
public class SQLAddConstraintPrimaryAlterConverter implements SQLConverter {
    private final String TEMPLATE =
            "ALTER TABLE :table ADD CONSTRAINT :name PRIMARY KEY ( :columns )";
    private AddConstraintPrimaryAlter addConstraintPrimaryAlter;

    public SQLAddConstraintPrimaryAlterConverter(AddConstraintPrimaryAlter addConstraintPrimaryAlter) {
        this.addConstraintPrimaryAlter = addConstraintPrimaryAlter;
    }

    @Override
    public String getTemplate() {
        return TEMPLATE;
    }

    @NamedParameter(name = "table")
    private String table() {
        return addConstraintPrimaryAlter.getTable().getFullName();
    }

    @NamedParameter(name = "name")
    private String name() {
        return addConstraintPrimaryAlter.getName();
    }

    @NamedParameter(name = "columns")
    private List<String> columns() {
        return addConstraintPrimaryAlter
                .getColumns()
                .stream()
                .map(Column::getName)
                .collect(Collectors.toList());
    }
}
