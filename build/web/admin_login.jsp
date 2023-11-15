<!DOCTYPE html>
<html lang="es">
<head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <%@include file="references.jsp" %>
</head>
<body class="bg-light vh-100">
    <div class="container-fluid d-flex align-content-center align-items-center flex-column justify-content-center h-100">
        <span class="my-4 d-flex align-content-center align-items-center flex-column justify-content-center">
            <i class="bi bi-universal-access-circle h2"></i>
            <h2 class="text-justify h2" style="font-weight: 800;"><%=configuracion.getNombrePagina()%> | ADMIN SYSTEM</h2>
          </span>
        <div class="card shadow-lg bg-white border-0 m-3 p-3 gap-0" style="min-width: 300px;width: 300px;">
            <form class="w-100" id="loginForm" method="POST" action="AdminLoginServlet">
                <div class="mb-3">
                  <label for="event-name" class="col-form-label"
                    >Correo:</label
                  >
                  <input
                    type="email"
                    class="form-control modal-form-input"
                    id="email"
                    name="email"
                    required
                  />
                </div>
                <div class="mb-1">
                    <label for="event-name" class="col-form-label"
                      >Contraseña:</label
                    >
                    <input
                      type="password"
                      class="form-control modal-form-input"
                      id="password"
                      name="password"
                      required
                    />
                  </div>
                <div class="form-check my-2">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Recuerda mi sesión</label>
                </div>
                <button type="submit" class="w-100 btn btn-primary">Ingresar</button>
              </form>
        </div>
    </div>
</body>
</html>