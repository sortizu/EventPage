<%@page import="DAO.UsuarioDAO" %>
<%@page import="DAO.CompraDAO" %>
<%@page import="model.Usuario" %>
<%@page import="DAO.EventoDAO" %>
<%@page import="model.Evento" %>
<%@page import="java.util.ArrayList" %>
<%@page import="debug.Console" %>
<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLink = "#"; //Aqui se debe de poner la ruta de la servlet que agrega 
String pageElementName = "dashboard"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = ""; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
<%@include file="admin_validation.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
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
        <div class="col h-100 d-flex flex-column px-0 ps-sm-4 pe-sm-3" id="main-content">
          <div class="col-12">
            <h2 style="font-weight: 100">Dashboard</h2>
          </div>
          <div class="col-12 d-flex flex-column flex-lg-row flex-grow-1">
            <div class="col-12 col-lg-5 d-flex flex-column flex-grow-1 gap-2">
              <div class="col-12 d-flex flex-row">
                <div class="col-6 pe-1">
                  <div class="d-flex flex-column shadow-sm dashboard-card" id="dashboard-card-income">
                    <div class="dashboard-card-title">
                      <i class="bi bi-cash-stack"></i>
                      INGRESOS (HOY)
                    </div>
                    <div id="dashboard-card-income-number" class="dashboard-card-number">
                      <%CompraDAO compraDAO = new CompraDAO();%>
                      <%="$/."+compraDAO.obtenerIngresosDiarios()%>
                    </div>
                  </div>
                </div>
                <div class="col-6 ps-1">
                  <div class="d-flex flex-column shadow-sm dashboard-card" id="dashboard-card-users">
                    <div class="dashboard-card-title">
                      NUEVOS USUARIOS (HOY)</div>
                    <div id="dashboard-card-users-number" class="dashboard-card-number">
                      <i class="bi bi-person-up"></i>
                      <%UsuarioDAO usuarioDAONuevos = new UsuarioDAO();%>
                      <%=usuarioDAONuevos.obtenerNuevosUsuariosDiarios()%>
                    </div>
                  </div>
                </div>
                
              </div>
              <div class="col-12 d-flex flex-column shadow-sm dashboard-card flex-grow-1">
                <div class="dashboard-card-title">
                  <i class="bi bi-graph-up"></i>
                  CATEGORÍAS MÁS POPULARES (INGRESOS)</div>
                <div id="category-bars" class="bar-graph d-flex flex-row align-items-end">
                  <div class="bar" id="cat-bar-1" hidden>
                    <div class="bar-label">CATEGORIA 1</div>
                    <div class="bar-body">$/.100000</div>
                  </div>
                  <div class="bar" id="cat-bar-2" hidden>
                    <div class="bar-label">CATEGORIA 2</div>
                    <div class="bar-body">$/.200000</div>
                  </div>
                  <div class="bar" id="cat-bar-3" hidden>
                    <div class="bar-label">CATEGORIA 3</div>
                    <div class="bar-body">$/.300000</div>
                  </div>
                </div>
              </div>
              <div class="col-12 d-flex flex-column shadow-sm dashboard-card flex-grow-1">
                <div class="dashboard-card-title">
                  <i class="bi bi-graph-up"></i>
                  INVITADOS MÁS POPULARES (TICKETS)</div>
                <div id="guests-bars" class="bar-graph d-flex flex-row align-items-end">
                  <div class="bar" id="cat-g-1">
                    <div class="bar-label">Omar Pikmin</div>
                    <div class="bar-body" >10000</div>
                  </div>
                  <div class="bar" id="cat-g-2">
                    <div class="bar-label">Gabe Newell</div>
                    <div class="bar-body" >20000</div>
                  </div>
                  <div class="bar" id="cat-g-3">
                    <div class="bar-label">Hajime Isayama</div>
                    <div class="bar-body" >30000</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-12 col-lg-7 ms-0 ms-lg-2 mt-2 mt-lg-0 shadow-sm d-flex flex-column dashboard-card">
              <div class="dashboard-card-title">
                <i class="bi bi-calendar-event-fill"></i> PRÓXIMOS EVENTOS</div>
              <div id="dashboard-event-list">
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
  <script>
    $(document).ready(function () {
      $.ajax({
        url: "ObtenerGananciaPorCategoriaServlet",
        type: "GET",
        data: {},
        success: function (response) {
          var max=0;
          for (var i = 0; i < response.length; i++) {
            var ganancia = response[i]["ganancia"];
            if(ganancia>max){
              max=ganancia;
            }
          }
          for (var i = 0; i < response.length; i++) {
            var categoria = response[i]["nombre_categoria"];
            var ganancia = response[i]["ganancia"];
            $("#cat-bar-" + (i + 1)).attr("hidden", false);
            $("#cat-bar-" + (i + 1) + " .bar-label").text(categoria);
            $("#cat-bar-" + (i + 1) + " .bar-body").text("$/. " + ganancia);
            var porcentaje = (ganancia / max) * 100;
            $("#cat-bar-" + (i + 1)).css("height", porcentaje + "%");
          }
        },
        error: function (response) {},
      });
      $.ajax({
        url: "ObtenerTicketsPorInvitadosServlet",
        type: "GET",
        data: {},
        success: function (response) {
          var max=0;
          for (var i = 0; i < response.length; i++) {
            var ganancia = response[i]["numero_tickets"];
            if(ganancia>max){
              max=ganancia;
            }
          }
          for (var i = 0; i < response.length; i++) {
            var numeroTickets = response[i]["numero_tickets"];
            var nombreInvitado = response[i]["nombre_invitado"];
            $("#cat-g-" + (i + 1)).attr("hidden", false);
            $("#cat-g-" + (i + 1) + " .bar-label").text(nombreInvitado);
            $("#cat-g-" + (i + 1) + " .bar-body").text(numeroTickets);
            var porcentaje = (numeroTickets / max) * 100;
            $("#cat-g-" + (i + 1)).css("height", porcentaje + "%");
            
          }
        },
        error: function (response) {},
      });
      $.ajax({
        url: "ProximosEventosDashboardServlet",
        type: "GET",
        data: {},
        success: function (response) {
          for (var i = 0; i < response.length; i++) {
            var nombreEvento = response[i]["nombre_evento"];
            var fechaEvento = response[i]["fecha"];
            var numeroTickets = response[i]["numero_tickets"];
            var ganancia = response[i]["ganancia"];
            $("#dashboard-event-list").append(
              '<div class="dashboard-event row"><div class="col-7"><div class="dashboard-event-title">' +
                nombreEvento +
                '</div><div class="dashboard-event-date"><i class="bi bi-clock-fill me-1"></i>' +
                fechaEvento +
                '</div></div><div class="col-5 row d-flex flex-column align-items-end ms-auto my-auto"><div class="d-flex flex-row justify-content-end mb-1"><div><i class="bi bi-ticket-perforated-fill me-2"></i><div class="d-none d-sm-inline me-2">TICKETS VENDIDOS:</div></div><div class="dashboard-event-tickets">' +
                numeroTickets +
                '</div></div><div class="d-flex flex-row justify-content-end" ><div style="color:#87a96b;"><i class="bi bi-cash me-2"></i><div class="d-none d-sm-inline me-2">INGRESOS: </div></div><div class="dashboard-event-income" style="background-color:#87a96b;">$/. ' +
                ganancia +
                "</div></div></div></div>"
            );
          }
        },
        error: function (response) {},
      });
    });
  </script>
</html>
