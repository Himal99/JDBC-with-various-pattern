package demo.db;

import java.sql.ResultSet;

@FunctionalInterface
public interface RowMapper<T> {
    public T mapRow(ResultSet rs)throws Exception;
}
