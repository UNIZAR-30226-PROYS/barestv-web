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
<s:if test="#context['struts.actionMapping'].name=='editCategoria'">
                        <form role="form" class="form-inline" method="post" action="<s:url action="editCategoria"/>">
				<div class="form-group">
					<label for="nombreCat"> Editar categor&#xED;a: </label> 
                                        <s:textfield cssClass="form-control" id="nombreCatNuevo" name="nombreCatNuevo" type="text" value="%{nombreCat}"/>
                                        <s:hidden cssClass="form-control" id="nombreCat" name="nombreCat" value="%{nombreCat}"/>
				</div>
				<button type="submit" class="btn btn-default">Guardar</button>
			</form>
</s:if>
<s:else>
                        <form role="form" class="form-inline" method="post" action="<s:url action="addCategoria"/>">
				<div class="form-group">
                                <label for="nombreCat"> Añadir categor&#xED;a: </label> 
                                        <s:textfield cssClass="form-control" id="nombreCat" name="nombreCat" type="text" value=""/>
				</div>
				<button type="submit" class="btn btn-default">Guardar</button>
			</form>
</s:else>

		</h3>
	</div>
</div>
<div class="row">
    <s:if test="hasActionErrors()">
        <!-- Mensajes de error -->
        <div class="alert alert-dismissable alert-danger">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                ×
            </button>
            <h4><s:actionerror/></h4>.
        </div>
    </s:if>
    <s:if test="hasActionMessages()">
        <!-- Mensaje de exito -->
        <div class="alert alert-dismissable alert-success">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                ×
            </button>
            <h4><s:actionmessage/></h4>。
        </div>
    </s:if>

</div>
<hr>
<div class="row">
	<div class="col-md-12">
		<table class="table">
			<tbody>
                            <s:iterator value="categorias" var="cat">
				<tr>
					<td><s:property value="#cat.nombreCat"/></td>
					<td class="boton">
                                            <form role="form" method="post" action="<s:url action="editCategoria"/>">
						<button type="submit" class="btn btn-primary">Modificar</button>
                                                <input type="hidden" value="<s:property value="#cat.nombreCat"/>" name="nombreCat"/>
                                            </form>
					</td>
					<td class="boton">
                                            <form role="form" method="post" action="<s:url action="removeCategoria"/>">
						<button type="submit" class="btn btn-danger">Eliminar</button>
                                                <input type="hidden" value="<s:property value="#cat.nombreCat"/>" name="nombreCat"/>
                                            </form>
					</td>
                                </tr>
                            </s:iterator>    
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"></jsp:include>