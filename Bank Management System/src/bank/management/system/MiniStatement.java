
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    JLabel text,bank,miniStatement,card,balance;
    String pinNumber;
    
    public MiniStatement(String pinNumber){
        
        this.pinNumber=pinNumber;
        
        setTitle("Mini-Statement");
        setLayout(null);
        
        miniStatement=new JLabel();
        miniStatement.setBounds(20,140,400,200);
        add(miniStatement);
        
        
        text=new JLabel();
        add(text);
        
        bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn cn=new Conn();
            ResultSet result=cn.s.executeQuery("select * from login where pinNo = '"+pinNumber+"'");
            while(result.next()){
                card.setText("Card Number: "+result.getString("cardNo").substring(0, 4)+"XXXXXXXX"+result.getString("cardNo").substring(12));
            }
            
        } catch (Exception ex){
            System.out.println(ex);
        }
        try {
            
            Conn cn=new Conn();
            int bal = 0;
            ResultSet result=cn.s.executeQuery("select * from bank where pinNo = '"+pinNumber+"'");
            while(result.next()){
                miniStatement.setText(miniStatement.getText() + "<html>"+ result.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + result.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +result.getString("amount")+"<br><br>" );
            
            if (result.getString("type").equals("Deposit")) {
                        bal += Integer.parseInt(result.getString("amount"));
                    } else {
                        bal -= Integer.parseInt(result.getString("amount"));
                    }
            balance.setText("Your Current Account Balance is Rs "+bal);
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
            
    public static void main(String[] args) {
      new MiniStatement("");   
    }
    
}
