import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login {
    public Container login;
    public JPanel mainPanel;
    private JTextField user;
    private JPasswordField passwor;
    private JButton ingresarButton;

    public login() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024A";
                String username = "root";
                String password = "123456";

                try{
                    String usuario = user.getText();
                    String pass = passwor.getText();
                    Connection con = DriverManager.getConnection(url, username, password);
                    System.out.println("Conectado con exito a la base de datos");
                    Statement stmt = con.createStatement();
                    //String query = "SELECT * FROM estudiantes where cedula = "+ usuario ;
                    String query = "SELECT * FROM estudiantes where cedula = "+ pass + usuario;


                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                        System.out.println(rs.getString("cedula"));
                        System.out.println(rs.getString("nombre"));
                        System.out.println(rs.getString("b1"));
                        System.out.println(rs.getString("b2"));
                    }
                    con.close();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
