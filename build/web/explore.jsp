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
                      <%@page import="DAO.CategoriaEventoDAO" %>
                      <%@page import="model.CategoriaEvento" %>
                      <%@page import="java.util.ArrayList" %>
                      <%
                      CategoriaEventoDAO listaDeCategoriasDao = new CategoriaEventoDAO();
                        ArrayList<CategoriaEvento> listaDeCategorias = (ArrayList<CategoriaEvento>)listaDeCategoriasDao.listAll();
                        for(CategoriaEvento categoriaEvento : listaDeCategorias){
                      %>
                        <option value='<%=categoriaEvento.getIdCategoriaEvento()%>'><%=categoriaEvento.getNombreCategoria()%></option>
                      <%}%>
                    </select>
                  </div>
                  <div class="mb-3">
                    <label for="event-price-min" class="col-form-label"
                      >Costo de mínimo entrada:</label
                    >
                    <div class="input-group">
                      <span class="input-group-text">$</span>
                      <input
                        type="number"
                        class="form-control modal-form-input"
                        id="event-price-min"
                        name="event-price-min"
                        min="0"
                        required
                      />
                    </div>
                  </div>
                  <div class="mb-3">
                    <label for="event-price-max" class="col-form-label"
                      >Costo máximo de entrada:</label
                    >
                    <div class="input-group">
                      <span class="input-group-text">$</span>
                      <input
                        type="number"
                        class="form-control modal-form-input"
                        id="event-price-max"
                        name="event-price-max"
                        min="0"
                        required
                      />
                    </div>
                  </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button type="button" class="btn btn-outline-danger" id="applyFilters">Aplicar filtros</button>
            </div>
          </div>
        </div>
      </div>
      <!--Searched events-->
      <div class="col-12">
        <div class="row" id="search-results" style="padding: 0px;padding-bottom: 55px; margin: 0px; gap: 0px;">
          
          <%@page import="DAO.EventoDAO" %>
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
              <img src="<%=evento.getImagenUrl()%>" 
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
    </div>
  </body>
  <script>
    $(document).ready(function () {
      $("#search-button").click(function () {
        var searchQuery = $("#search-bar").val();
        $.ajax({
          url: "BuscarEventosServlet",
          type: "GET",
          data: { "search_query": searchQuery },
          success: function (data) {
            actualizarResultadosBusqueda(data);
          },
        });
      });
      $("#applyFilters").click(function(){
        var searchQuery = $("#search-bar").val();
        var eventDate = $("#event-date").val();
        var eventLabel = $("#event-label").val();
        var eventPriceMin = $("#event-price-min").val();
        var eventPriceMax = $("#event-price-max").val();
        //window.alert(eventDate+" "+eventLabel+" "+eventPriceMin+" "+eventPriceMax);
        
        $.ajax({
          url: "AplicarFiltrosServlet",
          type: "GET",
          data: { "search_query": searchQuery, "event_date": eventDate, "event_label": eventLabel, "event_price_min": eventPriceMin, "event_price_max": eventPriceMax },
          success: function (data) {
            actualizarResultadosBusqueda(data);
          }
        });
        
      });
      function actualizarResultadosBusqueda(data){
        $("#filterModal").modal("hide");
            $("#search-results").html("");
            for(var id in data){
              var evento = data[id];
              var originalHTML = $("#search-results").html();
              $("#search-results").html(
                originalHTML+
                "<div class='col-12 col-sm-6 col-lg-3 mb-3 d-flex justify-content-center' >"+
                "<div class='card event-card h-100' style='overflow: hidden;'>"+
                "<img src='"+evento["imagen_url"]+"' alt='Foto de evento' style='max-height: 200px;min-height: 200px;' onerror=\"this.onerror=null; this.src='${pageContext.request.contextPath}/img/placeholders/no_image.jpg'\">"+
                "<div class='card-body event-card-body d-flex flex-column'>"+
                    "<h5 class='card-title' style='font-size: 20px;'>"+evento["nombre_evento"]+"</h5>"+
                    "<div class='row event-card-text d-flex flex-column'>"+
                      "<div class='col-12 event-card-test-description' style='font-size: 16px;'>"+
                      evento["descripcion"].substring(0,70)+
                      "</div>"+
                    "</div>"+
                    "<div class='align-self-end mt-auto mx-0 w-100'>"+
                      "<div class='col-12 event-card-test-date mb-2' style='font-size: 16px;'>"+
                        "<i class='bi bi-clock-fill'></i>"+
                        " "+evento["fecha"]+
                      "</div>"+
                      "<center>"+
                        "<button type='button' class='btn btn-outline-danger mx-auto showEventDetails' data-id='"+evento["id_evento"]+"'>"+
                        "COMPRAR ENTRADA POR: $"+ evento["costo"]+
                        "</button>"+
                       "</center>"+
                    "</div>"+
                  "</div>"+
                "</div>"+
              "</div>"
              );
            }
            $("showEventDetails").click(function(){
              var idEvento = $(this).attr("data-id");
              
            });
            if(data.length==0){
              $("#search-results").html(
                "<h5 class='col-12 d-flex justify-content-center align-items-center' style='font-weight: 300;'>"+
                  "NO SE HAN ENCONTRADO RESULTADOS DE ACUERDO A TU BÚSQUEDA :("+
                "</h5>"
              );
            }
      }
    });
  </script>
</html>


