package bank.management.system;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton withdrawl, deposit, fastcash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;

    public FastCash(String pinnumber) {

        this.pinNumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 865);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(235, 265, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 397, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 397, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 432, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Rs 2000");
        miniStatement.setBounds(355, 432, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(170, 468, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Rs 10000");
        balanceEnquiry.setBounds(355, 468, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Back");
        exit.setBounds(355, 502, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn cn = new Conn();
            try {
                ResultSet rs = cn.s.executeQuery("SELECT * FROM bank WHERE pinNo = '" + pinNumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource()!= exit && balance <Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = sdf.format(date);
                
            String query="insert into bank values('"+pinNumber+"','"+formatDate+"','Withdrawl','"+amount+"')" ;
            cn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs "+ amount+"Debited Successfully");
            
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }

}
