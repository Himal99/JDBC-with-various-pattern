package demo.helper;

import demo.Entity.Students;
import demo.Service.MasterService;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class FileHelper {
    private MasterService sr;
    public FileHelper(MasterService sr){
        this.sr = sr;
    }
    public void insert(String fileName)throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String data="";
        while ((data=reader.readLine())!= null){
            StringTokenizer tokenizer = new StringTokenizer(data,",");
            Students students = new Students();
            while (tokenizer.hasMoreTokens()){
//                    System.out.println(tokenizer.nextToken());
                students.setName(tokenizer.nextToken());
                students.setAddress(tokenizer.nextToken());
                students.setPhone(tokenizer.nextToken());
                students.setGender(tokenizer.nextToken());
              int rs =  sr.insert(students);
              if(rs > 0){
                  JOptionPane.showMessageDialog(null,new String("Successfully saved!!"));
              }
            }

        }
    }
}
