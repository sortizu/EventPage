<%@page import="DAO.UsuarioDAO" %>
<%
    if(session.getAttribute("email")!=null && session.getAttribute("password")!=null){
      String email = (String)session.getAttribute("email");
      String pass = (String)session.getAttribute("password");  
      int id_admin=new UsuarioDAO().validarAdmin(email, pass);
      if(id_admin<0){
        response.sendRedirect("admin_login.jsp");
      } 
    }else{
      response.sendRedirect("admin_login.jsp");
    }
    
    %>