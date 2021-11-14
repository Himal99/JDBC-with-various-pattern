package demo;
import demo.Entity.Students;
import demo.Entity.Teachers;
import demo.Gui.SwingInterface;
import demo.Service.MasterService;
import demo.db.DbConnection;
import demo.db.DbFactory;

/**
 * @author Himal Rai
 * 11/13/2021
 **/

public class Home {

    public static void main(String[] args) {
      try {
          MasterService sr = DbFactory.getDb("teacher");

            sr.findAll().forEach(v->{
                System.out.println(v);
            });
      }catch (Exception ex){
          ex.printStackTrace();
      }
    }
}
