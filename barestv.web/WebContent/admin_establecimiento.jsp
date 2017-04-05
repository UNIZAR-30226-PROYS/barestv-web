<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Establecimientos" />
      <jsp:param name="active" value="0" />
</jsp:include>
	<div class="row">
		<div class="col-md-12">
			<h3>
				Establecimientos registrados
			</h3>
			<p>Lista de establecimientos en el sistema, desde aqui se podra modificar o eliminar un establecimiento.
			<table class="table">
				<thead>
				  <tr>
					<th>Nombre del establecimiento</th>
					<th>Modificar los atributos</th>
					<th>Eliminar del sistema</th>
				  </tr>
				</thead>
				<tbody>
				  <tr>
					<td>
						<blockquote>
						<p>
							Establecimiento 1
						</p> 
						<small>Ubicacion</small>
						</blockquote>
					</td>
					<td class="boton">
						<button type="button" class="btn btn-primary">
							Modificar
						</button>
					</td>
					<td class="boton">
						<button type="button" class="btn btn-danger">
							Eliminar
						</button>
					</td>
				  </tr>
				  <tr>
					<td>
						<blockquote>
						<p>
							Establecimiento 2
						</p> 
						<small>Ubicacion</small>
						</blockquote>
					</td>
					<td class="boton">
						<button type="button" class="btn btn-primary">
							Modificar
						</button>
					</td>
					<td class="boton">
						<button type="button" class="btn btn-danger">
							Eliminar
						</button>
					</td>
				  </tr>
				</tbody>
			  </table>
		</div>
		
	</div>
	
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>