package demo.Gui;

import demo.Entity.Students;
import demo.Service.MasterService;
import demo.ServiceImpl.StudentsServiceImpl;
import demo.db.DbFactory;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class UserInterFace extends Applet {

    int updateId = 0;
    Label name,address,phone;
    TextField nameTxt,addressTxt,phoneTxt,searchData;
    Button save,search,update;

    Component allComponent[] = {
            name = new Label("Name"),
            nameTxt = new TextField(20),
            address = new Label("Address"),
            addressTxt = new TextField(20),
            phone = new Label("Phone"),
            phoneTxt= new TextField(20),
            save = new Button("Save"),
            searchData = new TextField(5),
            search = new Button("Search"),
            update = new Button("Update")

    };
    List<Component> componentsList = Arrays.asList(allComponent);


    @Override
    public void init() {
        componentsList.forEach(com->{
            add(com);
        });
        onSave();
        onSearch();
        upDate();
    }


    @Override
    public void paint(Graphics g) {

    }

    private void onSave() {

        save.addActionListener(e -> {
            try {
                MasterService sr = DbFactory.getDb("students");
                Students students = new Students();
                students.setName(nameTxt.getText());
                students.setAddress(addressTxt.getText());
                students.setPhone(phoneTxt.getText());
                int rs = 0;
                if (nameTxt.getText() == "" || addressTxt.getText() == "" || phoneTxt.getText() == "") {

                    JOptionPane.showMessageDialog(null, new String("Please insert all value"));

                } else {
                    rs = sr.insert(students);
                }
                if (rs > 0) {
                    JOptionPane.showMessageDialog(null, new String("Successfully saved !!"));
                    resetField();

                } else {
                    JOptionPane.showMessageDialog(null, new String("Error"));

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    private void onSearch() {
        search.addActionListener(e -> {
            System.out.println(e);
            try {
                StudentsServiceImpl sr = new StudentsServiceImpl();
                Students students = sr.findById(Integer.parseInt(searchData.getText()));
                if (students != null) {
                    System.out.println(students);
                    nameTxt.setText(students.getName());
                    addressTxt.setText(students.getAddress());
                    phoneTxt.setText(students.getPhone());
                    updateId = students.getId();
                    System.out.println(updateId);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

    }

    private void upDate() {
        System.out.println(updateId);
        update.addActionListener(e -> {
            StudentsServiceImpl sr = new StudentsServiceImpl();
            Students students = new Students();
            students.setId(updateId);
            students.setName(nameTxt.getText());
            students.setAddress(addressTxt.getText());
            students.setPhone(phoneTxt.getText());
            students.setGender("M");
            System.out.println(students.getId());

            try {
                int result = sr.update(students);

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, new String("SuccessFully update !!"));
                    resetField();
                } else {
                    JOptionPane.showMessageDialog(null, new String("Something went wrong !!"));

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
    }

    private void delete() {
//        delete code here ...........
    }

    private void resetField() {
        nameTxt.setText("");
        addressTxt.setText("");
        phoneTxt.setText("");
    }
}
