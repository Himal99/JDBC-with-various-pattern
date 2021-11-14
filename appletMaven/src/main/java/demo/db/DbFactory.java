package demo.db;

import demo.Service.MasterService;
import demo.ServiceImpl.StudentsServiceImpl;
import demo.ServiceImpl.TeacherServiceImpl;

import java.util.Scanner;

public class DbFactory {
    private static Scanner scanner = new Scanner(System.in);

    public static MasterService getDb(String name) {

        if(name == "students"){
            return new StudentsServiceImpl();
        } else if(name == "teacher"){
            return new TeacherServiceImpl();
        } else {
            return null;
        }
    }
}
