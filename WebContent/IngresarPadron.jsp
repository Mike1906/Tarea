<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dominio.*"%>
<%@ page import="negocio.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%
String mensaje="";
CtrlPadronElectoral padron=new CtrlPadronElectoral();
int idurna=Integer.parseInt(request.getParameter("idurna"));
String dui=request.getParameter("dui");
String nombre=request.getParameter("nombres");
String apellidos=request.getParameter("apellidos");
String sfechanac=request.getParameter("fechanac");
SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
Date fechanac = format.parse(sfechanac);

String domicilio=request.getParameter("domicilio");
String estadovotacion=request.getParameter("estado");
String username=request.getParameter("username");
Urna urna=new Urna();
urna.setIdurna(idurna);



boolean exito=padron.crearPadron(dui,nombre,apellidos,domicilio,estadovotacion,urna,username,fechanac);
if (exito==true)
   mensaje="se ingreso el padron correctamente";
else
   mensaje="hubo un error al ingresar el padron, ya existe ese dui";	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingresar padrón electoral</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
	<fieldset>
		<legend>Ingresa la información del padrón electoral</legend>
		<div class="row">
			<div class="small-8">
				<div class="row">
					<center><%=mensaje%><br>
						<br> <a role="button" aria-label="submit form"
							href="IngresarPadron.html" class="button">Ingresar otro
							padrón electoral</a> <a role="button" aria-label="submit form"
							href="Main.jsp" class="button">Volver al menu</a>
					</center>
				</div>
			</div>
		</div>
	</fieldset>
</body>
</html>