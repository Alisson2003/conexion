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
                String password = "1234";

                try {
                    Connection conn = DriverManager.getConnection(url, username, password);
                    System.out.println("Conexión exitosa a la base de datos.");
                    JFrame frame = new JFrame("Bienvenida");
                    frame.setContentPane(new Formulario().mainPanel2);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(800,600);
                    frame.setPreferredSize(new Dimension(800, 600));
                    frame.pack();
                    frame.setVisible(true);

                } catch (SQLException e) {
                    System.out.println("Error al conectar: " + e.getMessage());
                }
            }
        });
    }
}
