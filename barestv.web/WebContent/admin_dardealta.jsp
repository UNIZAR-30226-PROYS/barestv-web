<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Dar de alta" />
      <jsp:param name="active" value="1" />
</jsp:include>
	<div class="row">
		<div class="col-md-12">
			<h3>
				Añadir establecimiento
			</h3>
			<form role="form">
				<div class="form-group">
					 
					<label for="usuario">
						Nickbar
					</label>
					<input class="form-control" id="usuario" name="usuario" type="text">
				</div>
				<div class="form-group">
					 
					<label for="password">
						Contraseña
					</label>
					<input class="form-control" id="password" name="password" type="password">
				</div>
				<div class="form-group">
					 
					<label for="password2">
						Repetir contraseña
					</label>
					<input class="form-control" id="password2" name="password2" type="password">
				</div>
				<button type="submit" class="btn btn-default">
					Guardar
				</button>
			</form>
		</div>
	</div>
	<hr>

	<div class="row">
		<div class="col-md-12">
			<h3>
				Lista espera
			</h3>
			<table class="table">
				<thead>
					<tr>
						<th>Nickbar</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				  <tr>
					<td>
						
						<p>
							Establecimiento 1
						</p>
						
					</td>
					<td class="boton">
						<button type="button" class="btn btn-primary">
							Aceptar
						</button>
					</td class="boton">
					<td>
						<button type="button" class="btn btn-danger">
							Rechazar
						</button>
					</td>
				  </tr>
				 <tr>
					<td>
						
						<p>
							Usuario 2
						</p> 
						<p>
							Establecimiento 2
						</p>
						
					</td>
					<td class="boton">
						<button type="button" class="btn btn-primary">
							Aceptar
						</button>
					</td>
					<td class="boton">
						<button type="button" class="btn btn-danger">
							Rechazar
						</button>
					</td>
				  </tr>
				</tbody>
			  </table>
		</div>
		
	</div>

<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>