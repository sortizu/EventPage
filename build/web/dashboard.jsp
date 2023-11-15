<%@page import="DAO.UsuarioDAO" %>
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
                    <div class="dashboard-card-title">INGRESOS (HOY)</div>
                    <div id="dashboard-card-income-number" class="dashboard-card-number">$/.20,000</div>
                    <div id="dashboard-card-income-button" class="dashboard-card-details-button">Ver detalles
                      <i class="bi bi-plus-circle ms-1"></i>
                    </div>
                  </div>
                </div>
                <div class="col-6 ps-1">
                  <div class="d-flex flex-column shadow-sm dashboard-card" id="dashboard-card-users">
                    <div class="dashboard-card-title">NUEVOS USUARIOS (HOY)</div>
                    <div id="dashboard-card-users-number" class="dashboard-card-number">18</div>
                    <div id="dashboard-card-users-button" class="dashboard-card-details-button">Ver detalles
                      <i class="bi bi-plus-circle ms-1"></i>
                    </div>
                  </div>
                </div>
                
              </div>
              <div class="col-12 d-flex flex-column shadow-sm dashboard-card flex-grow-1">
                <div class="dashboard-card-title">CATEGORÍAS MÁS POPULARES (INGRESOS)</div>
                <div id="category-bars" class="bar-graph d-flex flex-row align-items-end">
                  <div class="bar">
                    <div class="bar-label">CATEGORIA 1</div>
                    <div class="bar-body" id="cat-bar-1">$/.100000</div>
                  </div>
                  <div class="bar">
                    <div class="bar-label">CATEGORIA 2</div>
                    <div class="bar-body" id="cat-bar-2">$/.200000</div>
                  </div>
                  <div class="bar">
                    <div class="bar-label">CATEGORIA 3</div>
                    <div class="bar-body" id="cat-bar-3">$/.300000</div>
                  </div>
                </div>
                <div id="dashboard-card-categories-button" class="dashboard-card-details-button">
                  Ver detalles
                  <i class="bi bi-plus-circle ms-1"></i></div>
              </div>
              <div class="col-12 d-flex flex-column shadow-sm dashboard-card flex-grow-1">
                <div class="dashboard-card-title">INVITADOS MÁS POPULARES (TICKETS)</div>
                <div id="guests-bars" class="bar-graph d-flex flex-row align-items-end">
                  <div class="bar">
                    <div class="bar-label">Omar Pikmin</div>
                    <div class="bar-body" id="cat-g-1">10000</div>
                  </div>
                  <div class="bar">
                    <div class="bar-label">Gabe Newell</div>
                    <div class="bar-body" id="cat-g-2">20000</div>
                  </div>
                  <div class="bar">
                    <div class="bar-label">Hajime Isayama</div>
                    <div class="bar-body" id="cat-g-3">30000</div>
                  </div>
                </div>
                <div id="dashboard-card-guests-button" class="dashboard-card-details-button">
                  Ver detalles
                  <i class="bi bi-plus-circle ms-1"></i></div>
              </div>
            </div>
            <div class="col-12 col-lg-7 ms-0 ms-lg-2 mt-2 mt-lg-0 shadow-sm d-flex flex-column dashboard-card">
              <div class="dashboard-card-title">PRÓXIMOS EVENTOS</div>
              <div id="dashboard-event-list">
                <%
                for(int i = 0; i < 7; i++){
                %>
                <div class="dashboard-event row">
                  <div class="col-7">
                    <div class="dashboard-event-title">EVENT NAME EVENT NAME</div>
                    <div class="dashboard-event-date"><i class="bi bi-clock-fill me-1"></i>vie 27 ago - 7:00 pm</div>
                  </div>
                  <div class="col-5 row d-flex flex-column align-items-end ms-auto my-auto">
                    <div class="d-flex flex-row justify-content-end mb-1">
                      <div>
                        <i class="bi bi-ticket-perforated-fill me-2"></i>
                        <div class="d-none d-sm-inline me-2">TICKETS VENDIDOS:</div>
                      </div>
                      <div class="dashboard-event-tickets">100</div>
                    </div>
                    <div class="d-flex flex-row justify-content-end">
                      <div>
                        <i class="bi bi-cash me-2"></i>
                        <div class="d-none d-sm-inline me-2">INGRESOS: </div>
                      </div>
                      <div class="dashboard-event-income">$/.10,000</div>
                    </div>
                    
                  </div>
                </div>
                <%}%>
              </div>
                
                <div id="dashboard-card-event-button" class="dashboard-card-details-button">
                  Ver detalles
                  <i class="bi bi-plus-circle ms-1"></i></div>
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
