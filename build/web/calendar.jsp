<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EventPage | Calendario</title>
    <%@include file="references.jsp" %>
  </head>
  <body>
    <div class="container-fluid d-flex flex-column vh-100 g-0">
      <!--Header-->
      <%@include file="main_header.jsp" %>
      <!--End of Header-->
      <div class="row g-0 d-flex justify-content-center" style="min-width: 100vw; width: 100vw">
        <!--Carrusel de imagenes-->
        <h2 class="mt-5 d-flex justify-content-center" style="font-weight: 300;">
          CALENDARIO DE EVENTOS
        </h2>
        <div class="zig-zag"></div>
        <div id="carouselExampleFade" class="carousel carousel-dark carousel-fade w-50 my-3" data-bs-ride="carousel">
            <div class="carousel-inner text-center">
              <div class="carousel-item active" >
                11 de Octubre
              </div>
              <div class="carousel-item" >
                12 de Octubre
              </div>
              <div class="carousel-item">
                13 de Octubre
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
            </button>
          </div>
      </div>
      
      <!--Featured events-->
      <div class="col-12 px-3" style="padding-bottom: 55px">
        <div class="row gap-2">
          <div class="col-auto col-sm d-flex justify-content-center">
            <div class="card event-card">
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
                <a href="#" class="btn btn-outline-danger"
                  >Comprar por: $20.00</a
                >
              </div>
            </div>
          </div>
          <div class="col-12 col-sm d-flex justify-content-center">
            <div class="card event-card">
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
                <a href="#" class="btn btn-outline-danger"
                  >Comprar por: $20.00</a
                >
              </div>
            </div>
          </div>
          <div class="col-12 col-sm d-flex justify-content-center">
            <div class="card event-card">
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
                <a href="#" class="btn btn-outline-danger"
                  >Comprar por: $20.00</a
                >
              </div>
            </div>
          </div>
          <div class="col-12 col-sm d-flex justify-content-center">
            <div class="card event-card">
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
                <a href="#" class="btn btn-outline-danger"
                  >Comprar por: $20.00</a
                >
              </div>
            </div>
          </div>

        <div class="col-12 col-sm d-flex justify-content-center">
            <div class="card event-card">
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
                <a href="#" class="btn btn-outline-danger"
                  >Comprar por: $20.00</a
                >
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
