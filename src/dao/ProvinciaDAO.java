package dao;

import conexion.ConMySql;
import interfaz.VentasInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.ProvinciaTO;

public class ProvinciaDAO implements VentasInterface<ProvinciaTO>{

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn = ConMySql.getInstance().getConnection();
        String nombre = "%" + objObject + "%";
        String sql = "SELECT * FROM vprovincia WHERE nombprov like ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(ProvinciaTO objObjeto) throws Exception {
        Connection cn = ConMySql.getInstance().getConnection();
        String sql = "call sp_insert_provincia(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setString(1, objObjeto.getNombprov());
        cs.execute();
    }

    @Override
    public void update(ProvinciaTO objObjeto) throws Exception {
        Connection cn = ConMySql.getInstance().getConnection();
        String sql = "call sp_update_provincia(?,?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdprovincia());
        cs.setString(2, objObjeto.getNombprov());
        cs.execute();
    }

    @Override
    public void delete(ProvinciaTO objObjeto) throws Exception {
        Connection cn = ConMySql.getInstance().getConnection();
        String sql = "call sp_delete_provincia(?);";
        CallableStatement cs = cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdprovincia());
        cs.execute();
    }
    
}
