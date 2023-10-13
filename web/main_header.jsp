<%-- Document : main_header Created on : 13 Oct 2023, 01:09:14 Author : sortizu
--%> <%@ page contentType="text/html; charset=UTF-8" %>
<!--Header-->
<nav
  class="navbar navbar-default fixed-top d-flex align-items-start"
  style="color: white; padding: 0px 50px"
>
  <a
    href="index.jsp"
    class="m-auto m-sm-0"
    style="text-decoration: none; color: white"
  >
    <div
      class="card bg-danger"
      style="
        border: 0px;
        border-radius: 0px 0px 10px 10px;
        filter: opacity(0.9);
      "
    >
      <span class="narbar-brand h4 m-2" style="font-weight: 800">
        <i class="bi bi-universal-access-circle"></i>
        EVENTPAGE
      </span>
    </div>
  </a>
  <div class="d-flex flex-row gap-2">
    <button
      type="button"
      class="btn btn-danger"
      data-bs-toggle="modal"
      data-bs-target="#registerModal"
      data-bs-whatever="@getbootstrap"
      style="
      min-width: 125px;
      height: 30px;
      margin: 0px;
      padding: 0px;
      gap: 0px;
      margin-top: 10px;
      "
    >
      Registro
    </button>
    <button
      type="button"
      class="btn btn-danger"
      data-bs-toggle="modal"
      data-bs-target="#loginModal"
      data-bs-whatever="@getbootstrap"
      style="
      min-width: 125px;
      height: 30px;
      margin: 0px;
      padding: 0px;
      gap: 0px;
      margin-top: 10px;
      "
    >
      Iniciar sesión
    </button>
    <button
      type="button"
      class="btn btn-danger"
      data-bs-toggle="modal"
      data-bs-target="#profileModal"
      data-bs-whatever="@getbootstrap"
      style="
      min-width: 125px;
      height: 30px;
      margin: 0px;
      padding: 0px;
      gap: 0px;
      margin-top: 10px;
      "
    >
    <i class="bi bi-person-fill-gear"></i>
      Mi Perfil
    </button>
  </div>
</nav>
<!--Login modal-->
<div
  class="modal fade"
  id="loginModal"
  tabindex="-1"
  aria-labelledby="exampleModalLabel"
  aria-hidden="true"
>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Iniciar sesión</h1>
        <button
          type="button"
          class="btn-close"
          data-bs-dismiss="modal"
          aria-label="Close"
        ></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="login-email" class="col-form-label">Correo:</label>
            <input
              type="email"
              class="form-control modal-form-input"
              id="login-email"
              required
            />
          </div>
          <div class="mb-3">
            <label for="login-password" class="col-form-label"
              >Contraseña:</label
            >
            <input
              type="password"
              class="form-control modal-form-input"
              id="login-password"
              maxlength="45"
              required
            />
          </div>
          <div class="form-check m-2">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Recuerda mi sesión</label>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
          Cancelar
        </button>
        <button type="button" class="btn btn-outline-danger">Acceder</button>
      </div>
    </div>
  </div>
</div>
<!--Register modal-->
<div
  class="modal fade"
  id="registerModal"
  tabindex="-1"
  aria-labelledby="exampleModalLabel"
  aria-hidden="true"
>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Registro</h1>
        <button
          type="button"
          class="btn-close"
          data-bs-dismiss="modal"
          aria-label="Close"
        ></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="event-name" class="col-form-label"
              >Nombres:</label
            >
            <input
              type="text"
              class="form-control modal-form-input"
              id="event-name"
              maxlength="45"
              required
            />
          </div>
          <div class="mb-3">
              <label for="event-name" class="col-form-label"
                >Apellidos:</label
              >
              <input
                type="text"
                class="form-control modal-form-input"
                id="event-name"
                maxlength="45"
                required
              />
          </div>
          <div class="mb-3">
              <label for="event-name" class="col-form-label"
                >Email:</label
              >
              <input
                type="email"
                class="form-control modal-form-input"
                id="event-name"
                maxlength="45"
                required
              />
            </div>
            <div class="mb-3">
              <label for="event-name" class="col-form-label"
                >Contraseña:</label
              >
              <input
                type="password"
                class="form-control modal-form-input"
                id="event-name"
                maxlength="45"
                required
              />
            </div>
            <div class="mb-3">
              <label for="event-name" class="col-form-label"
                >DNI:</label
              >
              <input
                type="number"
                class="form-control modal-form-input"
                id="event-name"
                minlength="9"
                min="0"
                required
              />
            </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
          Cancelar
        </button>
        <button type="button" class="btn btn-outline-danger">Registrarme</button>
      </div>
    </div>
  </div>
