
package conexion;

//Librerias para la conexion
import java.sql.DriverManager;
import java.sql.Connection;


public class Conexion 
{
    //Datos de conexion
    Connection con;
    String url = "jdbc:mysql://localhost:3306/colegio"; //datos de mysql
    String user = "root";
    String pass = "";

    //metodo para la conexion
    public Connection Conectar() 
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
  
    
    
    
    //test para probar la ejecion debe de devolver: com.mysql.cj.jdbc.ConnectionImpl@305fd85d
    public static void main(String[] args) 
    {
        Conexion sp = new Conexion();
            System.out.println(sp.Conectar());
    }
    
}
