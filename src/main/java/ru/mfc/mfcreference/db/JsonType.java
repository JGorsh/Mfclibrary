package ru.mfc.mfcreference.db;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Component
public class JsonType implements UserType {

    private ObjectMapper mapper;

    public JsonType() {
        if (mapper == null) {
            mapper = new ObjectMapper()
                    .registerModule(new ParameterNamesModule())
                    .registerModule(new Jdk8Module())
                    .registerModule(new JavaTimeModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public Class<Map> returnedClass() {
        return Map.class;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        final String cellContent = resultSet.getString(strings[0]);
        if (cellContent == null) {
            return null;
        }
        try {
            return mapper.readValue(cellContent.getBytes(StandardCharsets.UTF_8), returnedClass());
        } catch (final Exception ex) {
            return cellContent;
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object value, int idx, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (value == null) {
            preparedStatement.setNull(idx, Types.OTHER);
            return;
        }
        try {
            StringWriter w = new StringWriter();
            mapper.writeValue(w, value);
            w.flush();
            preparedStatement.setObject(idx, w.toString(), Types.OTHER);
        } catch (final Exception ex) {
            throw new RuntimeException("Failed to convert Invoice to String: " + ex.getMessage(), ex);
        }
    }


    @Override
    public Object deepCopy(final Object originalValue) throws HibernateException {
        if (originalValue == null) {
            return null;
        }
        if (!(originalValue instanceof Map)) {
            return null;
        }
        Map resultMap = new HashMap<>();

        Map tempMap = (Map) originalValue;
        tempMap.forEach((key, value) -> resultMap.put(key, value));
        return resultMap;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(final Object value) throws HibernateException {
        return (Serializable) this.deepCopy(value);
    }

    @Override
    public Object assemble(final Serializable cached, final Object owner) throws HibernateException {
        return this.deepCopy(cached);
    }

    @Override
    public Object replace(final Object original, final Object target, final Object owner) throws HibernateException {
        return this.deepCopy(original);
    }

    @Override
    public boolean equals(final Object obj1, final Object obj2) throws HibernateException {
        if (obj1 == null) {
            return obj2 == null;
        }
        return obj1.equals(obj2);
    }

    @Override
    public int hashCode(final Object obj) throws HibernateException {
        return obj.hashCode();
    }


}
