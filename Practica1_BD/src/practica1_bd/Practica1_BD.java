/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_bd;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 *
 * @author AcerV3
 */
public class Practica1_BD {
 private ResultSet rs = null;
    private Connection conecc;
    private Statement st = null;
    public static ResultSet resultUser;
    int cont=0;
    Random r = new Random();
    double time_start, time_end;
    


    public static void main(String[] args) {
        Practica1_BD pbd= new Practica1_BD();
       pbd.insertarDatosPuro();
    }
    
    private void insertarDatosPuro(){
        Connection conn=null;
        Statement st;
        try {
                Class.forName("com.mysql.jdbc.Driver"); //Comprobar el conector    org.gjt.mm.mysql.Driver
        } catch (ClassNotFoundException ex) {
              System.out.println("Error");
        }
        try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipojj?useSSL=false", "root","root");
        } catch (SQLException ex) {
              System.out.println("Error");
        }
        try {
            st=conn.createStatement();
            String nombre="";
            time_start = System.currentTimeMillis();
            for (int x=0; x<100000; x++){
               // nombre= "ciudad"+x;
                nombre="alumno"+x;
                Boolean resultado=false;
                cont = r.nextInt(100+1);
              //  resultado = st.execute("DELETE  from ciudad where idCiudad='"+x+"'");
               // resultado = st.execute("DELETE  from alumno where idAlumno='"+x+"'");
               // resultado = st.execute("INSERT INTO ciudad(idCiudad, Nombre) VALUES('"+x+"','"+nombre+"');");
                resultado = st.execute("INSERT INTO alumno(idAlumno, Nombre,idCiudad) VALUES('"+x+"','"+nombre+"','"+cont+"');");
                
            }
            time_end = System.currentTimeMillis();
            System.out.println( ( time_end - time_start )/1000 +" Segundos");
        //   
            
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }
    
 
    
    
}
