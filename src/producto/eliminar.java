
package producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rib
 */
public class eliminar 
{
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Connect acceso = new Connect(); //objeto de la clase Conexion
        //Elminar registros a la BD 
    
    public void eliminar(int codigo )
    {
         String sql = "delete from productos where codigo ="+codigo+";";
         
          try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }      
    }
    
}
