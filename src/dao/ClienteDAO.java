
package dao;

import to.ClienteTO;
import conexion.ConMySql;
import interfaz.VentasInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO implements VentasInterface<ClienteTO>{

    @Override
    public ResultSet buscar(Object objObject) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String nombre="%" + objObject + "%";
        String sql="select * from vcliente where nombclie like ?";
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1,nombre);
        ResultSet rs=ps.executeQuery();
        return rs;
    }

    @Override
    public void insert(ClienteTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_insert_cliente(?,?,?,?,?,?,?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setString(1, objObjeto.getRucclie());
        cs.setString(2, objObjeto.getNombclie());
        cs.setString(3, objObjeto.getDireclie());
        cs.setInt(4, objObjeto.getIddistrito());
        cs.setInt(5, objObjeto.getIdprovincia());
        cs.setInt(6, objObjeto.getTelfclie());
        cs.setInt(7, objObjeto.getCeluclie());
        cs.setString(8, objObjeto.getEmaiclie());
        cs.setString(9, objObjeto.getObsvclie());
        cs.execute();
    }

    @Override
    public void update(ClienteTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_update_cliente(?,?,?,?,?,?,?,?,?,?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdcliente());
        cs.setString(2, objObjeto.getRucclie());
        cs.setString(3, objObjeto.getNombclie());
        cs.setString(4, objObjeto.getDireclie());
        cs.setInt(5, objObjeto.getIddistrito());
        cs.setInt(6, objObjeto.getIdprovincia());
        cs.setInt(7, objObjeto.getTelfclie());
        cs.setInt(8, objObjeto.getCeluclie());
        cs.setString(9, objObjeto.getEmaiclie());
        cs.setString(10, objObjeto.getObsvclie());
        cs.execute();
    }

    @Override
    public void delete(ClienteTO objObjeto) throws Exception {
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="CALL sp_delete_cliente(?)";
        CallableStatement cs=cn.prepareCall(sql);
        cs.setInt(1, objObjeto.getIdcliente());
        cs.execute();
    }
    
}
