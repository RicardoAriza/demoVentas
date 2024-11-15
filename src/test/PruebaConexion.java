
package test;

import conexion.ConMySql;
import java.sql.Connection;

public class PruebaConexion {
    public static void main(String[] args) {
        try {
            Connection cn =ConMySql.getInstance().getConnection();
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error"+ e);
        }
    }
}
