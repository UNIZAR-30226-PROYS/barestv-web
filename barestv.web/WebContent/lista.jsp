<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Inicio" /> 
</jsp:include>

<!-- Fila del Buscador -->
    <div class="row">
        <div class="col-md-1">
        </div>
        <div class="col-md-10">
            <nav class="navbar navbar-default" role="navigation" style="background-color: gainsboro;">
                <div class="navbar-header">
                     
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" aria-expanded="false" data-target="#bs-example-navbar-collapse-2">
                    <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                </button> 
                <a href="#" style="width: 160px;margin-left: 10px;" class="navbar-brand"></a></div>
                
                <!-- Seleccionar categorias famosas -->        
                <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-2" aria-expanded="false" style="height: 0.8px;">
                    <ul class="nav navbar-nav">
                        <s:if test="%{filtro.equals('mmorpg')}">
                            <li class="active">
                        </s:if>
                        <s:else>
                            <li>
                        </s:else>
                            <a href="<s:url action="inicio"/>?filtro=mmorpg">MMORPG</a>
                            </li>
                        <s:if test="%{filtro.equals('moba')}">
                            <li class="active">
                        </s:if>
                        <s:else>
                            <li>
                        </s:else>
                            <a href="<s:url action="inicio"/>?filtro=moba">MOBA</a>
                            </li>
                        <s:if test="%{filtro.equals('survival')}">
                            <li class="active">
                        </s:if>
                        <s:else>
                            <li>
                        </s:else>
                            <a href="<s:url action="inicio"/>?filtro=survival">SURVIVAL</a>
                            </li>
                        <s:if test="%{filtro.equals('action')}">
                            <li class="active">
                        </s:if>
                        <s:else>
                            <li>
                        </s:else>
                            <a href="<s:url action="inicio"/>?filtro=action">ACTION</a>
                        </li>
                                
                    </ul>

                    <!-- Buscador -->
                    <form action="<s:url action="iniciob"/>" method="post" class="navbar-form navbar-left" role="search" style="float: right !important;">
                        <div class="form-group">
                            <input class="form-control" type="text" name="filtro" placeholder="<s:text name="buscarjuego"/>">
                        </div> 
                        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                    </form>
                            
                </div>
                        
            </nav>
        </div>
        <div class="col-md-1">
        </div>
    </div>

    <!-- Lista de articulos -->
    <s:if test="%{productos != null}">
        <!-- Si hay producto en la tienda -->
        <s:iterator value="productos" var="p">
            <div class="row" style="margin-bottom: 16px;margin-top: 5px;">
                <div class="col-md-2">
                </div>
                <div class="col-md-8" style="background-color: #efefefe6;">
                    <div class="row">
                        <div class="col-md-3">
                            <!-- Portada de cada producto -->
                            <s:if test="%{imagenes.size() != 0}">
                            
                                <img style="width:120;height:100;" alt="<s:text name="Imagen"/>1" src="<s:property value="getImagen(0)"/>"/>
                            
                            </s:if>
                            <s:else>
                                <img alt="Bootstrap Image Preview" src="https://dummyimage.com/120x100/000/fff"/>
                            </s:else>
                        </div>
                        <div class="col-md-9">
                            <!-- Informacion resumida -->
                            <div class="row">
                                <div class="col-md-6">
                                    <h4><s:property  value="nombre"/></h4>
                                    <p><s:property value="descripcionCorta"/></p>
                                    
                                </div>
                                <div class="col-md-3">
                                    <p style="margin-top: 8px;"><s:text name="Puntos"/>: <s:property value="valoracion"/> <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true" style="font-size: 12px;"></span></p>
                                    <p><s:text name="Vendedor"/>: <s:property value="creador.nick"/></p> 
                                    <p><s:text name="Ventas"/>: <s:property value="Ventas"/></p> 
                                    
                                </div>
                                
                                <div class="col-md-3">
                                    
                                    <p style="font-size: 24px;color: green; margin-top:5px;"><s:property value="precio"/>&nbsp;<span style="font-size:15px;" class="glyphicon glyphicon-euro"></span></p>
                                    
                                    <!-- Boton de entrar -->
                                    <form method="post" action="mostrarProducto">
                                        <s:hidden name="idProducto" value="%{idProducto}"/>
                                        <button type="submit"><span class="glyphicon glyphicon-circle-arrow-right" aria-hidden="true" style="font-size: 32px;"></span></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                </div>
            </div>
        </s:iterator>
    </s:if>
    <s:else>
        <div class="row" style="margin-bottom: 16px;margin-top: 5px;">
            <div class="col-md-2">
            </div>
            <div class="col-md-8" style="background-color: #efefefe6;">
            
                <h1> <s:text name="Nohayproductosenlatienda"/></h1>
            </div>
        </div>
    </s:else>
    
<jsp:include page="WEB-INF/jsp/piePagina.jsp"/>
