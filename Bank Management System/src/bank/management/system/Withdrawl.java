package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdrawl, back;
    String pinNumber;

    public Withdrawl(String pinnumber) {

        this.pinNumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 830);
        add(image);

        JLabel text = new JLabel("Enter Amount you want to Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(170, 280, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 330, 320, 25);
        image.add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355, 450, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(355, 485, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawl) {
            String withdrawAmount = amount.getText();
            Date date = new Date();
            if (withdrawAmount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);
                Conn cn = new Conn();
                String query = "insert into bank values('" + pinNumber + "','" +formattedDate+ "','Withdrawl', '" + withdrawAmount + "')";
                try {
                    
                    cn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+withdrawAmount+" Withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception ex) {
                    
                    System.out.println(ex);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }

}

