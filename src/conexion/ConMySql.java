package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConMySql {

    static ConMySql instance = null;
    Connection connection = null;

    public ConMySql() throws Exception {
        String url = "jdbc:mysql://localhost:3306/ventas2024";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, "root", "");
    }
    public ConMySql(String ip) throws Exception {
        try {
            String url = "jdbc:mysql://" + ip + ":3306/replica";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "kike", "12345678");
        } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException cex) {
            try {
                String url = "jdbc:mysql://localhost:3306/replica";
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, "root", "");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public static ConMySql getInstance() throws Exception {
        if (instance == null) {
            instance = new ConMySql();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        connection = null;
        super.finalize();
    }
}
