<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetHeader.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
			<h3>Lista</h3>
			
		
		<td><a href="${pageContext.request.contextPath}/nuevoServicio">Nuevo</a></td>
			<table class="table table-hover">
				<thead>
					<th>ID</th>
				     <th>Descripcion</th>
				      
 				       
				     
				           <th></th>
				</thead>
				<tbody>
					<c:forEach items="${lista}" var="servicio">
						<tr>
							<td>${servicio.idservicio}</td>		
							<td>${servicio.descripcion}</td>	
						
							
							<td><a href="${pageContext.request.contextPath}/editarServicio?idservicio=${servicio.idservicio}">Modificar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/>
			
         </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetFooter.jsp"></jsp:include>