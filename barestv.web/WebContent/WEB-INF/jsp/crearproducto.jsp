<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Crear producto" /> 
</jsp:include>

<!--Formulario para introducir detalles de producto-->
            
    <div class="row">
        <div class="col-md-1">
        </div>
        <div class="col-md-9">
            <s:if test="%{edicion}">
                <!-- Si es editar pagina -->
                <h3 style="text-align: center;margin-bottom:40px;"><s:text name="EditarProducto"/></h3>
                    
            </s:if>
            <s:else>
                <!-- Si es anyadir pagin -->
                <h3 style="text-align: center;margin-bottom:40px;"><s:text name="AnyadirProducto"/></h3>            
            </s:else>
               <s:if test="hasActionErrors()">
                <div class="alert alert-dismissable alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                        ×
                    </button>
                    <h4><s:text name="sorry"/></h4> <strong><s:actionerror/></strong>.
                </div>
            </s:if>
            <s:if test="%{edicion}">
                <p><s:text name="EditarProductoComent"/>
                <form action="editarProducto" method="post">
                    <s:textfield id="producto.idProducto" cssClass="form-control" type="hidden" name="producto.idProducto" value="%{producto.idProducto}"/>
            </s:if>
            <s:else>
                <p><s:text name="AnyadirProductoComent"/>
                <form action="crearProducto" method="post">
            </s:else>
                <!-- Formulario -->                    
                <div class="form-group">
                    <label for="producto.nombre"><s:text name="Nombredeljuego"/></label>
                    <s:textfield id="producto.nombre" cssClass="form-control" type="text" name="producto.nombre" value="%{producto.nombre}"/>
                </div>
                <div class="form-group">         
                    <label for="producto.precio"><s:text name="Precio"/></label>
                    <s:textfield id="producto.precio" cssClass="form-control" type="number" step="0.01" min="0" name="producto.precio" value="%{producto.precio}"/>
                </div>
                <div class="form-group">
                    <label for="producto.descripcionCorta"><s:text name="Descripcioncorta"/></label>
                     <s:textarea id="producto.descripcionCorta"  cssClass="form-control" cols="50" rows="2" name="producto.descripcionCorta" value="%{producto.descripcionCorta}"></s:textarea>
                </div>
                <div class="form-group">
                    <label for="producto.descripcionLarga"><s:text name="Descripcionlarga"/></label>
                    <s:textarea id="producto.descripcionLarga"  cssClass="form-control" cols="80" rows="10" name="producto.descripcionLarga" value="%{producto.descripcionLarga}"></s:textarea>
                </div>
                <div class="form-group">
                    <label for="imagen1"><s:text name="Urlimagen"/> 1</label>
                    <s:textfield id="imagen1" cssClass="form-control" type="text" name="imagen1" value="%{imagen1}"/>
                </div>
                <div class="form-group">
                    <label for="imagen2"><s:text name="Urlimagen"/> 2</label>
                    <s:textfield id="imagen2" cssClass="form-control" type="text" name="imagen2" value="%{imagen2}"/>
                </div>
                <div class="form-group">
                    <label for="imagen3"><s:text name="Urlimagen"/> 3</label>
                    <s:textfield id="imagen3" cssClass="form-control" type="text" name="imagen3" value="%{imagen3}"/>
                </div>
                <s:if test="%{edicion}">
                    <button type="submit" class="btn btn-success"><s:text name="Terminaredicion"/></button>
                </s:if>
                <s:else>
                    <button type="submit" class="btn btn-success"><s:text name="AnyadirProducto"/></button>
                </s:else>                   
            </form>
        </div>
        <div class="col-md-2">
        </div>
    </div>
<jsp:include page="WEB-INF/jsp/piePagina.jsp"/> 