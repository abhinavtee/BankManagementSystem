package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

    JLabel l1, type, cardNo, number, pnumber, pin, cardDetails, pinDetails, services;
    JRadioButton savingsAccount, fdAccount, currentAccount, rdAccount;
    JCheckBox atmCheck, netBankingCheck, mBanking, emailCheck, checkbookCheck, estatementCheck, declarationtCheck;
    JButton submit, cancel;
    String formno;

    public Signup3(String formno) {
        this.formno=formno;
        setLayout(null);
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        savingsAccount = new JRadioButton("Saving Account");
        savingsAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingsAccount.setBackground(Color.WHITE);
        savingsAccount.setBounds(100, 180, 150, 20);
        add(savingsAccount);

        fdAccount = new JRadioButton("Fixed Deposit Account");
        fdAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        fdAccount.setBackground(Color.WHITE);
        fdAccount.setBounds(350, 180, 250, 20);
        add(fdAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setBounds(100, 220, 150, 20);
        add(currentAccount);

        rdAccount = new JRadioButton("Reccuring Deposit Account");
        rdAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        rdAccount.setBackground(Color.WHITE);
        rdAccount.setBounds(350, 220, 250, 20);
        add(rdAccount);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(savingsAccount);
        groupAccount.add(fdAccount);
        groupAccount.add(currentAccount);
        groupAccount.add(rdAccount);

        cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNo.setBounds(100, 300, 200, 30);
        add(cardNo);

        number = new JLabel("XXXX - XXXX - XXXX - 4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100, 330, 300, 20);
        add(cardDetails);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        pinDetails = new JLabel("Your 4 Digit Pin");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100, 400, 300, 20);
        add(pinDetails);

        services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 400, 30);
        add(services);

        atmCheck = new JCheckBox("ATM CARD");
        atmCheck.setBackground(Color.WHITE);
        atmCheck.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCheck.setBounds(100, 550, 200, 30);
        add(atmCheck);

        netBankingCheck = new JCheckBox("Internet Banking");
        netBankingCheck.setBackground(Color.WHITE);
        netBankingCheck.setFont(new Font("Raleway", Font.BOLD, 16));
        netBankingCheck.setBounds(350, 500, 200, 30);
        add(netBankingCheck);

        mBanking = new JCheckBox("Mobile Banking");
        mBanking.setBackground(Color.WHITE);
        mBanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mBanking.setBounds(100, 500, 200, 30);
        add(mBanking);

        atmCheck = new JCheckBox("ATM CARD");
        atmCheck.setBackground(Color.WHITE);
        atmCheck.setFont(new Font("Raleway", Font.BOLD, 16));
        atmCheck.setBounds(100, 500, 200, 30);
        add(atmCheck);

        emailCheck = new JCheckBox("Email & SMS Alerts");
        emailCheck.setBackground(Color.WHITE);
        emailCheck.setFont(new Font("Raleway", Font.BOLD, 16));
        emailCheck.setBounds(350, 550, 200, 30);
        add(emailCheck);

        checkbookCheck = new JCheckBox("Cheque Book");
        checkbookCheck.setBackground(Color.WHITE);
        checkbookCheck.setFont(new Font("Raleway", Font.BOLD, 16));
        checkbookCheck.setBounds(100, 600, 200, 30);
        add(checkbookCheck);

        estatementCheck = new JCheckBox("E-statement");
        estatementCheck.setBackground(Color.WHITE);
        estatementCheck.setFont(new Font("Raleway", Font.BOLD, 16));
        estatementCheck.setBounds(350, 600, 200, 30);
        add(estatementCheck);

        declarationtCheck = new JCheckBox("I hereby declares that the above details are correct to the best of my knowledge");
        declarationtCheck.setBackground(Color.WHITE);
        declarationtCheck.setFont(new Font("Raleway", Font.BOLD, 12));
        declarationtCheck.setBounds(100, 680, 600, 30);
        add(declarationtCheck);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;

            if (savingsAccount.isSelected()) {
                accountType = "Savings Account";
            } else if (fdAccount.isSelected()) {
                accountType = "Fixed Deposit";
            } else if (currentAccount.isSelected()) {
                accountType = "Current Acount";
            } else if (currentAccount.isSelected()) {
                accountType = "Reccuring Deposit";
            }

            Random random = new Random();
            String cardNo = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinNo = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (atmCheck.isSelected()) {
                facility = facility + "ATM Card";
            } else if (netBankingCheck.isSelected()) {
                facility = facility + "Internet Banking";

            } else if (mBanking.isSelected()) {
                facility = facility + "Mobile Banking";

            } else if (emailCheck.isSelected()) {
                facility = facility + "Email & SMS Alerts";

            } else if (checkbookCheck.isSelected()) {
                facility = facility + "Cheque Book";

            } else if (estatementCheck.isSelected()) {
                facility = facility + "E-Statement";

            }
          try {
              if (accountType.equals("")) {
                  JOptionPane.showMessageDialog(null, "Account Type is Required");
              } else {
                  Conn cn= new Conn();
                  String query1="insert into signup3 values('"+formno+"','"+accountType+"','"+cardNo+"','"+pinNo+"','"+facility+"')";
                  String query2="insert into login values('"+formno+"','"+cardNo+"','"+pinNo+"')";
                  cn.s.executeUpdate(query1);
                  cn.s.executeUpdate(query2);
                  JOptionPane.showMessageDialog(null, "Card Number: "+cardNo+ "\n Pin: "+ pinNo);
              
                  setVisible(false);
                  new Deposit(pinNo).setVisible(true);
              }
          } catch(Exception ex){
              System.out.println(ex);
          }
          
          
        } else if (ae.getSource() == cancel) {
          setVisible(false);
          new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }

}
