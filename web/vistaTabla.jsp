<%-- 
    Document   : vistaTabla
    Created on : Feb 7, 2019, 11:53:14 AM
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Tabla</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css"> 
        <link rel="stylesheet" type="text/css" href="css/bootstrap-reboot.css"> 
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"> 
        <link rel="stylesheet" type="text/css" href="css/style.css"> 
        <link href="css/sweetalert2.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
      <div class="container-total">
        
        <h1>Vista Tabla</h1>
       
        <form action="/miPrimerWeb/usuario.do" method="POST">
        <table id="tablaperrona" class="table table-hover">
            <thead class="thead-light" >
                <tr>
                    <th scope="col">Nº</th>
                    <th scope="col"></th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Email</th>
                    <th scope="col">Descripción</th>
                </tr>
            </thead>
            <tbody id="cuerpoBody">
                <%  
                    int contador = 0;
                    java.util.List<model.usuario> _listaUsuario = (java.util.List<model.usuario>) request.getAttribute("listaUsuario");
                    
                    if (!_listaUsuario.isEmpty()){
                        
                        for(model.usuario u : _listaUsuario){
                %>
                
                <tr id="fila<%=contador%>">
                    <td><%=u.getId()%></td>
                    <td>
                        <a onclick="eliminar(<%=u.getId()%>, 'fila<%=contador%>');" style= "color:white;" class="btn btn-danger">Eliminar</a>
                        <a onclick="modificar(<%=u.getId()%>, 'fila<%=contador%>');" style= "color:white;" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Modificar</a>
                    </td>
                    <td><%=u.getNombre() %></td>
                    <td><%=u.getApellido() %></td>
                    <td><%=u.getEmail() %></td>
                    <td><%=u.getDescripcion() %></td>
                </tr>
                <%
                    contador++;
                        }

                    }else{
                    
                        out.print("<tr>");
                            out.print("<td colspan=\"7\" ><h1>No se encontraron datos ...</h1></td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table>
        </form>
       </div>
            
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modificar</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <input class="form-control" type="hidden" name="TrElement" id="TrElement" value="" required>
        <input class="form-control" type="hidden" name="id" id="id" value="" required>
        <label for="nombre">Nombre</label><input class="form-control" type="text" name="nombre" id="nombre" required>
        <label for="apellido">Apellido</label> <input class="form-control" type="text" name="apellido" id="apellido" required>
        <label for="correo">Correo</label> <input class="form-control" type="email" name="correo" id="correo" required>
        <label for="contrasena">Contrase&ncaron;a</label> <input class="form-control" type="password" name="contrasena" id="contrasena" required>
        <label for="descripcion">Descripci&oacute;n</label><input class="form-control" type="text" name="descripcion" id="descripcion" required>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="guardar()">Guardar</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>
            
<script src="js/jquery-3.4.1.js" type="text/javascript"></script>s
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/sweetalert2.min.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
            
</body>
</html>
