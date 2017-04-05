<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Usuario" />
      <jsp:param name="active" value="-2" />
</jsp:include>

	<div class="row">
		<div class="col-xs-12 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
			<h3>
				Cambiar contraseña
			</h3>
			<form role="form">
				<div class="form-group">
					 
					<label for="password">
						Antigua contraseña
					</label>
					<input class="form-control" id="exampleInputEmail1" name="xxx" type="password">
				</div>
				<div class="form-group">
					 
					<label for="password-nueva">
						Nueva constraseña
					</label>
					<input class="form-control" id="password-nueva" name="password-nueva" type="password">
				</div>
				<div class="form-group">
					 
					<label for="password-nueva2">
						Repetir contraseña
					</label>
					<input class="form-control" id="password-nueva2" name="password-nueva2" type="password">
				</div>
				<button type="submit" class="btn btn-default center-block">
					Guardar
				</button>
			</form>
		</div>
	</div>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>