<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="negocio.*" %>
    <%@ page import="java.util.*"%>
    <%@ page import="java.text.*"%>
    <%
	String idPartidoPolitico = request.getParameter("idpartidopolitico");
	String nombrePartido = request.getParameter("nombrepartido");
	SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
	Date fechaDeFundacion = format.parse("fecha");
	String nombreSecretarioGeneral = request.getParameter("nombresecretario");
	String username = request.getParameter("usuario");		
	
	CtrlPartidoPolitico partidopolitico = new CtrlPartidoPolitico();
	boolean exito = partidopolitico.crearPartidoPolitico(idPartidoPolitico,nombrePartido,fechaDeFundacion,nombreSecretarioGeneral,username);
	String mensaje;
	
	if (exito) {
		mensaje = "Se creo el Partido Politico";
	}else {
		mensaje = "Ya existe ese Partido Politico";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar Partido Politico</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
<fieldset>
<legend>Inserta la informacion del Partido Politico</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 <center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="IngresarPartidoPolitico.html" class="button">Ingresar otro partido</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>