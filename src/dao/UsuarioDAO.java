
package dao;

import conexion.ConMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import to.UsuarioTO;


public class UsuarioDAO {
    public boolean acceso(UsuarioTO objUsuarioTO) throws Exception {
        boolean n=false;
        Connection cn=ConMySql.getInstance().getConnection();
        String sql="select * from usuario ";
        PreparedStatement ps=cn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            if (objUsuarioTO.getUsuario().equals(rs.getString(2)) && objUsuarioTO.getClave().equals(rs.getString(3))) {
                n=true;
                if (rs.getInt(4)==1) {
                    objUsuarioTO.setNivel(1);
                }
                if (rs.getInt(4)==0) {
                    objUsuarioTO.setNivel(0);
                }
            }
        }
        return n;
    }
}
