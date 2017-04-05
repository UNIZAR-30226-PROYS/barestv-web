<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Destacado" />
      <jsp:param name="active" value="2" />
</jsp:include>

	<div class="row">
		<div class="page-header">
			<div class="col-md-6">
				
					<h1>
						Destacado de hoy				
					</h1>
					
						
					
				
			</div>
			<div class="col-md-6">
					<h1>
						<small>Establecimiento 1<small>
					</h1>
					<p> Evento 1 (hora), Evento 2 (hora)</p>
			</div>
		</div> 
	</div>
	<hr>
	<div class="row">
		<div class="col-md-12">
			<table class="table">

				<tbody>
				  <tr>
					<td>
						<blockquote>
						<p>
							Establecimiento 1
						</p> 
						<small>Evento 1 (hora), Evento 2 (hora)</small>
						</blockquote>
					</td>
					<td class="boton">
						<button type="button" class="btn btn-primary">
							Destacado
						</button>
					</td>
				  </tr>
				 <tr>
					<td>
						<blockquote>
						<p>
							Establecimiento 2
						</p> 
						<small>Evento 1 (hora), Evento 2 (hora)</small>
						</blockquote>
					</td>
					<td class="boton">
						<button type="button" class="btn btn-primary">
							Destacado
						</button>
					</td>
				  </tr>
				</tbody>
			  </table>
		</div>
	</div>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>