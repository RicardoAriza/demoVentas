
package dao;

import conexion.ConMySql;
import interfaz.VentasInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.ProductoTO;

public class ProductoDAO implements VentasInterface<ProductoTO>{

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String nombre="%" + objObject + "%";
        String sql="select * from vproducto where nombprod like ?";
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1,nombre);
        ResultSet rs=ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(ProductoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_insert_producto(?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setString(1, objObjeto.getNombprod());
        cs.setDouble(2, objObjeto.getPrecprod());
        cs.setString(3, objObjeto.getObsvprod());
        cs.execute();
    }

    @Override
    public void update(ProductoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_update_producto(?,?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdproducto());
        cs.setString(2, objObjeto.getNombprod());
        cs.setDouble(3, objObjeto.getPrecprod());
        cs.setString(4, objObjeto.getObsvprod());
        cs.execute();
    }

    @Override
    public void delete(ProductoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_delete_producto(?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdproducto());
        cs.execute();
    }
    
}
