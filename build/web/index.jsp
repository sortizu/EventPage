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
        <div class="col-12 g-0">
          <div
            class="border-0 card shadow overflow-auto bg-danger"
            style="padding: 0px; margin: 0px; gap: 0px; border-radius: 0%"
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
                  />
                </div>
                <div class="carousel-item">
                  <img
                    src="https://cdn.joinnus.com/files/2023/10/utJiOCddtMDvHa1.jpg"
                    class="d-block w-100"
                    alt="..."
                  />
                </div>
                <div class="carousel-item">
                  <img
                    src="https://cdn.joinnus.com/files/2023/10/HgdWELn25DYOgjs.png"
                    class="d-block w-100"
                    alt="..."
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
      <div class="col-12 px-3" style="padding-bottom: 55px">
        <div class="row gap-2">
          <div class="zig-zag"></div>
          <h2 class=" d-flex justify-content-center" style="font-weight: 300;">
            NOVEDADES DESTACADAS
          </h2>
          <div class="col-12 col-sm d-flex justify-content-center" >
            <div class="card event-card" >
              <img
                src="https://s3-us-west-2.amazonaws.com/joinnus.com/user/1586376/64d657bc0d890.jpg"
                class="card-img-top"
                alt="..." 
              />
              <div class="card-body event-card-body">
                <h5 class="card-title">NOVA LIMA 2023</h5>
                <div class="row event-card-text">
                  <div class="col-12 event-card-test-description">
                    Lorem, ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, impedit.
                  </div>
                  <div class="col-12 event-card-test-date">
                    <i class="bi bi-clock-fill"></i>
                    Jue 10 Ago - 7:00
                  </div>
                </div>
                <button
                        type="button"
                        class="btn btn-outline-danger"
                        data-bs-toggle="modal"
                        data-bs-target="#eventDetailModal"
                        data-bs-whatever="@getbootstrap"
                      >
                        COMPRAR TOTAL POR: $20.00
                      </button>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--Navigation bar-->
      <%@include file="navigation_bar.jsp" %>
    </div>
  </body>
</html>
