<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="dominio.*" %>
     <%@ page import="negocio.*" %>
     <%@ page import="java.text.*" %>
     <%@ page import="java.util.*" %>
<%
String mensaje="";
CtrlPadronElectoral padron=new CtrlPadronElectoral();

String dui=request.getParameter("dui");
String nombre=request.getParameter("nombre");
String apellidos=request.getParameter("apellidos");
String domicilio=request.getParameter("domicilio");
String estadovotacion=request.getParameter("estadovotacion");
int idurna=Integer.parseInt(request.getParameter("idurna"));
String username=request.getParameter("username");
String sfechanac=request.getParameter("fechanac");

SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
Date fechanac = format.parse(sfechanac);

Urna urna=new Urna();
urna.setIdurna(idurna);

boolean exito=padron.actualizaPadron(dui, nombre, apellidos, domicilio, estadovotacion, idurna, username, fechanac);

if (exito==true)
   mensaje="se actualizo el Padron Electoral correctamente";
else
   mensaje="hubo un error al actualizar el Padron Electoral, no existe el dui";	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar padrón electoral</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
	<fieldset>
		<legend>Actualiza la información del padrón electoral</legend>
		<div class="row">
			<div class="small-8">
				<div class="row">
					<center><%=mensaje%><br>
						<br> <a role="button" aria-label="submit form"
							href="ActualizarPadron.html" class="button">actualizar otro
							padrón electoral</a> <a role="button" aria-label="submit form"
							href="Main.jsp" class="button">Volver al menu</a>
					</center>
				</div>
			</div>
		</div>
	</fieldset>
</body>
</html>