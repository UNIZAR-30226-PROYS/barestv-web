<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Establecimiento" />
      <jsp:param name="active" value="0" />
</jsp:include>

	<div class="row">
		<div class="col-md-6">
			<div class="thumbnail">
				<img class="img-responsive" alt="Bootstrap Image Preview" src="http://lorempixel.com/680/480/">
				<div class="caption"><p>Editar texto</p></div>
			</div>
		</div>
		<div class="col-md-6">
			<h3>
				Editar datos establecimiento
			</h3>
			<form role="form">
				<div class="form-group">
					 
					<label for="nombre">
						Nombre
					</label>
                                        <input class="form-control" id="nombre" name="nombre" type="text">
				</div>
				<div class="form-group">
					 
					<label for="ubicacion">
						Ubicación
					</label>
					<input class="form-control" id="ubicacion" name="ubicacion" type="text">
				</div>
				<div class="form-group">
					 
					<label for="descripcion">
						Descripcion
					</label>
					<textarea class="form-control" id="descripcion" name="descripcion"></textarea>
				</div> 
				<button type="submit" class="btn btn-default">
					Guardar
				</button>
			</form>
		</div>
	</div>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>