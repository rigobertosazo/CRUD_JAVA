
package producto;

import java.util.Scanner;

public class principal 
{

    public static void main(String[] args) 
    {
      Scanner in = new Scanner(System.in);
      in.useDelimiter("\n"); //limitamos para poder usar espacios (frases) en string
      int opcion, codigo, cantidad;
      String nombre, fabricacion, fecha;

        System.out.println();
        System.out.println();   

        EXTERNAL:
        while(true)
        {
            System.out.println();           
            System.out.println("=============================================== ");
            System.out.println(" ******  SISTEMA TIENDITA POLLO VERDE *******");
            System.out.println("=============================================== ");
            System.out.println("  \t Consultar  Productos  (Digite: 1) ");
            System.out.println("  \t Ingresar   Producto   (Digite: 2) ");
            System.out.println("  \t Actualizar Producto   (Digite: 3) ");
            System.out.println("  \t Eliminar   Producto   (Digite: 4) ");
            System.out.println("  \t Salir del sistema     (Digite: 5) ");
            System.out.println();
            System.out.print("    \t Ingrese aqui: ");
            opcion = in.nextInt(); 
            consulta cl = new consulta(); //objeto de la clase consulta
            insertar c2 = new insertar(); //objeto de la clase insertar
            actualizar c3 = new actualizar(); //objeto de la clase actualizar
            eliminar c4 = new eliminar(); //objeto de la clase eliminar
            
                switch (opcion) 
                {
                    case 1 ->
                    {
                        //select
                        System.out.println("-----------------------------------------------");
                        System.out.println(" \t \t Consulta de Producto ");
                        cl.select();
                    }
                    case 2 -> {
                        //insert  
                        boolean salir = true;
                        do{
                            System.out.println("-----------------------------------------------");
                            System.out.println(" \t \t Insertar Producto ");
                            System.out.println("-----------------------------------------------");
                            System.out.print("Ingrese Codigo del producto: ");
                            codigo = in.nextInt();
                            System.out.print("Ingrese Nombre del producto: ");
                            nombre = in.next();
                            System.out.print("Ingrese Cantidad del producto: ");
                            cantidad = in.nextInt();
                            System.out.print("Ingrese Lugar de Fabricacion: ");
                            fabricacion = in.next();
                            System.out.print("Ingrese Fecha del producto anio-mes-dia (0000-00-00): ");
                            fecha = in.next();

                            c2.insert(codigo, nombre, cantidad, fabricacion, fecha);
                            System.out.print("Desea ingresar otro producto? (1 = SI ) ( 0 = NO ) : ");
                            int resp = in.nextInt();
                            if(resp == 0){
                                salir = false;
                            }
                        }while(salir);
                        //cl.select();      
                    }
                    case 3 -> 
                    { 
                           //Actualizar
                        boolean salir = true;
                        do{
                            cl.select();  
                            System.out.println("-----------------------------------------------");
                            System.out.println(" \t \t Actualizar Producto ");
                            System.out.println("-----------------------------------------------");
                            System.out.print("Ingrese Codigo del producto a modificar: ");
                            codigo = in.nextInt();
                            System.out.print("Ingrese Nuevo Nombre del producto: ");
                            nombre = in.next();
                            System.out.print("Ingrese Nueva Cantidad del producto: ");
                            cantidad = in.nextInt();
                            System.out.print("Ingrese Nuevo Lugar de Fabricacion: ");
                            fabricacion = in.next();
                            System.out.print("Ingrese Nueva Fecha del producto anio-mes-dia (0000-00-00): ");
                            fecha = in.next();

                            c3.update(codigo, nombre, cantidad, fabricacion, fecha);
                            System.out.println("\n---------Informacion Actualizada Satisfactoriamente---------");
                             System.out.print("Desea Actualizar otro producto? (1 = SI ) ( 0 = NO ) : ");
                             int resp = in.nextInt();
                             if(resp == 0){
                             salir = false;
                             }
                        }while(salir);
                    }
                    case 4 -> 
                    {  
                        //eliminar
                          boolean salir = true;
                        do{
                                cl.select();
                                System.out.println("");
                                System.out.println("-----------------------------------------------");
                                System.out.println(" \t \t Elminar Producto ");
                                System.out.println("-----------------------------------------------");
                                System.out.print("Ingrese Codigo del producto que desea eliminar: ");
                                codigo = in.nextInt();

                                c4.eliminar(codigo);//eliminar codigo 4
                                System.out.println("\n---------Registro Eliminado Satisfactoriamente---------");
                                System.out.print("Desea Eliminar otro producto? (1 = SI ) ( 0 = NO ) : ");
                                 int resp = in.nextInt();
                                 if(resp == 0){
                                 salir = false;
                                }
                            }while(salir);

                    }
                    case 5 -> {
                        //salida del sistema
                     System.out.println("\t OK, ud salio del sistema...");
                               System.out.println();
                               System.out.println();
                               break EXTERNAL;
                    }
                    default -> {System.out.println("\t Opcion no valida");}
                } //fin switch
        }//fin while
        
        
        
        
 
        
        
         
         
         
        
    }
    
}
