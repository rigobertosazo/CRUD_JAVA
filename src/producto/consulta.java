
package producto;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class consulta 
{
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Connect acceso = new Connect(); //objeto de la clase Conexion
    
    //select
    public void select() //Metodo listar
    {
        String sql = "select *from productos"; //comando a ejecutar
        try {
            //inicializa la base de datos
            con = acceso.Conectar();//mandar a llamar el método
            ps = con.prepareStatement(sql); //variable sql (select)
            rs = ps.executeQuery(); //ejecutar el Query
            
            while(rs.next()) //devuelve valor true, y va ir linea en linea (Todos los registros)
            {
                System.out.println("-----------------------------------------------");
                System.out.println("Codigo: " +rs.getInt(1)); //columna1
                System.out.println("Nombre: " +rs.getString(2)); //columna2
                System.out.println("Cantidad: " +rs.getInt(3)); //clumna3
                System.out.println("Fabricacion: " +rs.getString(4)); //columna4
                System.out.println("Fecha: " +rs.getString(5)); //columna4
                
            }
        } catch (Exception e) {
            System.out.println(e);  
        }
    }
    
}
