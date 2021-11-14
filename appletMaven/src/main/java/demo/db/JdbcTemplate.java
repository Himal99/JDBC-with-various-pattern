package demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate<T> {

    DbConnection connection = DbConnection.getDb();

   public  List<T> findAll(RowMapper<T> rowMapper, String sql) throws Exception {
        List<T> tList = new ArrayList<T>();
        PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            tList.add(rowMapper.mapRow(rs));
        }
        return tList;
    }

    public int update(String sql, Object[] params) throws Exception{
        PreparedStatement stmt = DbConnection.getConnection().prepareStatement(sql);
        int row=1;
        for(Object param: params){
            stmt.setObject(row,param);
            row++;
        }

        return stmt.executeUpdate();
    }

    public T findById(String sql,int id, RowMapper<T> mapper)throws  Exception{
       T t= null;
        PreparedStatement stm = DbConnection.getConnection().prepareStatement(sql);
        stm.setObject(1,id);
        ResultSet rs = stm.executeQuery();
        while (rs.next()){
            t = mapper.mapRow(rs);
        }
        return t;
    }
}
