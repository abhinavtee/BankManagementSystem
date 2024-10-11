package bank.management.system;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{
    
    JButton withdrawl,deposit,fastcash,miniStatement,pinChange,balanceEnquiry,exit;
    String pinNumber;
    
    public Transactions(String pinnumber){
        
         this.pinNumber=pinnumber;
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0, 0, 900, 865);
        add(image);
        
        JLabel text= new JLabel("Please select your Transaction");
        text.setBounds(235,265,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,397,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,397,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,432,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        miniStatement=new JButton("Mini Statement");
        miniStatement.setBounds(355,432,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange=new JButton("Pin Change");
        pinChange.setBounds(170,468,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,468,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit=new JButton("Exit");
        exit.setBounds(355,502,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==exit){
            System.exit(0);
        } else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if (ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
            
        }else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource()==balanceEnquiry){
            setVisible(true);
            new BalanceEnquiry(pinNumber).setVisible(true);
         } else if (ae.getSource()==miniStatement){
             new MiniStatement(pinNumber).setVisible(true);
         }
       }
    public static void main(String[] args) {
        new Transactions("");
    }
    
}
