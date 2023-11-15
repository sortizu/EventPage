
<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLink = "ConfiguracionServlet"; //Aqui se debe de poner la ruta de la servlet que agrega 
String pageElementName = "configuracion"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = ""; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
<%@include file="admin_validation.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Configuración</title>
    <%@include file="references.jsp" %>

  </head>
  <body class="vh-100 bg-light">
    <div class="container-fluid h-100 d-flex flex-column">
      <%@include file="header.jsp" %>
      <!--Page Content-->
      <div class="row flex-grow-1 mb-3 flex-column flex-md-row m-auto w-100">
        <%@include file="sidebar.jsp" %>
        <!-- Main Content -->
        <div class="col h-100 d-flex flex-column px-0 ps-sm-4 pe-sm-3" id="main-content">
          <div class="col-12">
            <h2 style="font-weight: 100">Configuración de página</h2>
          </div>
          <div class="col-12 d-flex flex-column flex-grow-1 justify-content-start ">
            
            <form id="configurationForm" method="POST" action='<%=apiLink%>' class="w-100 flex-grow-1" enctype="multipart/form-data">
                <div class="mb-3">
                  <label for="page-name" class="col-form-label"
                    >Nombre de sitio web:</label
                  >
                  <input
                    type="text"
                    class="form-control modal-form-input"
                    id="page-name"
                    name="page-name"
                    maxlength="45"
                    value="<%=configuracion.getNombrePagina()%>"
                    required
                  />
                </div>
                
                <div class="mb-3">
                  <label for="page-description" class="col-form-label"
                    >Descripción de sitio web:</label
                  >
                  <textarea
                    class="form-control modal-form-input form-input-ignore"
                    id="page-description"
                    name="page-description"
                    required
                  ><%=configuracion.getDescripcionPagina()%></textarea>
                </div>
                
                <div class="mb-3">
                    <label for="slogan" class="col-form-label"
                      >Eslogan de sitio web:</label
                    >
                    <input
                      type="text"
                      class="form-control modal-form-input"
                      id="slogan"
                      name="slogan"
                      maxlength="45"
                      value="<%=configuracion.getEslogan()%>"
                      required
                    />
                  </div>

                  <div class="mb-3">
                    <label for="page-logo" class="col-form-label"
                      >Logo de sitio web (.svg):</label>
                    <input type="file" name="page-logo" class="form-control" id="page-logo" accept=".svg">
                  </div>

                  <div class="mb-3" style="font-size: 12px;">
                    <i class="bi bi-info-circle"></i>
                    Si desea cambiar el logo, seleccione uno nuevo. Si no, deje este campo vacío.
                    <br>
                    Tendrá que esperar unos segundos y volver a cargar la página para que se apliquen los cambios.
                  </div>
                  
              </form>
            <div class="align-self-end">
                <button  type="reset" class="btn btn-outline-secondary" form="configurationForm">
                    Borrar todo
                </button >
                <button  type="submit" class="btn btn-primary" form="configurationForm">
                    Guardar
                </button >
            </div>
          </div>
        </div>
      </div>
      <!--End of Page Content-->
    </div>
    <%@include file="sidebar_script.jsp" %> <%@include file="table_script.jsp"
    %>
  </body>
</html>
