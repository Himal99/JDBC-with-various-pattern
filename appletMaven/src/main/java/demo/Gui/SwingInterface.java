package demo.Gui;

import javax.swing.*;

public class SwingInterface extends JFrame {
    private JFrame frame = new JFrame();
   public SwingInterface(){
        init();
    }

    private void init(){
       JLabel name,address,phone;
       JTextField nameTxt,addressTxt,phoneTxt;
       name= new JLabel("name:");
       nameTxt = new JTextField();
       nameTxt.setBounds(100,100,200,50);
       name.setBounds(100,100,100,100);
       frame.add(name);
       frame.add(nameTxt);
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);


    }
}
