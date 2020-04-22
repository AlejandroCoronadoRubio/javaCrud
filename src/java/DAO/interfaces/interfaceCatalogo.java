
package DAO.interfaces;


public interface interfaceCatalogo {
    
    public boolean agregarRegistro(Object o) throws Exception;
    public boolean modificarRegistro(Object o) throws Exception;
    public boolean eliminarRegistro(int id)throws Exception;
    public Object consultarTodos() throws Exception;
    public Object consultarUno(int id) throws Exception;
}
