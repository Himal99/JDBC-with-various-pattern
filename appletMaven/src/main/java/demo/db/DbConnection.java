package demo.db;

import java.sql.Connection;
import java.sql.DriverManager;

//    SingleTone Class
public class DbConnection {

    private static DbConnection dbConnection = null;

    private DbConnection(){

    }

    public static Connection getConnection()throws Exception {
        String url = "jdbc:mysql://localhost:3306/demo",
                user= "root", password ="";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }


    public static DbConnection getDb(){
      if(dbConnection == null) {
          dbConnection = new DbConnection();
      }

      return dbConnection;
    }
}
