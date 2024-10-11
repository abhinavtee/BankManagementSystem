package bank.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceEnquiry extends JFrame implements ActionListener {

    ImageIcon i1, i3;
    JButton back;
    String pinNumber;

    public BalanceEnquiry(String pinNumber) {

        this.pinNumber = pinNumber;

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 855, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 855);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 510, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn cn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = cn.s.executeQuery("SELECT * FROM bank WHERE pinNo = '" + pinNumber + "'");
            
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
          }catch (Exception ex) {
                        System.out.println(ex);
         }
         
        JLabel text=new JLabel("Your Current Balance Account is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);

    }

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }

}
