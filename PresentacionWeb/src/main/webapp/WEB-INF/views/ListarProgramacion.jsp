<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetHeader.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
			<h3>Lista</h3>
			
		
		<td><a href="${pageContext.request.contextPath}/nuevaProgramacion">Nuevo</a></td>
			<table class="table table-hover">
				<thead>
					<th>ID</th>
					 <th>Servicio</th>
					  <th>Responsable</th>
				     <th>turno</th>
				     <th>lunes</th>
				     <th>martes</th>
				     <th>miercoles</th>
				     <th>Jueves</th>
				     <th>Viernes</th>
				     <th>sabado</th>
				     <th>estado</th>
				      
 				       
				     
				           <th></th>
				</thead>
				<tbody>
					<c:forEach items="${lista}" var="item">
						<tr>
							<td>${item.idprogramacion}</td>		
							<td>${item.servicio.descripcion}</td>	
							<td>${item.responsable.descripcion}</td>
							<td>${item.turno}</td>
							<td>${item.dialun}</td>
							<td>${item.diamar}</td>
							<td>${item.diamie}</td>
							<td>${item.diajue}</td>
							<td>${item.diavie}</td>
							<td>${item.diasab}</td>
							<td>${item.estado}</td>
							
						
							
							<td><a href="${pageContext.request.contextPath}/editarProgramacion?idprogramacion=${item.idprogramacion}">Modificar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/>
			
         </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetFooter.jsp"></jsp:include></html>