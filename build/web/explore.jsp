<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EventPage | Explorar</title>
    <%@include file="references.jsp" %>
  </head>
  <body>
    <div class="container-fluid d-flex flex-column vh-100 g-0">
      <!--Header-->
      <%@include file="main_header.jsp" %>
      <!--End of Header-->
      <div class="row g-0" >
        <!--TITULO DE PAGINA-->
        <h2 class="mt-5 d-flex justify-content-center" style="font-weight: 300;">
          EXPLORA LOS EVENTOS DISPONIBLES
        </h2>
        <div class="zig-zag"></div>
      </div>
      <!--Search bar-->
      <div class="col-12 d-flex justify-content-center">
        <%@include file="search_bar.jsp" %>
        <button type="button" class="btn btn-outline-danger my-3" data-bs-toggle="modal" data-bs-target="#filterModal" data-bs-whatever="@getbootstrap">
          <i class="bi bi-filter"></i>
          Filtros</button>
      </div>
      <!--Filter Search Modal-->
      <div class="modal fade" id="filterModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">Filtrar búsqueda</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form>
                <div class="mb-3">
                    <label for="event-date" class="col-form-label"
                      >Fecha:</label
                    >
                    <input
                      type="date"
                      class="form-control modal-form-input"
                      id="event-date"
                      required
                    />
                  </div>
                  <div class="mb-3">
                    <label for="event-label" class="col-form-label"
                      >Categoría:</label
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
                    <label for="event-price" class="col-form-label"
                      >Costo de mínimo entrada:</label
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
                  <div class="mb-3">
                    <label for="event-price" class="col-form-label"
                      >Costo máximo de entrada:</label
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
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button type="button" class="btn btn-outline-danger">Aplicar filtros</button>
            </div>
          </div>
        </div>
      </div>
      <!--Searched events-->
      <div class="col-12">
        <div class="row" style="padding: 0px;padding-bottom: 55px; margin: 0px; gap: 0px;">
          
          <%@page import="DAO.EventoDAO" %>
          <%@page import="java.util.ArrayList" %>
          <%@page import="model.Evento" %>
          <%@page import="java.time.format.DateTimeFormatter" %>
          <%@page import="java.util.Locale" %>
          <%
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE dd MMM '-' HH:mm a", new Locale("es", "ES"));
          EventoDAO eventoDAO = new EventoDAO();
          ArrayList<Evento> eventosDestacados= (ArrayList<Evento>)eventoDAO.listAll();
          if(eventosDestacados.size()==0){
          %>
          <h3 class="col-12 d-flex justify-content-center align-items-center" style="font-weight: 300;">
            NO HAY CONTENIDO QUE MOSTRAR :(
          </h3>
          <%
          }
          %>
 
          <%
          for(int i=0;i<eventosDestacados.size();i++){
            Evento evento = eventosDestacados.get(i);
            var descripcion = evento.getDescripcion();
            if(descripcion.length()>70){
              descripcion = descripcion.substring(0,70)+"...";
            }
          %>
          
          <div class="col-12 col-sm-6 col-lg-3 mb-3 d-flex justify-content-center" >
            <div class="card event-card h-100" style="overflow: hidden;">
              <img src="${pageContext.request.contextPath}/img/events_images/<%=evento.getIdEvento()%>.jpg" 
                alt="Foto de evento" 
                style="max-height: 200px;min-height: 200px;"
                onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/img/placeholders/no_image.jpg'">
              <div class="card-body event-card-body d-flex flex-column">
                <h5 class="card-title" style="font-size: 20px;"><%=evento.getNombreEvento()%></h5>
                <div class="row event-card-text d-flex flex-column">
                  <div class="col-12 event-card-test-description" style="font-size: 16px;"> 
                    <%=descripcion%>
                  </div>
                </div>
                <div class="align-self-end mt-auto mx-0 w-100">
                  <div class="col-12 event-card-test-date mb-2" style="font-size: 16px;">
                    <i class="bi bi-clock-fill"></i>
                    <%=evento.getFecha().format(formatter)%>
                  </div>
                  <center>
                  <button
                          type="button"
                          class="btn btn-outline-danger mx-auto showEventDetails"
                          data-id='<%=evento.getIdEvento()%>'
                        >
                          COMPRAR ENTRADA POR: $<%=evento.getCosto()%>
                        </button>
                      </center>
                </div>
                

              </div>
            </div>
          </div>
          <%
          }
          %>
        </div>
      </div>
      <!--Navigation bar-->
      <%@include file="navigation_bar.jsp" %>
      <%@include file="event_details_script.jsp" %>
      <%@include file="buy_ticket_script.jsp" %>
    </div>
  </body>
</html>
