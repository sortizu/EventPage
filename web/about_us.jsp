<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EventPage | Conócenos</title>
    <%@include file="references.jsp" %>
  </head>
  <body>
    <div class="container-fluid d-flex flex-column vh-100 g-0">
      <!--Header-->
      <%@include file="main_header.jsp" %>
      <!--End of Header-->
      <div class="row g-0">
        <!--TITULO DE PAGINA-->
        <h2
          class="col-12 mt-5 d-flex justify-content-center"
          style="font-weight: 300"
        >
          CONÓCENOS
        </h2>
        <div class="zig-zag"></div>
        <div class="col-10 col-sm-8 m-auto py-3">
          <h4>SOBRE LA ORGANIZACIÓN</h4>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Provident,
            incidunt fugit! Adipisci accusantium, molestias corporis deserunt
            nulla illum provident delectus unde odio est, totam, ipsa nam alias
            blanditiis modi neque accusamus! Id, vel. Aliquam architecto nobis
            magnam voluptatibus. A dicta aperiam tempore similique sapiente
            quaerat fugiat assumenda praesentium explicabo voluptatum illum
            facere aut laboriosam facilis, reiciendis, neque temporibus!
            Deserunt voluptate, libero ullam fugit nihil earum repellendus cum
            ducimus, iste aspernatur nesciunt veritatis delectus ad molestias
            quo enim hic debitis quibusdam, atque quidem at? Tempora qui, animi
            vel doloribus expedita dolorem aspernatur beatae laboriosam quia
            quisquam assumenda? Cupiditate voluptatum omnis sunt?
          </p>
          <h4>SOBRE EVENTPAGE</h4>
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Maiores
            deserunt deleniti doloremque fuga delectus omnis odit, excepturi
            accusamus autem ducimus!
          </p>
          <h4>PREGUNTAS FRECUENTES</h4>
          <ul>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
            <li><a href="">¿Lorem ipsum dolor sit amet.?</a></li>
          </ul>
        </div>
        <div class="zig-zag"></div>
        <div class="col-8 m-auto py-3">
          <h4 class="text-center">CONTACTO</h4>
          <form id="mainForm" method="POST" action="" class="d-flex justify-content-center flex-column mb-5">
            <div class="mb-3">
              <label for="event-name" class="col-form-label">Correo:</label>
              <input
                type="email"
                class="form-control modal-form-input"
                id="event-name"
                maxlength="45"
                required
              />
            </div>
            <div class="mb-3">
              <label for="event-description" class="col-form-label"
                >Mensaje:</label
              >
              <textarea
                class="form-control modal-form-input form-input-ignore"
                id="event-description"
                required
              ></textarea>
            </div>
            <button
              type="submit"
              class="btn btn-outline-danger m-auto"
              id="mainFormSubmitButton"
            >
              Enviar
            </button>
          </form>
        </div>
      </div>

      <!--Navigation bar-->
      <%@include file="navigation_bar.jsp" %>
    </div>
  </body>
</html>
