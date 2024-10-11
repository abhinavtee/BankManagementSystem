package bank.management.system;

import java.sql.*;

public class Conn {

    Connection cn;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Abhi@1999");
            s = cn.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
