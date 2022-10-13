
package producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class actualizar
{
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Connect acceso = new Connect(); //objeto de la clase Conexion
    
     //metodo update
    public void update(int codigo, String nombre, int cantidad, String fabricacion, String fecha)
    {
        String sql = "update productos set nombre = ?, cantidad = ?, fabricacion = ?, fecha = ? where codigo = ? ;";
        
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            System.out.println("----------------------------------------");   
            ps.setString(1, nombre);
            ps.setInt(2, cantidad);
            ps.setString(3, fabricacion);
            ps.setString(4, fecha);
             ps.setInt(5, codigo);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }      
    }
    
}
