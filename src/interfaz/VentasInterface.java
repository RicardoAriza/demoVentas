package interfaz;

import java.sql.ResultSet;

public interface VentasInterface <Objeto> {

    public ResultSet buscar(Object objObject) throws Exception;

    public void insert(Objeto objObjeto) throws Exception;

    public void update(Objeto objObjeto) throws Exception;

    public void delete(Objeto objObjeto) throws Exception;
    
}
