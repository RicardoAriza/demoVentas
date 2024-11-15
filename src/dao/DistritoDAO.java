
package dao;

import to.DistritoTO;
import conexion.ConMySql;
import interfaz.VentasInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DistritoDAO implements VentasInterface<DistritoTO>{

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String nombre="%" + objObject + "%";
        String sql="select * from vdistrito where nombdist like ?";
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1,nombre);
        ResultSet rs=ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(DistritoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_insert_distrito(?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setString(1, objObjeto.getNombdist());
        cs.setString(2, objObjeto.getObsvdist());
        cs.execute();
    }

    @Override
    public void update(DistritoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_update_distrito(?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIddistrito());
        cs.setString(2, objObjeto.getNombdist());
        cs.setString(3, objObjeto.getObsvdist());
        cs.execute();
    }

    @Override
    public void delete(DistritoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_delete_distrito(?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIddistrito());
        cs.execute();
    }
    
}
