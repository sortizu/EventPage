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
        <div class="col mx-auto">
          <div class="row h-100 mx-auto py-3 py-lg-0">
            <div class="h-50 col-12 col-lg-6">
              <div class="row" style="min-height: 5%">
                <div class="col">DASHBOARD</div>
              </div>
              <div class="row" style="min-height: 90%">
                <div class="col-6 p-1">
                  <div class="card h-100 border-0 shadow p-2 bg-primary" style="color: white;cursor: pointer;">
                    <div class="card-title">INGRESOS</div>
                    <div class="card-subtitle">S/. 0.0</div>
                  </div>
                </div>
                <div class="col-6 p-1">
                  <div class="card h-100 border-0 shadow p-2 bg-primary" style="color: white;cursor: pointer;">
                    <div class="card-title">REGISTROS</div>
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
                    <div class="card-subtitle"><%=nuevosRegistros%></div>
                  </div>
                </div>
                <div class="col-6 p-1">
                  <div class="card h-100 border-0 shadow p-2 bg-primary" style="color: white;cursor: pointer;">
                    <div class="card-title">CATEGORIA EVENTO X USUARIOS</div>
                    <div class="card-subtitle"> </div>
                  </div>
                </div>
                <div class="col-6 p-1">
                  <div class="card h-100 border-0 shadow p-2 bg-primary" style="color: white;cursor: pointer;">
                    <div class="card-title">EVENTOS X USUARIOS</div>
                    <div class="card-subtitle"> </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="h-50 col-12 col-lg-3">
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
            <div class="h-50 col-12 col-lg-3">
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
            <div class="h-50 col-12 m-auto g-2">
              <div class="card h-100 w-100 bg-primary border-0 shadow-sm p-2" style="color:white">
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
