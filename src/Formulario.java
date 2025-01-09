import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Formulario {
    private JButton salirButton;
    public JPanel mainPanel2;
    private JTable table1;

    public Formulario() {
        String url = "jdbc:mysql://localhost:3306/estudiantes2024A";
        String username = "root";
        String password = "1234";
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("B1");
        model.addColumn("B2");
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM estudiantes";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            while(rs.next()){
                model.addRow(new Object[]{
                rs.getString("cedula"),
                rs.getString("nombre"),
                rs.getString("b1"),
                rs.getString("b2")
            });
        }

        table1.setModel(model);
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
