<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="negocio.*" %>
    <%@ page import="java.util.*"%>
    <%@ page import="java.text.*"%>
    <%
	String idPartidoPolitico = request.getParameter("idpartido");
	String nombrePartido = request.getParameter("nombrepartido");
	String nombreSecretarioGeneral = request.getParameter("nombresecretario");
	String username = request.getParameter("user");		
	String sfecha=request.getParameter("fechan");
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date fechaDeFundacion = format.parse(sfecha);

	CtrlPartidoPolitico partidopolitico = new CtrlPartidoPolitico();
	boolean exito = partidopolitico.actualizar(idPartidoPolitico,nombrePartido,fechaDeFundacion,nombreSecretarioGeneral,username);
	String mensaje;
	
	if (exito) {
		mensaje = "¡¡ Se actualizo el Partido Politico !!";
	}else {
		mensaje = "¡¡ No se pudo actualizar, codigo (id) incorrecto !!";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Partido Politico</title>
</head>
<body>
<fieldset>
<legend>Inserta nueva informacion al Partido Politico</legend>
  <div class="row">
    <div class="small-8">      
      <div class="row">        
 		<center><%=mensaje%><br><br>
        <a role="button" aria-label="submit form" href="ActualizarPartidoPolitico.html" class="button">Actualizar otro Partido</a>
        <a role="button" aria-label="submit form" href="Main.jsp" class="button">Volver al menu</a>	</center>
      </div>
    </div>
  </div>      
</fieldset>
</body>
</html>
