<%@page import="DAO.InvitadoDAO" %>
<%@page import="model.Invitado" %>
<%@page import="java.util.ArrayList" %>
<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLink = "InvitadoServlet"; //Aqui se debe de poner la ruta de la servlet que agrega  
String pageElementName = "invitado"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = "invitados"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
<%@include file="admin_validation.jsp" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Invitados</title>
    <%@include file="references.jsp" %>
  </head>
  <body class="vh-100 bg-light">
    <div class="container-fluid h-100">
      <%@include file="header.jsp" %>
      <!--Page Content-->
      <div class="row flex-grow-1 mb-3 flex-column flex-md-row m-auto w-100">
        <%@include file="sidebar.jsp" %>
        <!-- Main Content -->
        <%@include file="crud_main_content_header.jsp" %>
        <thead>
          <tr>
            <th scope="col">id</th>
            <th scope="col">Foto</th>
            <th scope="col">Nombres</th>
            <th scope="col">Apellidos</th>
            <th scope="col">Biografía</th>
          </tr>
        </thead>
        <tbody>
          <%
          InvitadoDAO dao = new InvitadoDAO();
            ArrayList<Invitado> invitados = (ArrayList<Invitado>)dao.listAll();
            for(Invitado invitado : invitados){
          %>
            <tr data-id='<%=invitado.getIdInvitado()%>'>
              <td value='<%=invitado.getIdInvitado()%>' name="id-row"><%=invitado.getIdInvitado()%></td>
              <td>
                <img src='<%=invitado.getImagenUrl()%>' 
                alt="Foto de invitado" 
                style="width: 100px;"
                onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/img/placeholders/no_image.jpg'">
              </td>
              <td value='<%=invitado.getNombres()%>' name="guest-name"><%=invitado.getNombres()%></td>
              <td value='<%=invitado.getApellidos()%>' name="guest-last-name"><%=invitado.getApellidos()%></td>
              <td value='<%=invitado.getBiografia()%>' name="guest-biography"><%=invitado.getBiografia()%></td>
            </tr>
          <%}%>
        </tbody>
        <%@include file="crud_main_content_footer.jsp" %>
      </div>
      <!--End of Page Content-->
      <!--Main Modal-->
      <%@include file="main_modal_header.jsp" %>
      <!--Esto es el formulario que se usa tanto para añadir o editar-->
      <form id="mainForm" method="POST" action='<%=apiLink%>' enctype="multipart/form-data">
        <input type="text" value="" class="modal-form-input" id="id-row" name="id-row" hidden>
        <div class="mb-3">
          <label for="guest-name" class="col-form-label"
            >Nombre del invitado:</label
          >
          <input
            type="text"
            class="form-control modal-form-input"
            id="guest-name"
            name="guest-name"
            maxlength="45"
            required
          />
        </div>
        <div class="mb-3">
            <label for="guest-last-name" class="col-form-label"
              >Apellidos del invitado:</label
            >
            <input
              type="text"
              class="form-control modal-form-input"
              id="guest-last-name"
              name="guest-last-name"
              maxlength="45"
              required
            />
          </div>
        <div class="mb-3">
          <label for="guest-biography" class="col-form-label"
            >Biografía:</label
          >
          <textarea
            class="form-control modal-form-input"
            id="guest-biography"
            name="guest-biography"
            required
          ></textarea>
        </div>
        <div class="mb-3">
          <label for="guest-photo" class="col-form-label"
            >Foto del invitado (.jpg):</label>
          <input type="file" name="guest-photo" class="form-control modal-form-input" id="guest-photo" accept=".jpg">
        </div>
        <input type="text" name="form-mode" id="form-mode" value="" hidden>
      </form>
      <%@include file="main_modal_footer.jsp" %>
      <!--End of add event modal-->
      <!--Confirm delete modal-->
      <%@include file="confirm_delete_modal.jsp" %>
      <%@include file="warning_delete_modal.jsp" %>
    </div>
    <%@include file="sidebar_script.jsp" %> <%@include file="table_script.jsp"
    %>
  </body>
</html>
