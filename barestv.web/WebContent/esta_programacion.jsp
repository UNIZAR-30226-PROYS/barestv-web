<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Programacion" />
      <jsp:param name="active" value="1" />
</jsp:include>

	<div class="row">
		<div class="col-md-12">
			<h3>
				Añadir evento
			</h3>
			<form role="form">
				<div class="form-group">
					 
					<label for="email">
						Nombre evento
					</label>
					<input class="form-control" id="email" name="email" type="email">
				</div>
				<div class="form-group">
					 
					<label for="descripcion">
						Descripcion
					</label>
					<textarea class="form-control" id="descripcion" name="descripcion"></textarea>
				</div>
				<div class="form-group">
					 
					<label for="fecha">
						Fecha
					</label> y
                                        <label for="hora">
						hora
					</label>
					<br/>
					<input class="form-control-inline" id="fecha" name="fecha" type="date"> 
					<input class="form-control-inline" id="hora" name="hora-desde" type="time"> -
					<input class="form-control-inline" id="hora" name="hora-hasta" type="time">
				</div>
				<div class="form-group">
					 
					<label for="categoria">
						Categoria
					</label>
					<select class="form-control" id="categoria" name="categoria">
						<option>Deporte</option>
						<option>Noticia</option>
						<option>Serie</option>
						<option>Pelicula</option>
					  </select>
				</div>
				<button type="submit" class="btn btn-default">
					Guardar
				</button>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h3>
				Programacion
			</h3>
			
			<table class="table">
				<thead>
				  <tr>
					<th>24/03/2017</th>
					<th></th>
					<th></th>
				  </tr>
				</thead>
				<tbody>
				  <tr>
					<td>
						<blockquote>
						<p>
							Evento 1
						</p> 
						<small>Ejemplo de descripcion para el evento. Ejemplo de descripcion para el evento. Ejemplo de descripcion para el evento.</small>
						<small>Hora: 9:00 - 11:00</small>
						<small>Categoria: Deporte</small>
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
							Evento 2
						</p> 
						<small>Ejemplo de descripcion para el evento. Ejemplo de descripcion para el evento. Ejemplo de descripcion para el evento.</small>
						<small>Hora: 9:00 - 11:00</small>
						<small>Categoria: Deporte</small>
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
			  
			<table class="table">
				<thead>
				  <tr>
					<th>25/03/2017</th>
					<th></th>
					<th></th>
				  </tr>
				</thead>
				<tbody>
				  <tr>
					<td>
						<blockquote>
						<p>
							Evento 1
						</p> 
						<small>Ejemplo de descripcion para el evento. Ejemplo de descripcion para el evento. Ejemplo de descripcion para el evento.</small>
						<small>Hora: 9:00 - 11:00</small>
						<small>Categoria: Deporte</small>
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
							Evento 2
						</p> 
						<small>Ejemplo de descripcion para el evento. Ejemplo de descripcion para el evento. Ejemplo de descripcion para el evento.</small>
						<small>Hora: 9:00 - 11:00</small>
						<small>Categoria: Deporte</small>
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