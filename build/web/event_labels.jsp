<%@page import="DAO.CategoriaEventoDAO" %>
<%@page import="model.CategoriaEvento" %>
<%@page import="java.util.ArrayList" %>
<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLink = "CategoriaEventoServlet"; //Aqui se debe de poner la ruta de la servlet que agrega 
String pageElementName = "categoria"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = "categorias"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
<%@include file="admin_validation.jsp" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Categorías de evento</title>
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
            <th scope="col">Nombre de categoría</th>
          </tr>
        </thead>
        <tbody>
          <%
          CategoriaEventoDAO dao = new CategoriaEventoDAO();
            ArrayList<CategoriaEvento> categoriaEventos = (ArrayList<CategoriaEvento>)dao.listAll();
            for(CategoriaEvento categoriaEvento : categoriaEventos){
          %>
            <tr data-id='<%=categoriaEvento.getId()%>'>
              <td value='<%=categoriaEvento.getId()%>'><%=categoriaEvento.getId()%></td>
              <td value='<%=categoriaEvento.getNombreCategoria()%>'><%=categoriaEvento.getNombreCategoria()%></td>
            </tr>
          <%}%>
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
          <label for="event-name" class="col-form-label"
            >Nombre de categoría:</label
          >
          <input
            type="text"
            class="form-control modal-form-input"
            id="event-label-name"
            name="event-label-name"
            maxlength="45"
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
