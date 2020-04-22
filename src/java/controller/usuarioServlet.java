/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.operacionesUsuario;
import database.baseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.usuario;
import org.json.simple.JSONObject;

public class usuarioServlet extends HttpServlet {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String descripcion;
    private usuario usuario;
    private baseDatos baseDatos;
    private operacionesUsuario operaciones;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        usuario = new usuario();
        baseDatos = new baseDatos();
        operaciones = new operacionesUsuario(baseDatos.getConnection());

        //Se reciben los objetos del formulario y son guardados en variables
        
        id = (request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0 );
        nombre = (request.getParameter("nombre") != null ? request.getParameter("nombre") : new String());
        apellido = (request.getParameter("apellido") != null ? request.getParameter("apellido") : new String());
        email = (request.getParameter("email") != null ? request.getParameter("email") : new String());
        contrasena = (request.getParameter("contrasena") != null ? request.getParameter("contrasena") : new String());
        descripcion = (request.getParameter("descripcion") != null ? request.getParameter("descripcion") : new String());
        
            try {
                
                // Operaciones del crud
                
                if (request.getParameter("btnAgregar") != null) {
                    
                    usuario = new usuario(id, nombre, apellido, email, contrasena, descripcion);
                    operaciones.agregarRegistro(usuario);

                } else if (request.getParameter("btnModificar") != null) {

                    usuario = new usuario(id, nombre, apellido, email, contrasena, descripcion);
                    operaciones.modificarRegistro(usuario);

                } else if (request.getParameter("btnEliminar") != null) {

                    usuario.setId(id);
                    operaciones.eliminarRegistro(usuario.getId());

                } else if (request.getParameter("modificar")!= null) {
                    
                    usuario = (usuario) operaciones.consultarUno(id);
//                    request.setAttribute("usuario", usuario);
                    
                    JSONObject json = new JSONObject();
                    
                    json.put("id", usuario.getId());
                    json.put("nombre", usuario.getNombre());
                    json.put("apellido", usuario.getApellido());
                    json.put("correo", usuario.getEmail());
                    json.put("contrasena", usuario.getContrasena());
                    json.put("descripcion", usuario.getDescripcion());
                    
                    PrintWriter out = response.getWriter();
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    out.print(json.toString());
                    out.flush();
                    
//                    request.getRequestDispatcher("modificar.jsp").forward(request, response);
                    
                }
                
                //Redireccionamiento a la lista de los registros de usuario

                if (request.getParameter("btnConsultar") != null || request.getParameter("btnAgregar")!=null || request.getParameter("btnModificar")!=null) {

                    request.setAttribute("listaUsuario", operaciones.consultarTodos());
                    request.getRequestDispatcher("vistaTabla.jsp").forward(request, response);
                    
                }

            } catch(Exception e){
                    
                e.printStackTrace();
            }
                    
            finally {

                //Se cierra la conexión de la base de datos
                
               if (baseDatos != null) {
                   baseDatos.closeConnection();
               }
                
            }
            
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para crear, leer, actualizar y eliminar datos de un formulario";
    }// </editor-fold>

}