</div>
<!--Profile modal-->
<div
  class="modal fade"
  id="profileModal"
  tabindex="-1"
  aria-labelledby="exampleModalLabel"
  aria-hidden="true"
>
<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
  <div class="modal-content">
    <div class="modal-body m-0 p-0 g-0">
      <div class="card text-center border-0">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item" role="presentation">
              <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Mi Perfil</button>
            </li>
            <li class="nav-item" role="presentation">
              <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Carrito de compras</button>
            </li>
            <li class="nav-item" role="presentation">
              <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">Historial de compras</button>
            </li>
          </ul>
        </div>
        <div class="card-body tab-content">
          <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
            <form >
              <div class="mb-3 d-flex align-items-start flex-column">
                <label for="event-name" class="col-form-label"
                  >Nombres:</label
                >
                <input
                  type="text"
                  class="form-control modal-form-input"
                  id="event-name"
                  maxlength="45"
                  required
                />
              </div>
              <div class="mb-3 d-flex align-items-start flex-column">
                  <label for="event-name" class="col-form-label"
                    >Apellidos:</label
                  >
                  <input
                    type="text"
                    class="form-control modal-form-input"
                    id="event-name"
                    maxlength="45"
                    required
                  />
              </div>
              <div class="mb-3 d-flex align-items-start flex-column">
                  <label for="event-name" class="col-form-label"
                    >Email:</label
                  >
                  <input
                    type="email"
                    class="form-control modal-form-input"
                    id="event-name"
                    maxlength="45"
                    required
                  />
                </div>
                <div class="mb-3 d-flex align-items-start flex-column">
                  <label for="event-name" class="col-form-label"
                    >Contraseña:</label
                  >
                  <input
                    type="password"
                    class="form-control modal-form-input"
                    id="event-name"
                    maxlength="45"
                    required
                  />
                </div>
                <div class="mb-3 d-flex align-items-start flex-column">
                  <label for="event-name" class="col-form-label"
                    >DNI:</label
                  >
                  <input
                    type="number"
                    class="form-control modal-form-input"
                    id="event-name"
                    minlength="9"
                    min="0"
                    required
                  />
                </div>
            </form>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
              Cancelar
            </button>
            <button type="button" class="btn btn-outline-danger">Guardar cambios</button>
          </div>
  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
    <div class="row gap-2">
      <!-- Event -->
      <div class="col-12">
        <div class="card">
          <div class="row p-2">
            <div class="col-md-8 d-flex justify-content-center align-items-start flex-column">
              <h5 class="card-title">NOVA LIMA 2023</h5>
              <div>
                <i class="bi bi-clock-fill"></i> Jue 10 Ago - 7:00
              </div>
            </div>
            <div class="col-md-4 d-flex justify-content-center align-items-center" style="margin: 0px; padding: 0px;gap: 0px;">
              <h2>$20.00</h2>
            </div>
          </div>
        </div>
      </div>
      <!-- End of Event -->
      <!-- Event -->
      <div class="col-12">
        <div class="card">
          <div class="row p-2">
            <div class="col-md-8 d-flex justify-content-center align-items-start flex-column">
              <h5 class="card-title">NOVA LIMA 2023</h5>
              <div>
                <i class="bi bi-clock-fill"></i> Jue 10 Ago - 7:00
              </div>
            </div>
            <div class="col-md-4 d-flex justify-content-center align-items-center" style="margin: 0px; padding: 0px;gap: 0px;">
              <h2>$20.00</h2>
            </div>
          </div>
        </div>
      </div>
      <!-- End of Event -->
      <!-- Event -->
      <div class="col-12">
        <div class="card">
          <div class="row p-2">
            <div class="col-md-8 d-flex justify-content-center align-items-start flex-column">
              <h5 class="card-title">NOVA LIMA 2023</h5>
              <div>
                <i class="bi bi-clock-fill"></i> Jue 10 Ago - 7:00
              </div>
            </div>
            <div class="col-md-4 d-flex justify-content-center align-items-center" style="margin: 0px; padding: 0px;gap: 0px;">
              <h2>$20.00</h2>
            </div>
          </div>
        </div>
      </div>
      <!-- End of Event -->
      <div class="col-12">
        <button type="button" class="btn btn-outline-danger">Comprar todo: $60.00</button>
      </div>
    </div>
  </div>
  <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
    <h3>NO TIENES TICKETS COMPRADOS</h3>
  </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<!--End of Header-->
