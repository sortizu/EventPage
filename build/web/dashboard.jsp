<%@page import="DAO.UsuarioDAO" %>
<%@page import="model.Usuario" %>
<%@page import="DAO.EventoDAO" %>
<%@page import="model.Evento" %>
<%@page import="java.util.ArrayList" %>
<% 
//Estas variables se deben de cambiar en el jsp de cada pagina 
//En teoria solo con estas variables se puede definir a qué servlet se le hará la petición
String apiLink = "#"; //Aqui se debe de poner la ruta de la servlet que agrega 
String pageElementName = "dashboard"; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
String pageElementPluralName = ""; //Aqui se debe de poner el nombre del elemento que se está manejando en la pagina 
%>
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
        <div class="col mx-auto mx-lg-3 d-flex flex-column gap-2">
          <div class="row gap-3 gap-lg-0">
            <div class="col-12 col-lg-6 p-0 ">
              <div class="row m-0 ">DASHBOARD</div>
              <div class="row">
                <div class="col-6 py-1">
                  <div class="bg-white rounded border-0 shadow-sm d-flex flex-column justify-content-center align-items-center p-2" 
                  style="color:dodgerblue;cursor: pointer;height: 100%;">
                    <div style="font-size: 24px;">INGRESOS</div>
                    <div style="font-size: 32px; font-weight: 800;">S/. 0.0</div>
                  </div>
                </div>
                <div class="col-6 py-1">
                  <div class="bg-white rounded border-0 shadow-sm d-flex flex-column justify-content-center align-items-center p-2" 
                  style="color:dodgerblue;cursor: pointer;height: 100%;">
                    <div class="card-title p-0 m-0" style="font-size: 24px;">NUEVOS USUARIOS (HOY)</div>
                    <%
          UsuarioDAO usuarioRegistroDao = new UsuarioDAO();
          ArrayList<Usuario> usuariosRegistro = (ArrayList<Usuario>)usuarioRegistroDao.listAll();
            int nuevosRegistros=0;
            for(Usuario u:usuariosRegistro){
              if(!u.isAdmin()){
                nuevosRegistros++;
              }
            }
            %>
                    <div class="card-subtitle" style="font-size: 32px; font-weight: 800;"><%=nuevosRegistros%></div>
                  </div>
                </div>
                <div class="col-6 py-1">
                  <div class="bg-white rounded border-0 shadow-sm d-flex flex-column justify-content-center align-items-center p-2" 
                  style="color:dodgerblue;cursor: pointer;height: 100%;">
                  <div style="font-size: 24px;">%TICKETS X CATEGORÍA</div>
                  <div style="font-size: 32px; font-weight: 800;">Taller 50%</div>
                  </div>
                </div>
                <div class="col-6 py-1">
                  <div class="bg-white rounded border-0 shadow-sm d-flex flex-column justify-content-center align-items-center p-2" 
                  style="color:dodgerblue;cursor: pointer;">
                  <div style="font-size: 24px;">INGRESOS</div>
                  <div style="font-size: 32px; font-weight: 800;">S/. 0.0</div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-12 col-lg-3 p-0 p-md-1">
              <div class="row" style="min-height: 5%">
                <div class="col">ADMINISTRADORES</div>
              </div>
              <div class="row m-auto" style="min-height: 90%">
                
                <%
          UsuarioDAO usuariodao = new UsuarioDAO();
          ArrayList<Usuario> usuarios = (ArrayList<Usuario>)usuariodao.listAll();
            int adminsToShow=4;
          for(int i = usuarios.size()-1; i>=0&&adminsToShow>0; i--){
            if(usuarios.get(i).isAdmin()){
              
        %>
        <div class="col-12 p-1">
          <div class="card d-flex justify-content-center align-items-center h-100 border-0 shadow-sm" style="cursor: pointer;">
            <h5 style="font-weight: 100;"><i class="bi bi-person-fill-lock"></i><%=usuarios.get(i).getNombres()+" "+usuarios.get(i).getApellidos()%></h5>
          </div>
        </div>
        <%adminsToShow--;}}%>
              </div>
            </div>
            <div class="col-12 col-lg-3 p-0 p-md-1">
              <div class="row" style="min-height: 5%">
                <div class="col">PRÓXIMOS EVENTOS (HOY)</div>
              </div>
              <div class="row m-auto" style="min-height: 90%">
                <%
          EventoDAO eventodao = new EventoDAO();
          ArrayList<Evento> eventos = (ArrayList<Evento>)eventodao.listAll();
            int eventsToShow=4;
          for(int i = eventos.size()-1; i>=0&&eventsToShow>0; i--){
              
        %>
        <div class="col-12 p-1">
          <div class="card d-flex justify-content-center align-items-center h-100 border-0 shadow-sm" style="cursor: pointer;">
            <h5 style="font-weight: 100;"><%=eventos.get(i).getNombreEvento()%></h5>
            <h5 style="font-weight: 100;"><i class="bi bi-clock-fill"></i><%=eventos.get(i).getFecha()%></h5>
          </div>
        </div>
        <%eventsToShow--;}%>
              </div>
            </div>
          </div>
          <div class="row flex-grow-1" style="min-height: 300px;">
            <div class="col-12 m-0 p-0 gap-0">
              <div class="rounded-3 h-100 w-100 bg-primary border-0 shadow-sm p-2 d-flex flex-column" style="color:white">
                <h5  style="color: white;font-weight: 100;position: relative; left: 0px;">HISTOGRAMA DE VENTAS</h5>
                <div class="d-flex justify-content-center align-items-end gap-3 h-100 w-100">
                  <div style="background-color: white;height: 10%; width: 5%;color:steelblue; font-size: 16px;"> 10%</div>
                <div style="background-color: white;height: 20%; width: 5%;color: steelblue;font-size: 16px;"> 20%</div>
                <div style="background-color: white;height: 30%; width: 5%;color: steelblue;font-size: 16px;"> 30%</div>
                <div style="background-color: white;height: 40%; width: 5%;color: steelblue;font-size: 16px;"> 40%</div>
                <div style="background-color: white;height: 50%; width: 5%;color: steelblue;font-size: 16px;"> 50%</div>
                <div style="background-color: white;height: 30%; width: 5%;color: steelblue;font-size: 16px;"> 30%</div>
                </div>
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
