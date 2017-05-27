package ConexionOracle;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

public class ControlAcceso extends JFrame implements ActionListener {

    JButton Ingresar;
    JLabel Lusuario, Lpassword;
    JTextField Tusuario;
    JPasswordField Tpassword;
    Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
    
    String usuario, contra;

    ControlAcceso() {
        setLayout(null);

        Tusuario = new JTextField();
        Tusuario.setBounds(120, 10, 100, 20);

        Tpassword = new JPasswordField();
        Tpassword.setBounds(120, 40, 100, 20);

        Lusuario = new JLabel("Usuario");
        Lusuario.setBounds(10, 10, 100, 20);

        Lpassword = new JLabel("Password");
        Lpassword.setBounds(10, 40, 100, 20);

        Ingresar = new JButton("Ingresar");
        Ingresar.setBounds(10, 70, 100, 20);
        Ingresar.addActionListener(this);
        add(Lusuario);
        add(Lpassword);
        add(Tusuario);
        add(Tpassword);
        add(Ingresar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Ingresar) {
            conn = ConexionOracle.ConnectDB();
            try {
                String sql = "select * from ACCESO where usuario=? and clave=?";
                
                pst = (OraclePreparedStatement) conn.prepareStatement(sql);
                pst.setString(1, Tusuario.getText());
                pst.setString(2, Tpassword.getText());
                
                usuario=Tusuario.getText();
                contra=Tpassword.getText();
                System.out.println("USUARIO: "+ usuario);
                System.out.println("PASSWORD: "+contra);
                
                rs = (OracleResultSet) pst.executeQuery();
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Usuario correcto");
                    AplicacionNueva c = new AplicacionNueva();
                    c.setLocation(200, 200);
                    c.setSize(500,500);
                    c.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario incorrecto");

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public static void main(String args[]) {
        JFrame aplicacion = new ControlAcceso();
        aplicacion.setSize(500, 500);
        aplicacion.setVisible(true);
        aplicacion.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
