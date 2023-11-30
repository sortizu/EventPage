<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EventPage: Emocionantes eventos con un solo click</title>
    <%@include file="references.jsp" %>
  </head>
  <body style="min-width: 100%;">
    <div class="container-fluid d-flex flex-column vh-100 g-0">
      <!--Header-->
      <%@include file="main_header.jsp" %>
      <!--End of Header-->
      <!--Carrusel de imagenes-->
      <div class="row g-0" >
        <div class="col-12 g-0" >
          <div
            class="border-0 card shadow overflow-auto bg-danger"
            style="padding: 0px; margin: 0px; gap: 0px; border-radius: 0%;"
          >
            <div
              id="carouselExampleIndicators"
              class="carousel slide"
              data-bs-ride="true"
            >
              <div class="carousel-indicators">
                <button
                  type="button"
                  data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="0"
                  class="active"
                  aria-current="true"
                  aria-label="Slide 1"
                ></button>
                <button
                  type="button"
                  data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="1"
                  aria-label="Slide 2"
                ></button>
                <button
                  type="button"
                  data-bs-target="#carouselExampleIndicators"
                  data-bs-slide-to="2"
                  aria-label="Slide 3"
                ></button>
              </div>
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img
                    src="https://cdn.joinnus.com/files/2023/10/dMfeXiRRQLtZ9WX.png"
                    class="d-block w-100"
                    alt="..."
                    style="min-height: 200px;"
                  />
                </div>
                <div class="carousel-item">
                  <img
                    src="https://cdn.joinnus.com/files/2023/10/utJiOCddtMDvHa1.jpg"
                    class="d-block w-100"
                    alt="..."
                    style="min-height: 200px;"
                  />
                </div>
                <div class="carousel-item">
                  <img
                    src="https://cdn.joinnus.com/files/2023/10/HgdWELn25DYOgjs.png"
                    class="d-block w-100"
                    alt="..."
                    style="min-height: 200px;"
                  />
                </div>
              </div>
              <button
                class="carousel-control-prev"
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev"
              >
                <span
                  class="carousel-control-prev-icon"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button
                class="carousel-control-next"
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next"
              >
                <span
                  class="carousel-control-next-icon"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>
        </div>
      </div>
      <!--Search bar-->
      <div class="col-12 d-flex justify-content-center">
        <%@include file="search_bar.jsp" %>
      </div>
      <!--Featured events-->
      <div class="col-12">
        <div class="row" style="padding: 0px;padding-bottom: 55px; margin: 0px; gap: 0px;">
          <div class="col-12 zig-zag"></div>
          <%@page import="DAO.EventoDAO" %>
          <%@page import="java.util.ArrayList" %>
          <%@page import="model.Evento" %>
          <%@page import="java.time.format.DateTimeFormatter" %>
          <%@page import="java.util.Locale" %>
          <%
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE dd MMM '-' HH:mm a", new Locale("es", "ES"));
          EventoDAO eventoDAO = new EventoDAO();
          ArrayList<Evento> eventosDestacados= (ArrayList<Evento>)eventoDAO.listFeatured();
          if(eventosDestacados.size()>0){
          %>
          <h2 class="col-12 d-flex justify-content-center" style="font-weight: 300;">
            NOVEDADES DESTACADAS
          </h2>
          <%
          }
          else{
          %>
          <h3 class="col-12 d-flex justify-content-center align-items-center" style="font-weight: 300;">
            NO HAY CONTENIDO QUE MOSTRAR :(
          </h3>
          <%
          }
          int featuredEventstoShow = 4;
          for(int i=eventosDestacados.size()-1;i>=0 && featuredEventstoShow>0;i--){
            Evento evento = eventosDestacados.get(i);
            var descripcion = evento.getDescripcion();
            if(descripcion.length()>70){
              descripcion = descripcion.substring(0,70)+"...";
            }
          %>
          
          <div class="col-12 col-sm-6 col-lg-3 mb-3 mb-lg-0 d-flex justify-content-center" >
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
          featuredEventstoShow--;}
          %>
        </div>
      </div>
      <!--Navigation bar-->
      <%@include file="navigation_bar.jsp" %>
      <%@include file="event_details_script.jsp" %>
    </div>
  </body>
</html>
