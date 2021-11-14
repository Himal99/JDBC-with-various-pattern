package demo.ServiceImpl;

import demo.Entity.Teachers;
import demo.Service.MasterService;
import demo.Service.TeacherService;
import demo.db.JdbcTemplate;
import demo.db.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public class TeacherServiceImpl implements MasterService<Teachers> {
    JdbcTemplate<Teachers> jdbcTemplate = new JdbcTemplate<Teachers>();
    public int insert(Teachers model) throws Exception {
        String sql = "insert into teacher(name,address,phone) values(?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{
                model.getName(),
                model.getAddress(),
                model.getPhone()
        });
    }

    public List<Teachers> findAll() throws Exception {
        Teachers teachers = new Teachers();
        String sql ="select *from teacher";
        return jdbcTemplate.findAll(new RowMapper<Teachers>() {
            @Override
            public Teachers mapRow(ResultSet rs) throws Exception {
                teachers.setName(rs.getString("name"));
                teachers.setAddress(rs.getString("address"));
                teachers.setPhone(rs.getString("phone"));
                return teachers;
            }
        },sql);
    }

    public void delete(int id) throws Exception {

    }

    public int update(Teachers model) {
        return 0;
    }

    public Teachers findById(int id) {
        return null;
    }
}
