<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetHeader.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="actualizarResponsable" method="get">
  Descripcion de Responsable:<br>
  <input type="text" name="descripcion" value="${responsable.descripcion}"><br>
  <input type="hidden"name="idresponsable" value="${responsable.idresposanble}" >
  <input type="submit" value="Enviar"> 
</form> 
</body>
</html>