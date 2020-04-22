<%-- 
    Document   : index
    Created on : Feb 7, 2019, 10:50:22 AM
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
 model.usuario usuario = (model.usuario) request.getAttribute("usuario");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css"> 
        <link rel="stylesheet" type="text/css" href="css/bootstrap-reboot.css"> 
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"> 
        <link rel="stylesheet" type="text/css" href="css/style.css"> 
    </head>
    <body id="mybody">
        <form action="/miPrimerWeb/usuario.do" method="POST">
            
            <table id="tableishon">
            <tr>
                <tr>
                <th><h3 id="formulario-titulo">Formulario</h3></th>
       
            <tr>
                <td><input type="hidden" id="id" class="form-control" placeholder="Matricula" name="id" value="<%=usuario.getId()%>"></td>
            </tr>
        
            <tr>
                 <td><input type="text" placeholder="Nombre" class="form-control" name="nombre" value="<%=usuario.getNombre()%>"></td>
            </tr>
            <tr>
                <td><input type="text" class="form-control" placeholder="Apellido" name="apellido" value="<%=usuario.getApellido()%>"></td>
            </tr>
        
            <tr>
                <td><input type="email" class="form-control" placeholder="Email" name="email" value="<%=usuario.getEmail()%>">
                <small id="emailHelp" class="form-text text-muted">Nunca compartiremos tu email con nadie.</small>
                </td>
            </tr>
    
            <tr>
                <td><input type="password" class="form-control" placeholder="Contraseña" name="contrasena" value="<%=usuario.getContrasena()%>"></td>
            </tr>
   
            <tr>
                <td><input type="text" class="form-control" placeholder="Descripción" name="descripcion" value="<%=usuario.getDescripcion()%>"></td>
            </tr>
                    
            
            <tr class="ancho">
           <!--<td> <input type="submit" name="btnAgregar" class="btn btn-primary" value="Agregar"></td>-->
           </tr>
          <tr class="ancho">
               <td> <input type="submit" name="btnModificar" class="btn btn-primary" value="Modificar"></td>
           </tr>
       <%--     <tr class="ancho">
          <td>  <input type="submit" name="btnEliminar" class="btn btn-danger" value="Eliminar"></td>
          </tr>--%>
           <tr class="ancho">
           <!--<td> <input type="submit" name="btnConsultar" class="btn btn-primary" value="Consultar"></td>-->
               <td><a href="usuario.do?btnConsultar" class="btn btn-primary">Consultar</a></td>
           </tr>
           </div>
           <td> </table>
        <%-- <td><button onclick="window.location.href= 'vistaTabla.jsp'" type="button" class="btn btn-primary" href="vistaTabla.jsp">Vista de la tabla</button></td>--%>
        
        </form>
       
    </body>
</html>
