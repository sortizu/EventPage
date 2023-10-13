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
