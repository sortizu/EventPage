<!-- Sidebar -->
<div class="bg-white col-12 col-lg-2 p-2 shadow rounded-3 mb-3 mb-lg-0 " id="sidebar">
    <ul
      class="nav nav-pills flex-row flex-lg-column m-auto h-100 justify-content-center"
    >
      <li class="nav-item d-none d-lg-inline" id="hide-button">
        <a href="#" class="nav-link">
          <i class="bi bi-arrow-bar-left" style="display: inline-block"></i>
          <span class="d-none d-md-inline sidebar-option-text">Ocultar</span>
        </a>
      </li>
      <li class="nav-item">
        <a href="dashboard.jsp" class='nav-link <%=pageElementName=="dashboard"?"active":""%>'>
          <i class="bi bi-bar-chart-fill"></i>
          <span class="d-none d-md-inline sidebar-option-text">Dashboard</span>
        </a>
      </li>
      <li class="nav-item">
        <a href="event.jsp" class='nav-link <%=pageElementName=="evento"?"active":""%>'>
          <i class="bi bi-calendar-event"></i>
          <span class="d-none d-md-inline sidebar-option-text">Eventos</span>
        </a>
      </li>
      <li class="nav-item">
        <a href="event_labels.jsp" class='nav-link <%=pageElementName=="categoria"?"active":""%>'>
          <i class="bi bi-tag"></i>
          <span class="d-none d-md-inline sidebar-option-text">Categoria Eventos</span>
        </a>
      </li>
      <li class="nav-item">
        <a href="guest.jsp" class='nav-link <%=pageElementName=="invitado"?"active":""%>'>
          <i class="bi bi-person-workspace"></i>
          <span class="d-none d-md-inline sidebar-option-text">Invitados</span>
        </a>
      </li>
      <li class="nav-item">
        <a href="admins.jsp" class='nav-link <%=pageElementName=="administrador"?"active":""%>'>
          <i class="bi bi-person-fill-lock"></i>
          <span class="d-none d-md-inline sidebar-option-text">Administradores</span>
        </a>
      </li>
      <li class="nav-item">
        <a href="users.jsp" class='nav-link <%=pageElementName=="usuario"?"active":""%>'>
          <i class="bi bi-people-fill"></i>
          <span class="d-none d-md-inline sidebar-option-text">Usuarios</span>
        </a>
      </li>
      <li class="nav-item mt-0 mt-lg-auto">
        <a href="admin_login.jsp" class="nav-link">
          <i class="bi bi-box-arrow-left"></i>
          <span class="d-none d-md-inline sidebar-option-text">Salir</span>
        </a>
      </li>
    </ul>
  </div>
  <!-- End of Sidebar -->