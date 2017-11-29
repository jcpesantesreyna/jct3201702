<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetHeader.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
			<h3>Lista</h3>
			
		
		
			<table class="table table-hover">
				<thead>
					<th>Fecha inicio</th>
				     <th>Fecha de entrega</th>
				      <th>detalle</th>
 				       <th>Cliente</th> 
				        <th>Costo</th>
				         <th>estado</th>
				           <th>usuario</th>
				           <th></th>
				</thead>
				<tbody>
					<c:forEach items="${lista}" var="Orden">
						<tr>
							<td>${Orden.fecha_inicio}</td>		
							<td>${Orden.fecha_entrega}</td>	
							<td>${Orden.detalle}</td>
							<td>${Orden.cliente}</td>	
							<td>${Orden.costo}</td>
							<td>${Orden.estado}</td>
							<td>${Orden.usuario.sesion}</td>
							
							<td><a href="${pageContext.request.contextPath}/ProcesarOrdenesPendientes?idorden=${Orden.idOrdentrabajo}">Procesar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/>
			
         </div>
    </div>
</div>
<jsp:include page="/WEB-INF/views/includes/MasterIntranetFooter.jsp"></jsp:include>