package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JLabel image, text, pintext, repintext;
    JPasswordField pinTextField, repinTextField;
    JButton change, back;
    String pinNumber;

    public PinChange(String pinNumber) {
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 900, 830);
        add(image);

        text = new JLabel("Change YourrepinTextField PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 250, 400, 20);
        image.add(text);

        pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 280, 180, 25);
        image.add(pintext);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
        pinTextField.setBounds(330, 280, 180, 25);
        image.add(pinTextField);

        repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 320, 180, 20);
        image.add(repintext);

        repinTextField = new JPasswordField();
        repinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
        repinTextField.setBounds(330, 320, 180, 25);
        image.add(repinTextField);

        change = new JButton("Change");
        change.setBounds(355, 450, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 485, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
        try {

            String npin = pinTextField.getText();
            String reEnterpin = repinTextField.getText();

            if (!npin.equals(reEnterpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }
            if(reEnterpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please renter new PIN");
                return;
            }
            Conn cn=new Conn();
            String query1= "update bank set pinNo = '"+reEnterpin+"' where pinNo = '"+pinNumber+"'";
            String query2= "update login set pinNo = '"+reEnterpin+"' where pinNo = '"+pinNumber+"'";
            String query3= "update signup3 set pinNo = '"+reEnterpin+"' where pinNo = '"+pinNumber+"'";
            
            cn.s.executeUpdate(query1);
            cn.s.executeUpdate(query2);
            cn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN changed Successfully");
            setVisible(false);
            new Transactions(reEnterpin).setVisible(true);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        } else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
