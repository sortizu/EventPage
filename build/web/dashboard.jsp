<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLinkAdd = "#"; //Aqui se debe de poner la ruta de la servlet que agrega 
String apiLinkEdit = "#"; //Aqui se debe de poner la ruta de la servlet que edita 
String apiLinkDelete = "#"; //Aqui se debe de poner la ruta de la servlet que elimina 
String pageElementName = "dashboard"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = ""; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard</title>
    <%@include file="references.jsp" %>
  </head>
  <body class="vh-100 bg-light">
    <div class="container-fluid h-100 d-flex flex-column">
      <%@include file="header.jsp" %>
      <!--Page Content-->
      <div class="row flex-grow-1 mb-3 flex-column flex-md-row m-auto w-100">
        <%@include file="sidebar.jsp" %>
        <!-- Main Content -->
        <div class="col mx-auto">
          <div class="row h-100 mx-auto py-3 py-lg-0">
            <div class="h-50 col-12 col-lg-6">
              <div class="row" style="min-height: 5%">
                <div class="col">DASHBOARD</div>
              </div>
              <div class="row" style="min-height: 90%">
                <div class="col-6 p-1">
                  <div class="card h-100">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-6 p-1">
                  <div class="card h-100">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-6 p-1">
                  <div class="card h-100">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-6 p-1">
                  <div class="card h-100">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="h-50 col-12 col-lg-3">
              <div class="row" style="min-height: 5%">
                <div class="col">ADMINISTRADORES</div>
              </div>
              <div class="row m-auto" style="min-height: 90%">
                <div class="col-12 p-1">
                  <div class="card">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-12 p-1">
                  <div class="card">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-12 p-1">
                  <div class="card">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-12 p-1">
                  <div class="card">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="h-50 col-12 col-lg-3">
              <div class="row" style="min-height: 5%">
                <div class="col">PRÓXIMOS EVENTOS (HOY)</div>
              </div>
              <div class="row m-auto" style="min-height: 90%">
                <div class="col-12 p-1">
                  <div class="card">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-12 p-1">
                  <div class="card">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-12 p-1">
                  <div class="card">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
                <div class="col-12 p-1">
                  <div class="card">
                    <div class="card-title">CARD</div>
                    <div class="card-subtitle">CARD SUBTITLE</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="h-50 col-12 m-auto g-2">
              <div class="card h-100 w-100 bg-white">
                <div class="card-title">CHART</div>
              </div>
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
