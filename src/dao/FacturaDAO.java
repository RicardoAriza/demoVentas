
package dao;

import conexion.ConMySql;
import interfaz.VentasInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.FacturaTO;

public class FacturaDAO implements VentasInterface<FacturaTO>{
    
    public int obtenerIdFactura() throws Exception{
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="select * from factura";
        PreparedStatement ps=cn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        rs.last();
        return rs.getInt(1);
    }
    
    @Override
    
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String nombre="%" + objObject + "%";
        String sql="select * from vfactura where nombprod like ?";
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1,nombre);
        ResultSet rs=ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(FacturaTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_insert_factura(?,?,?,?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdcliente());
        cs.setInt(2, objObjeto.getIdempleado());
        cs.setDouble(3, objObjeto.getStotfact());
        cs.setDouble(4, objObjeto.getIgvfact());
        cs.setDouble(5, objObjeto.getTotafact());
        cs.setString(6, objObjeto.getObsvfact());
        cs.execute();
    }

    @Override
    public void update(FacturaTO objObjeto) throws Exception {
        java.util.Date utilDate = new java.util.Date();
        long lnMilisegundos = utilDate.getTime();
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_update_producto(?,?,?,?,?,?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdfactura());
        cs.setTimestamp(2, sqlTimestamp);
        cs.setInt(3, objObjeto.getIdcliente());
        cs.setInt(4, objObjeto.getIdempleado());
        cs.setDouble(5, objObjeto.getStotfact());
        cs.setDouble(6, objObjeto.getIgvfact());
        cs.setDouble(7, objObjeto.getTotafact());
        cs.setString(8, objObjeto.getObsvfact());
        cs.execute();
    }

    @Override
    public void delete(FacturaTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_delete_producto(?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdfactura());
        cs.execute();
    }
    
}
