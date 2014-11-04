<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarea IGF</title>
<link href="themes/js-image-slider.css" rel="stylesheet" type="text/css" />
<script src="themes/js-image-slider.js" type="text/javascript"></script> 	
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>

<body>

<nav class="top-bar" data-topbar role="navigation">
  <ul class="title-area">
    <li class="name">
      <h1><a href="#">Tarea de Ingenieria de Software</a></h1>
    </li>
  </ul>
  <section class="top-bar-section">
    <!-- Right Nav Section -->
    <ul class="right">
      <li><a href="#">Inicio</a></li>
      <li class="divider hide-for-small"></li>
      <li class="has-dropdown">
        <a href="#">Grupo de Trabajo</a>
        <ul class="dropdown">
          <li><a href="#">Miguel</a></li>
          <li><a href="#">Vladimir</a></li>
          <li><a href="#">Mauricio</a></li>
          <li><a href="#">Sergio</a></li>
          <li><a href="#">Franklin</a></li>                  
        </ul>
        <li class="divider hide-for-small"></li>
        <li><a href="login.jsp">Iniciar Sesión</a></li>
      </li>
    </ul>
  </section>
</nav>

<br><br>
<div id="sliderFrame">				
	<div id="slider">
        <img src="images/s01.jpg" alt="" />
        <img src="images/s02.jpg" alt="" />
		<img src="images/s03.jpg"/>				
	</div>
</div>	
</body>
</html>