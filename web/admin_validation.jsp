<%@page import="DAO.UsuarioDAO" %>
<%
    if(session.getAttribute("email")!=null && session.getAttribute("password")!=null){
      String email = (String)session.getAttribute("email");
      String pass = (String)session.getAttribute("password");  
      if(!(new UsuarioDAO().validarAdmin(email, pass))){
        response.sendRedirect("admin_login.jsp");
      } 
    }else{
      response.sendRedirect("admin_login.jsp");
    }
    
    %>