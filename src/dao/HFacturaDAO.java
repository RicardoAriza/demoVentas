
package dao;

import conexion.ConMySql;
import interfaz.VentasInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.FacturaTO;

public class HFacturaDAO{
        
    public ResultSet buscarHfactura()throws Exception{
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="select * from v_auditoria_factura";
        PreparedStatement ps=cn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        return rs;
    }
    public ResultSet buscarHFfactura(Date fecha1,Date fecha2)throws Exception{        
        Connection cn=ConMySql.getInstance().getConnection();
        String fech1=fecha1 + " 00:00:00";
        String fech2=fecha2 + " 23:59:59";        
        String sql="select * from v_auditoria_factura where fechfact BETWEEN ? AND ?";
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1,fech1);
        ps.setString(2,fech2);
        ResultSet rs=ps.executeQuery();
        return rs;
    }}
