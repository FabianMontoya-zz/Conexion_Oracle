package ConexionOracle;

import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

public class BorrarOracle extends JFrame implements ActionListener{
    
    public BorrarOracle(){
        super("Borrar Datos");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String args[]) {
        JFrame aplicacion = new InsertarOracle();
        aplicacion.setSize(500, 500);
        aplicacion.setVisible(true);
        aplicacion.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    

}
   
