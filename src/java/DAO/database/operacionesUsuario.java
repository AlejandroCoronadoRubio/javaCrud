package DAO.database;

import DAO.interfaces.interfaceCatalogo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.usuario;

public class operacionesUsuario implements interfaceCatalogo {

    private Connection conn = null;

    public operacionesUsuario(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        usuario u = (usuario) o;
        String sql = "INSERT INTO jspbasiccrud.usuario (nombre, apellido, email, contrasena, descripcion) VALUES (?, ?, ?,aes_encrypt(?, 'hola') , ?);";

        PreparedStatement ps = this.conn.prepareStatement(sql);

        ps.setString(1, u.getNombre());
        ps.setString(2, u.getApellido());
        ps.setString(3, u.getEmail());
        ps.setString(4, u.getContrasena());
        ps.setString(5, u.getDescripcion());

        boolean resultado = ps.execute();

        if (ps != null) {
            ps.close();
        }

        return resultado;

    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {
        
        usuario u = (usuario) o;
        String sql = "UPDATE jspbasiccrud.usuario SET nombre = ?, apellido = ?, email = ?, contrasena = aes_encrypt(?, 'hola'), descripcion = ? WHERE id = ?;";
        PreparedStatement ps = null;
        boolean resultado = false;
        
        try {
        
            ps = this.conn.prepareStatement(sql);

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getContrasena());
            ps.setString(5, u.getDescripcion());
            ps.setInt(6, u.getId());

            resultado = ps.execute();
        
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            
            if (ps != null) {
                ps.close();
            }
        
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception{

        String sql = "DELETE FROM jspbasiccrud.usuario WHERE id = ?;";
        PreparedStatement ps = null;
        boolean resultado = false;
        
        try { 
        
            ps = this.conn.prepareStatement(sql);

            ps.setInt(1, id);

            resultado = ps.execute();
        
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

        return resultado;
    }

    @Override
    public Object consultarTodos() throws Exception {

        List<usuario> usuario = new ArrayList<>();

        StringBuilder sql =  new StringBuilder();
        sql.append("SELECT u.id, u.nombre, u.apellido,  u.email, ");
        sql.append("aes_decrypt(u.contrasena, 'hola'), u.descripcion FROM jspbasiccrud.usuario u;");

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try { 
        
        ps = this.conn.prepareStatement(sql.toString());

        rs = ps.executeQuery();

        while (rs.next()) {

            usuario u = new usuario();

            u.setId(rs.getInt(1));
            u.setNombre(rs.getString(2));
            u.setApellido(rs.getString(3));
            u.setEmail(rs.getString(4));
            u.setContrasena(rs.getString(5));
            u.setDescripcion(rs.getString(6));
            
            usuario.add(u);
        }
        
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            
            if(ps != null){ 
                ps.close();        
            }

            if (rs != null) {
                rs.close();
            }
            
        }
        return usuario;
    }

    @Override
    public Object consultarUno(int id) throws Exception {
    
        usuario usuario = null;
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT u.id, u.nombre, u.apellido,  u.email, ");
        sql.append("aes_decrypt(u.contrasena, 'hola'), u.descripcion  FROM jspbasiccrud.usuario u WHERE id = ?;");
        
        try{
            
            ps = conn.prepareStatement(sql.toString());
             
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                usuario = new usuario();
                
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                usuario.setContrasena(rs.getString(5));
                usuario.setDescripcion(rs.getString(6));
                
            }
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        } finally {
            
            if(ps != null) {
                ps.close();
            }
            
            if(ps != null) {
                rs.close();
            }
            
        }
        
        return usuario;
        
    }

}
