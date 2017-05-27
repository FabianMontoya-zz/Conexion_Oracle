
package ConexionOracle;

import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

public class InsertarOracle extends JFrame implements ActionListener {   
    
    String Nombre,Contraseña,Codigo;
    JLabel LMensaje,LNombre,LContraseña,LCodigo;
    JTextField TNombre, TContraseña, TCodigo;
    JButton Insertar, Finalizar;
    
    Connection conn = null;
    OraclePreparedStatement pst = null;
    OracleResultSet rs = null;
    
    public InsertarOracle(){
        super("Insertar Datos");
        setLayout(null);
        Etiquetas();
        CajasTexto();
        Botones();
        
    }
    
    public void Etiquetas(){
        LMensaje=new JLabel("INSERCION DE DATOS");
        LMensaje.setBounds(50,20,300,20);
        add(LMensaje);        
        LNombre=new JLabel("Nombre: ");
        LNombre.setBounds(10,50,100,20);
        add(LNombre);
        LContraseña=new JLabel("Contraseña: ");
        LContraseña.setBounds(10,80,100,20);
        add(LContraseña);
        LCodigo=new JLabel("Codigo: ");
        LCodigo.setBounds(10,110,100,20);
        add(LCodigo);
    }
    public void CajasTexto(){
        TNombre=new JTextField();
        TNombre.setBounds(120,50,100,20);
        add(TNombre);
        TContraseña=new JTextField();
        TContraseña.setBounds(120,80,100,20);
        add(TContraseña);
        TCodigo=new JTextField();
        TCodigo.setBounds(120,110,100,20);
        add(TCodigo);
    }
    public void Botones(){
        Insertar=new JButton("Insertar");
        Insertar.setBounds(10,140,100,20);
        Insertar.addActionListener(this);
        add(Insertar);
        Finalizar=new JButton("Finalizar");
        Finalizar.setBounds(120,140,100,20);
        Finalizar.addActionListener(this);
        add(Finalizar);
        
    }
    
    public void conexion(String Nombre,String Contraseña, String Codigo) {
        conn =ConexionOracle.ConnectDB();
        System.out.println("=======\nUSUARIO: "+ Nombre);
        System.out.println("PASSWORD: "+Contraseña);
        System.out.println("CODIGO: "+Codigo+"\n=========");
        try {
           String sql = "INSERT INTO ACCESO (usuario, clave, codigo) VALUES (?, ?, ?)";
           System.out.println("=======\nYA\n=======");
           pst = (OraclePreparedStatement) conn.prepareStatement(sql);
           pst.setString(1, Nombre);
           pst.setString(2, Contraseña);
           pst.setString(3, Codigo);
                
           System.out.println("USUARIO: "+ Nombre);
           System.out.println("PASSWORD: "+Contraseña);
           System.out.println("CODIGO: "+Codigo);
           
           rs = (OracleResultSet)pst.executeQuery();
           
           System.out.println("=======\nYA\n=======");
           
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==Insertar){
           Nombre=TNombre.getText();
           Contraseña=TContraseña.getText();
           Codigo=TCodigo.getText();
           
           conexion(Nombre,Contraseña,Codigo);
       }
       if(e.getSource()==Finalizar){
           System.exit(0);
       }
    }
    
public static void main(String args[]) {
        JFrame aplicacion = new InsertarOracle();
        aplicacion.setSize(500, 500);
        aplicacion.setVisible(true);
        aplicacion.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    
}
