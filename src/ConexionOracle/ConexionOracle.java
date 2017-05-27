package ConexionOracle;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class ConexionOracle {
    
        public static Connection ConnectDB(){
     try{
         
         Class.forName("oracle.jdbc.OracleDriver");
         Connection con= DriverManager.getConnection("jdbc:oracle:thin:@10.17.28.83:1521:ZEUS", "usuario7", "usuario7"); //IP:Nombre Base de Datos, Usuario, Contraseña
         return con;   
     } catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
     }  
     return null;
    }
    
}
