
package dao;

import to.EmpleadoTO;
import conexion.ConMySql;
import interfaz.VentasInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpleadoDAO implements VentasInterface<EmpleadoTO>{

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String nombre="%" + objObject + "%";
        String sql="select * from vempleado where apatempl like ?";
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1,nombre);
        ResultSet rs=ps.executeQuery();
        return rs;
    }
      
    @Override
    public void insert(EmpleadoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_insert_empleado(?,?,?,?,?,?,?,?,?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setString(1, objObjeto.getNombempl());
        cs.setString(2, objObjeto.getApatempl());
        cs.setString(3, objObjeto.getAmatempl());
        cs.setString(4, objObjeto.getSexoempl());
        cs.setString(5, objObjeto.getDireempl());
        cs.setInt(6, objObjeto.getIddistrito());
        cs.setInt(7, objObjeto.getIdprovincia());
        cs.setInt(8, objObjeto.getTelfempl());
        cs.setInt(9, objObjeto.getCeluempl());
        cs.setString(10, objObjeto.getEmaiempl());
        cs.setString(11, objObjeto.getObsvempl());
        cs.execute();
    }

    @Override
    public void update(EmpleadoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_update_empleado(?,?,?,?,?,?,?,?,?,?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdempleado());
        cs.setString(2, objObjeto.getNombempl());
        cs.setString(3, objObjeto.getApatempl());
        cs.setString(4, objObjeto.getAmatempl());
        cs.setString(5, objObjeto.getSexoempl());
        cs.setString(6, objObjeto.getDireempl());
        cs.setInt(7, objObjeto.getIddistrito());
        cs.setInt(8, objObjeto.getIdprovincia());
        cs.setInt(9, objObjeto.getTelfempl());
        cs.setInt(10, objObjeto.getCeluempl());
        cs.setString(11, objObjeto.getEmaiempl());
        cs.setString(12, objObjeto.getObsvempl());
        cs.execute();
    }

    @Override
    public void delete(EmpleadoTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_delete_empleado(?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdempleado());
        cs.execute();
    }
    
}
