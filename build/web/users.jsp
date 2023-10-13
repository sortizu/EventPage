<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLinkAdd = "#"; //Aqui se debe de poner la ruta de la servlet que agrega 
String apiLinkEdit = "#"; //Aqui se debe de poner la ruta de la servlet que edita 
String apiLinkDelete = "#"; //Aqui se debe de poner la ruta de la servlet que elimina 
String pageElementName = "usuario"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = "usuarios"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
<!DOCTYPE html>
<html lang="es">
  <head>
    
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Usuarios</title>
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
        <tbody></tbody>
        <%@include file="crud_main_content_footer.jsp" %>
      </div>
      <!--End of Page Content-->
      <!--Main Modal-->
      <%@include file="main_modal_header.jsp" %>
      <!--Esto es el formulario que se usa tanto para añadir o editar-->
      <form id="mainForm" method="POST" action="">
        <div class="mb-3">
          <label for="event-name" class="col-form-label"
            >Nombres:</label
          >
          <input
            type="text"
            class="form-control modal-form-input"
            id="event-name"
            maxlength="45"
            required
          />
        </div>
        <div class="mb-3">
            <label for="event-name" class="col-form-label"
              >Apellidos:</label
            >
            <input
              type="text"
              class="form-control modal-form-input"
              id="event-name"
              maxlength="45"
              required
            />
        </div>
        <div class="mb-3">
            <label for="event-name" class="col-form-label"
              >Email:</label
            >
            <input
              type="email"
              class="form-control modal-form-input"
              id="event-name"
              maxlength="45"
              required
            />
          </div>
          <div class="mb-3">
            <label for="event-name" class="col-form-label"
              >Contraseña:</label
            >
            <input
              type="password"
              class="form-control modal-form-input"
              id="event-name"
              maxlength="45"
              required
            />
          </div>
          <div class="mb-3">
            <label for="event-name" class="col-form-label"
              >DNI:</label
            >
            <input
              type="number"
              class="form-control modal-form-input"
              id="event-name"
              minlength="9"
              min="0"
              required
            />
          </div>
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
