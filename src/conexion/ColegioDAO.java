
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ColegioDAO 
{
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion acceso = new Conexion(); //objeto de la clase Conexion
    
    //select
    public void listar() //Metodo listar
    {
        String sql = "select *from alumnos"; //comando a ejecutar
        try {
            //inicializa la base de datos
            con = acceso.Conectar();//mandar a llamar el método
            ps = con.prepareStatement(sql); //variable sql (select)
            rs = ps.executeQuery(); //ejecutar el Query
            
            while(rs.next()) //devuelve valor true, y va ir linea en linea (Todos los registros)
            {
                System.out.println("***************************");
                System.out.println("Codigo: " +rs.getInt(1)); //columna1
                System.out.println("Nombre: " +rs.getString(2)); //columna2
                System.out.println("Direccion: " +rs.getString(3)); //clumna3
                System.out.println("Telefono: " +rs.getInt(4)); //columna4
                
            }
        } catch (Exception e) {
            System.out.println(e);  
        }
    }
    
    
      //Insert a la BD (agregar)
    public void crear(int codigo, String nombre, String direccion, int telefono)
    {
        String sql = "insert into alumnos (codigo, nombre, direccion, telefono) values (?, ?, ?, ? ); "; //1era. FOrma
        
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setInt(4, telefono);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }      
    }
    
    //metodo update
    public void modificar(int codigo, String nombre, String direccion, int telefono)
    {
        String sql = "update alumnos set nombre = ?, direccion = ?, telefono = ? where codigo = ? ;";
        
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
               
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setInt(3, telefono);
            ps.setInt(4, codigo);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }      
    }
    
    //Elminar registros a la BD 
    public void eliminar(int codigo )
    {
         String sql = "delete from alumnos where codigo ="+codigo+";";
         
          try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }      
    }
    
    
    public static void main(String[] args) 
    {
        ColegioDAO cl = new ColegioDAO(); //objeto
        cl.crear(4, "Rosita", "Ciudad Guatemala", 56985478); //insert
        cl.listar(); //select
        System.out.println("\n/////////////////// Informacion Actualizado ////////////////////////");
        cl.modificar(2, "Maria Fernanda", "Quetzaltenango", 48965785);
        cl.listar(); //select
        System.out.println("\n/////////////////// Informacion Eliminada ////////////////////////");
        cl.eliminar(4);
        cl.listar();//select
    }  
}
