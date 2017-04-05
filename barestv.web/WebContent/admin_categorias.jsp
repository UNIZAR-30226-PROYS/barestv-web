<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Categorias" /> 
      <jsp:param name="active" value="3" /> 
</jsp:include>


	<div class="row">
		<div class="col-md-12">
			<h3>
				
			
			<form role="form" class="form-inline">
				<div class="form-group">
					 
					<label for="exampleInputEmail1">
						Añadir categoria: 
					</label>
                                        <input class="form-control" id="categoria" type="text" name="categoria">
				</div>
				
				
				<button type="submit" class="btn btn-default">
					Guardar
				</button>
			</form>
			</h3>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<tbody>
				  <tr>
					<td>
						
						Categoria 1
						
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
						
						Categoria 2
						
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