package ru.mfc.mfcreference.db;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.springframework.stereotype.Component;

import java.sql.Types;

@Component
public class CustomPostgreSQLDialect extends PostgreSQL94Dialect {

    public CustomPostgreSQLDialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
