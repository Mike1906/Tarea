<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="dominio.*"%>
<%@ page import="negocio.*"%>
<%
String mensaje="";
CtrlPadronElectoral padron=new CtrlPadronElectoral();
String dui=request.getParameter("dui");
boolean exito=padron.borrarPadron(dui);
if (exito==true)
   mensaje="se elimino el padron correctamente";
else
   mensaje="No hay un padrón con el dui indicado";	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar padrón electoral</title>
<link rel="stylesheet" href="foundation/css/foundation.css">
</head>
<body>
	<fieldset>
		<legend>Elimina la informacion del padrón</legend>
		<div class="row">
			<div class="small-8">
				<div class="row">
					<center><%=mensaje%><br>
						<br> <a role="button" aria-label="submit form"
							href="EliminarPadron.html" class="button">Eliminar otro padrón</a> <a
							role="button" aria-label="submit form" href="Main.jsp"
							class="button">Volver al menu</a>
					</center>
				</div>
			</div>
		</div>
	</fieldset>
</body>
</html>