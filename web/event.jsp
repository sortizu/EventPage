<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLinkAdd = "#"; //Aqui se debe de poner la ruta de la servlet que agrega 
String apiLinkEdit = "#"; //Aqui se debe de poner la ruta de la servlet que edita 
String apiLinkDelete = "#"; //Aqui se debe de poner la ruta de la servlet que elimina 
String pageElementName = "evento"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = "eventos"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Eventos</title>
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
            <th scope="col">Titulo</th>
            <th scope="col">Fecha</th>
            <th scope="col">Categorí­a</th>
            <th scope="col">Capacidad</th>
            <th scope="col">Costo ($)</th>
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
            >Tí­tulo de evento:</label
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
          <label for="event-description" class="col-form-label"
            >Descripción:</label
          >
          <textarea
            class="form-control modal-form-input form-input-ignore"
            id="event-description"
            required
          ></textarea>
        </div>
        <div class="mb-3">
          <label for="event-date" class="col-form-label"
            >Fecha de evento:</label
          >
          <input
            type="datetime-local"
            class="form-control modal-form-input"
            id="event-date"
            required
          />
        </div>

        <div class="mb-3">
          <label for="event-label" class="col-form-label"
            >Categoría de evento:</label
          >
          <select
            id="event-label"
            class="form-select modal-form-input"
            aria-label="Default select example"
            required
          >
            <option value="" selected>
              Selecciona una categorí­a de evento
            </option>
            <option value="Conferencia">Conferencia</option>
            <option value="Taller">Taller</option>
            <option value="Workshop">Workshop</option>
          </select>
        </div>
        <div class="mb-3">
          <label for="event-capacity" class="col-form-label"
            >Capacidad de evento:</label
          >
          <input
            type="number"
            class="form-control modal-form-input"
            id="event-capacity"
            min="0"
            required
          />
        </div>
        <div class="mb-3">
          <label for="event-price" class="col-form-label"
            >Costo de entrada:</label
          >
          <div class="input-group">
            <span class="input-group-text">$</span>
            <input
              type="number"
              class="form-control modal-form-input"
              id="event-price"
              min="0"
              required
            />
          </div>
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
