
package producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class insertar 
{
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Connect acceso = new Connect(); //objeto de la clase Conexion
    
    //Insert a la BD (agregar)
    public void insert(int codigo, String nombre, int cantidad, String fabricacion, String fecha) 
    {
        String sql = "insert into productos (codigo, nombre, cantidad, fabricacion, fecha) values (?, ?, ?, ?, ? ); "; //1era. FOrma

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, nombre);  
            ps.setInt(3, cantidad );
            ps.setString(4, fabricacion);
            ps.setString(5, fecha);
            ps.executeUpdate();
            System.out.println("\nProducto Ingresado Satisfactoriamente");
        } catch (Exception e) {
            System.out.println("\t Codigo ya existe, ingresar otro");
        }
    }

}
