package bank.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup2 extends JFrame implements ActionListener {

    String formno;
    JLabel incomeLabel, additionalDetail, religionLabel, educationLabel, categoryLabel, occupationLabel, panLabel, aadharLabel, sCitizenLabel, eLabel;
    JTextField aadharTextField, panTextField;
    JButton next;
    JRadioButton eyes, eno, sno, syes;
    ButtonGroup sCitizen, eAccount;
    JComboBox religionComboBox, ocupationComboBox, incomeComboBox, educationComboBox, categoryComboBox;

    public Signup2(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetail.setBounds(290, 80, 400, 30);
        add(additionalDetail);

        religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 100, 30);
        add(religionLabel);

        String valReligion[] = {"Select", "Hindu", "Muslim", "Sikh", "Chritian", "Other"};
        religionComboBox = new JComboBox(valReligion);
        religionComboBox.setBounds(300, 140, 400, 30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);

        categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 200, 30);
        add(categoryLabel);

        String valCategory[] = {"Select", "General", "OBC", "SC", "ST", "Other"};
        categoryComboBox = new JComboBox(valCategory);
        categoryComboBox.setBounds(300, 190, 400, 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String incomeCategory[] = {"Select", "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeComboBox = new JComboBox(incomeCategory);
        incomeComboBox.setBounds(300, 240, 400, 30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        educationLabel = new JLabel("Educational:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 200, 30);
        add(educationLabel);

        String[] educationalValues = {"Select", "Non Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        educationComboBox = new JComboBox(educationalValues);
        educationComboBox.setBounds(300, 315, 400, 30);
        educationComboBox.setBackground(Color.WHITE);
        add(educationComboBox);

        occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 390, 200, 30);
        add(occupationLabel);

        String ocupationValues[] = {"Select", "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
        ocupationComboBox = new JComboBox(ocupationValues);
        ocupationComboBox.setBounds(300, 390, 400, 30);
        ocupationComboBox.setBackground(Color.WHITE);
        add(ocupationComboBox);

        panLabel = new JLabel("Pan Number:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 440, 200, 30);
        add(panLabel);

        panTextField = new JTextField("Enter Pan Number");
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        aadharLabel = new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharLabel.setBounds(100, 490, 200, 30);
        add(aadharLabel);

        aadharTextField = new JTextField("Enter your Aadhar Number");
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        sCitizenLabel = new JLabel("Senior Citizen:");
        sCitizenLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        sCitizenLabel.setBounds(100, 540, 200, 30);
        add(sCitizenLabel);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        sCitizen = new ButtonGroup();
        sCitizen.add(syes);
        sCitizen.add(sno);

        eLabel = new JLabel("Existing Account:");
        eLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        eLabel.setBounds(100, 590, 200, 30);
        add(eLabel);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        eAccount = new ButtonGroup();
        eAccount.add(eyes);
        eAccount.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sReligion = (String) religionComboBox.getSelectedItem();
        String sCategory = (String) categoryComboBox.getSelectedItem();
        String sIncome = (String) incomeComboBox.getSelectedItem();
        String sEducation = (String) educationComboBox.getSelectedItem();
        String sOcupation = (String) ocupationComboBox.getSelectedItem();
        String sCitizen = "null";
        String sEAccount = "null";
        String panNo = panTextField.getText();
        String aadharNo = aadharTextField.getText();

        if (syes.isSelected()) {
            sCitizen = "yes";
        } else if (sno.isSelected()) {
            sCitizen = "no";
        }

        if (eyes.isSelected()) {
            sEAccount = "Yes";
        } else if (eno.isSelected()) {
            sEAccount = "No";
        }

        try {
            if (sIncome.equals("Select")) {
                JOptionPane.showMessageDialog(null, "Income selection is required. Please select your income. ");
            } else {
                Conn cn = new Conn();
                String query = "insert into signup2 values('" + formno + "','" + sReligion + "','" + sCategory + "','" + sIncome + "','" + sEducation + "','" + sOcupation + "','" + panNo + "','" + aadharNo + "','" + sCitizen + "','" + sEAccount + "')";
                cn.s.executeUpdate(query);
                
                setVisible(false);
                new Signup3(formno).setVisible(true);
                
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }

}
