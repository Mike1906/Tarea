<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iniciar Sesión</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>

<body> 
<%--menu--%>
<nav class="top-bar hide-for-small" style="">
          <ul class="title-area">
            <!-- Title Area -->
            <li class="name">
              <h1>
                <a href="#">
                  Tarea de Ingenieria de Software
                </a>
              </h1>
            </li>
            <li class="toggle-topbar"><a href="#"></a></li>
          </ul>
       <section class="top-bar-section">          
            <!-- Right Nav Section -->            
            <ul class="right">
              <li><a href="index.jsp">Inicio</a></li>
              <li class="divider hide-for-small"></li>
              <li><a href="login.jsp">Iniciar Sesión</a></li>
            </ul>
      </section>
</nav>

<%--login--%>
<fieldset>
    <legend>Ingrese su nombre de usuario y contraseña</legend>
  <div class="row">
    <div class="small-8">    
     
      <div class="row">
        <div class="small-3 columns">
          <label for="right-label" class="right inline">Usuario</label>
        </div>
        <div class="small-9 columns">
          <input type="text" id="right-label" placeholder="username" name="usu" requerid>
        </div>
      </div>
      
      <div class="row">
        <div class="small-3 columns">
          <label for="right-label" class="right inline">Contraseña</label>
        </div>
        <div class="small-9 columns">
          <input type="password" id="right-label" placeholder="Password" name="pass" requerid>
        </div>        
        <center><a role="button" aria-label="submit form" href="Main.jsp" class="button">Ingresar</a></center>       
      </div>
           
    </div>
  </div>      
  </fieldset> 
</body>
</html>