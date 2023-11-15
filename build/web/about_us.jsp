<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EventPage | Conócenos</title>
    <%@include file="references.jsp" %>
  </head>
  <body>
    <div class="container-fluid d-flex flex-column vh-100 g-0">
      <!--Header-->
      <%@include file="main_header.jsp" %>
      <!--End of Header-->
      <div class="row g-0">
        <!--TITULO DE PAGINA-->
        <h2
          class="col-12 mt-5 d-flex justify-content-center"
          style="font-weight: 300"
        >
          CONÓCENOS
        </h2>
        <div class="zig-zag"></div>
        <center>
        <p style="font-size: 32px;font-weight: 100;">¡<%=configuracion.getEslogan()%>!</p>
      </center>
        <div class="col-10 col-sm-8 m-auto py-3">
          <h4>SOBRE <%=configuracion.getNombrePagina()%></h4>
          <p>
            <%=configuracion.getDescripcionPagina()%>
          </p>
          
        </div>
        <div class="zig-zag"></div>
        <div class="col-8 m-auto py-3">
          <h4 class="text-center">CONTACTO</h4>
          <form id="mainForm" method="POST" action="" class="d-flex justify-content-center flex-column mb-5">
            <div class="mb-3">
              <label for="event-name" class="col-form-label">Correo:</label>
              <input
                type="email"
                class="form-control modal-form-input"
                id="event-name"
                maxlength="45"
                required
              />
            </div>
            <div class="mb-3">
              <label for="event-description" class="col-form-label"
                >Mensaje:</label
              >
              <textarea
                class="form-control modal-form-input form-input-ignore"
                id="event-description"
                required
              ></textarea>
            </div>
            <button
              type="submit"
              class="btn btn-outline-danger m-auto"
              id="mainFormSubmitButton"
            >
              Enviar
            </button>
          </form>
        </div>
      </div>

      <!--Navigation bar-->
      <%@include file="navigation_bar.jsp" %>
    </div>
  </body>
</html>
