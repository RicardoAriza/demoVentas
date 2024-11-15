
package dao;

import conexion.ConMySql;
import interfaz.VentasInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.DetalleFacturaTO;

public class DetalleFacturaDAO implements VentasInterface<DetalleFacturaTO>{

    
    
    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(DetalleFacturaTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_insert_detallefactura(?,?,?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdfactura());
        cs.setInt(2, objObjeto.getIdproducto());
        cs.setDouble(3, objObjeto.getPrecio());
        cs.setInt(4, objObjeto.getCantidad());
        cs.setDouble(5, objObjeto.getImporte());
        cs.execute();
    }

    @Override
    public void update(DetalleFacturaTO objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DetalleFacturaTO objObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
