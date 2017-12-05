package BaseDeDatos;

import java.sql.*;
import javax.swing.JOptionPane;
  
///clase que conecta con la base de datos potigianBase en MySQL
public class ConexionMySQL {
    //variableq que guarda los datos de conexion
    public String db="potigianbase";
    public String URL="jdbc:mysql://localhost/"+db;
    public String user= "root";
    public String pass="";

public ConexionMySQL()
{

}
    //clase para Conectar a la base de datos con url guardada en variable
   //Devuelve objeto del tipo Connection
    public Connection Conectar(){
       
        Connection link= null;
        try
        {
            //cargamos el driver mysql que permite conectarse
            Class.forName("org.gjt.mm.mysql.Driver");
            
            //enlace hacia la base de datos
            link= DriverManager.getConnection(this.URL, this.user,this.pass);
            System.out.println("conectado correctamente");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, pass);
        
        }
    return link;
    }

}   

