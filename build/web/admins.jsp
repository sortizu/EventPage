<%@page import="DAO.UsuarioDAO" %>
<%@page import="model.Usuario" %>
<%@page import="java.util.ArrayList" %>
<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLink = "AdminServlet"; //Aqui se debe de poner la ruta de la servlet que agrega 
String pageElementName = "administrador"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = "administradores"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Administradores</title>
    <%@include file="references.jsp" %>
  </head>
  <body class="vh-100 bg-light">
    <div class="container-fluid h-100 d-flex flex-column">
      <%@include file="header.jsp" %>
      <!--Page Content-->
      <div class="row flex-grow-1 mb-3 flex-column flex-md-row m-auto w-100">
        <%@include file="sidebar.jsp" %>
        <!-- Main Content -->
        <%@include file="crud_main_content_header.jsp" %>
        <thead>
          <tr>
            <th scope="col">id</th>
            <th scope="col">Nombres</th>
            <th scope="col">Apellidos</th>
            <th scope="col">Correo</th>
            <th scope="col">Contraseña</th>
            <th scope="col">DNI</th>
          </tr>
        </thead>
        <tbody>
          <%
          UsuarioDAO dao = new UsuarioDAO();
          ArrayList<Usuario> usuarios = (ArrayList<Usuario>)dao.listAll();
          for(Usuario usuario: usuarios){
            if(usuario.isAdmin()){
        %>
          <tr data-id='<%=usuario.getId()%>'>
            <td value='<%=usuario.getId()%>'><%=usuario.getId()%></td>
            <td value='<%=usuario.getNombres()%>'><%=usuario.getNombres()%></td>
            <td value='<%=usuario.getApellidos()%>'><%=usuario.getApellidos()%></td>
            <td value='<%=usuario.getEmail()%>'><%=usuario.getEmail()%></td>
            <td value='<%=usuario.getPassword()%>'><%=usuario.getPassword()%></td>
            <td value='<%=usuario.getDni()%>'><%=usuario.getDni()%></td>
          </tr>
        <%}}%>
        </tbody>
        <%@include file="crud_main_content_footer.jsp" %>
      </div>
      <!--End of Page Content-->
      <!--Main Modal-->
      <%@include file="main_modal_header.jsp" %>
      <!--Esto es el formulario que se usa tanto para añadir o editar-->
      <form id="mainForm" method="POST" action='<%=apiLink%>'>
        <input type="text" value="" class="modal-form-input" id="id-row" name="id-row" hidden>
        <div class="mb-3">
          <label for="admin-name" class="col-form-label"
            >Nombres:</label
          >
          <input
            type="text"
            class="form-control modal-form-input"
            id="admin-name"
            name="admin-name"
            maxlength="45"
            required
          />
        </div>
        <div class="mb-3">
            <label for="admin-last-name" class="col-form-label"
              >Apellidos:</label
            >
            <input
              type="text"
              class="form-control modal-form-input"
              id="admin-last-name"
              name="admin-last-name"
              maxlength="45"
              required
            />
        </div>
        <div class="mb-3">
            <label for="admin-email" class="col-form-label"
              >Email:</label
            >
            <input
              type="email"
              class="form-control modal-form-input"
              id="admin-email"
              name="admin-email"
              maxlength="45"
              required
            />
          </div>
          <div class="mb-3">
            <label for="admin-password" class="col-form-label"
              >Contraseña:</label
            >
            <input
              type="password"
              class="form-control modal-form-input"
              id="admin-password"
              name="admin-password"
              maxlength="45"
              required
            />
          </div>
          <div class="mb-3">
            <label for="admin-dni" class="col-form-label"
              >DNI:</label
            >
            <input
              type="number"
              class="form-control modal-form-input"
              id="admin-dni"
              name="admin-dni"
              minlength="8"
              min="0"
              required
            />
          </div>
          <input type="text" name="form-mode" id="form-mode" value="" hidden>
      </form>
      <%@include file="main_modal_footer.jsp" %>
      <!--End of add event modal-->
      <!--Confirm delete modal-->
      <%@include file="confirm_delete_modal.jsp" %>
    </div>
    <%@include file="sidebar_script.jsp" %> <%@include file="table_script.jsp"
    %>
  </body>
</html>
