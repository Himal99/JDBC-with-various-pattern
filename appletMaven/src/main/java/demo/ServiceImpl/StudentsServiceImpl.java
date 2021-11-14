package demo.ServiceImpl;

import demo.Entity.Students;
import demo.Service.MasterService;
import demo.Service.StudentsService;
import demo.db.DbConnection;
import demo.db.DbFactory;
import demo.db.JdbcTemplate;
import demo.db.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentsServiceImpl implements MasterService<Students> {
    List<Students> studentsList = new ArrayList<Students>();
    private JdbcTemplate<Students> jdbcTemplate = new JdbcTemplate<Students>();
    public int insert(Students model) throws Exception {
        String sql = "insert into students(name,address,phone,gender) values(" +
                "?,?,?,?)";
       return jdbcTemplate.update(sql,new Object[]{
               model.getName(),
               model.getAddress(),
               model.getPhone(),
               model.getGender()
       });
    }

//    Returns all data from database
    public List<Students> findAll() throws Exception {
       return jdbcTemplate.findAll(new RowMapper<Students>() {
           public Students mapRow(ResultSet rs) throws Exception {
              Students students = new Students();
              students.setName(rs.getString("name"));
              students.setAddress(rs.getString("address"));
              students.setPhone(rs.getString("phone"));
              students.setGender(rs.getString("gender"));
              students.setStatus(rs.getBoolean("status"));
              return students;
           }
       }, "select *from students");
    }

    public void delete(int id)throws Exception {
       String sql = "delete from students where id=?";
       int row = jdbcTemplate.update(sql, new Object[]{
               id
       });
        System.out.println(row + "row effected");
    }

    public int update(Students model)throws Exception{
//        update code here....
        String sql = "update students set name = ?, address = ?, phone = ?, gender = ? where id=?";
       return jdbcTemplate.update(sql, new Object[]{
               model.getName(),
               model.getAddress(),
               model.getPhone(),
               model.getGender(),
               model.getId()
       });
    }

    public Students findById(int id)throws Exception {
        Students students = new Students();
        String sql ="select *from students where id=?";
        return jdbcTemplate.findById(sql,
                id, rs -> {
            students.setName(rs.getString("name"));
       students.setAddress(rs.getString("address"));
       students.setPhone(rs.getString("phone"));
       students.setId(rs.getInt("id"));
       return students;
        });

    }
}
