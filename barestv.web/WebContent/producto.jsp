<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<jsp:include page="WEB-INF/jsp/cabecera.jsp">
      <jsp:param name="title" value="Inicio" /> 
</jsp:include>

<!-- Contenido -->
    <div class="row"> 
        <div class="col-md-8">
            <!-- Detalles resumida del producto -->
            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <!-- Imagenes del producto -->
                    <div class="carousel slide" id="carousel-94314">
                        <ol class="carousel-indicators">
                            <li class="" data-slide-to="0" data-target="#carousel-94314">
                            </li>
                            <li data-slide-to="1" data-target="#carousel-94314" class="">
                            </li>
                            <li data-slide-to="2" data-target="#carousel-94314" class="active">
                            </li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item">
                                <s:if test="%{producto.imagenes.size() != 0}">
                                    <img style="width: 100%;" alt="<s:text name="Imagen"/>1" src="<s:property value="producto.getImagen(0)"/>">
                                </s:if>
                                <s:else>
                                    <img alt="Carousel Bootstrap First" src="https://dummyimage.com/500x200/000/fff">
                                    <div class="carousel-caption">
                                        <h4>
                                            Explora un mundo infinito!
                                        </h4>
                                        <p>
                                            Cras justo odio, dapibus ac facilisis in, egestas eget quam. 
    Donec id elit non mi porta gravida at eget metus. 
                                        </p>
                                    </div>
                                </s:else>
                                
                            </div>
                            <div class="item active left">
                                <s:if test="%{producto.imagenes.size() != 0}">
                                    <img style="width: 100%;" alt="<s:text name="Imagen"/>2" src="<s:property value="producto.getImagen(1)"/>">
                                </s:if>
                                <s:else>
                                    <img alt="Carousel Bootstrap First" src="https://dummyimage.com/500x200/000/fff">
                                    <div class="carousel-caption">
                                        <h4>
                                            Explora un mundo infinito!
                                        </h4>
                                        <p>
                                            Cras justo odio, dapibus ac facilisis in, egestas eget quam. 
    Donec id elit non mi porta gravida at eget metus. 
                                        </p>
                                    </div>
                                </s:else>
                            </div>
                            <div class="item next left">
                                <s:if test="%{producto.imagenes.size() != 0}">
                                    <img style="width: 100%;" alt="<s:text name="Imagen"/>3" src="<s:property value="producto.getImagen(2)"/>">
                                </s:if>
                                <s:else>
                                    <img alt="Carousel Bootstrap First" src="https://dummyimage.com/500x200/000/fff">
                                    <div class="carousel-caption">
                                        <h4>
                                            Explora un mundo infinito!
                                        </h4>
                                        <p>
                                            Cras justo odio, dapibus ac facilisis in, egestas eget quam. 
    Donec id elit non mi porta gravida at eget metus. 
                                        </p>
                                    </div>
                                </s:else>
                            </div>
                        </div> <a class="left carousel-control" href="#carousel-94314" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-94314" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    </div>
                    <div class="jumbotron well">
                        <!-- Informacion resumida del producto -->
                        <h3>
                            <s:property value="producto.nombre"/>
                        </h3>
                        <p style="font-size: 15px;">
                            <s:property value="producto.descripcionCorta"/>
                        </p>
                        <p style="font-size: 15px;"><s:property value="producto.ventas"/> <s:text name="Unidadesvendidas"/>  <span style="float:right"> <s:property value="producto.valoracion"/> <span class="glyphicon glyphicon-thumbs-up"></span></span> </p>
                        
                        
                        <p style="text-align: center">
                            <span style="font-size: 24px;color: green; margin-top:5px;margin-right:30px"><s:property value="producto.precio"/>€</span>
                            
                            <!-- boton de compra -->
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                              <s:text name="Comprar"/>
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                  <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel"><s:text name="ACUERDODECOMPRA"/></h4>
                                  </div>
                                  <div class="modal-body">
                                    <h3><s:property value="producto.nombre"/></h3>
                                    <s:if test="#session.usuario != null">
                            
                                        <p><s:text name="ACUERDODECOMPRAcoment"/>
                                        </P>
                                        <p style="text-align:center;"><span style="font-size: 44px;color: green; margin-top:5px;margin-right:30px"><s:property value="producto.precio"/>€</span></p>
                                 
                                    </s:if>
                                    <s:else>
                                        <p class="text-warning"><s:text name="ACUERDODECOMPRAcoment2"/></p>
                                    </s:else>
                                </div>
                                 <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="Cancelar"/></button>
                                    <s:if test="#session.usuario != null">
                                        <form style="display: inline-block;" action="<s:url action="comprarProducto"/>" method="post">
                                        <input type="hidden" name="idProducto" value="<s:property value="producto.idProducto"/>"/>
                                        <button  type="submit" class="btn btn-primary"><s:text name="Aceptar"/></button>    
                                    </form>
                                    </s:if>
                                </div>
                                </div>
                              </div>
                            </div>
                            <!-- fin boton de compra -->
                        
                    </div>
                </div>
                <div class="col-md-2">
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <!-- Detalles del vendedor -->
            <div class="row">
                <!-- Imagen del vendedor -->
                <h4 style="text-align:center"><s:text name="Detallesdelvendedor"/></h4>
                <p style="text-align:center">
                    <s:if test="producto.creador.imagen != 'null'">                 
                        <img alt="<s:text name="Imagendelvendedor"/>" style="width:200;heigh:100;" src="<s:property value='producto.creador.imagen'/>">
                    </s:if>
                    <s:else>
                        <img alt="<s:text name="Imagendelvendedor"/>" style="width:200;heigh:100;" src="http://www.freeiconspng.com/uploads/msn-people-person-profile-user-icon--icon-search-engine-11.png">
                    </s:else>
                </p>
                <!-- Informacion del vendedor -->
                <dl class="dl-horizontal">
                    <dt>
                        <s:text name="Vendedor"/>
                    </dt>
                    <dd>
                        <s:property value="producto.creador.nombre"/>
                    </dd>
                    <dt>
                        <s:text name="correo"/>
                    </dt>
                    <dd>
                        <s:property value="producto.creador.correo"/>
                    </dd>
                    <dt>
                        <s:text name="Usuariodesde"/>
                    </dt>
                    <dd>
                        <s:property value="producto.creador.fecha"/>
                    </dd>
                    <dt>
                        <s:text name="Puntos"/> 
                    </dt>
                    <dd>
                        <s:property value="producto.creador.valoracion"/><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true" style="font-size: 12px;"></span>
                    </dd>
                        
                </dl>
                    
            </div>
                
        </div>
    </div>

    <!-- Etiquetas -->
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12">
                    <h3>
                        <s:text name="Tags"/>
                    </h3>
                    <div class="s_tag">
                        <ul style="list-style-type:none ;"class="tag-area clearfix ">
                            <s:iterator value="producto.etiquetas" var="c">
                                <li class="tag" >
                                    <a href="<s:url action="inicio"/>?filtro=<s:property value="nombre"/>">
                                        <s:property value="nombre"/>
                                    </a>
                                    <form style="display:inline;" action="<s:url action="EliminarEtiqueta"/>" method="post">
                                        <input type="hidden" name="idEtiqueta" value="<s:property value="idEtiqueta"/>"/>
                                        <input type="hidden" name="idProducto" value="<s:property value="producto.idProducto"/>"/>
                                        <button id="<s:property value="nombre"/>" style="display:none;" type="submit" class="close" aria-label="Close"><span aria-hidden="true">×</span></button>
                                    </form>
                                </li>
                            </s:iterator>
                            
                            <s:if test="#session.usuario != null">
                                <button  class="btn-add" data-toggle="modal" data-target="#EditEtiq">
                                    <span class="one"></span>
                                    <span class="two"></span>
                                </button>
                            </s:if>
                            <s:if test="#session.usuario.idUsuario == producto.idUsuario">
                                <button  class="btn-delete" onclick="display()">
                                    <span class="one"></span>
                                    <span class="two"></span>
                                </button>
                            </s:if>
                            
                            <div class="modal fade" id="EditEtiq" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title" id="myModalLabel"><s:text name="Anyadiretiqueta"/></h4>
                                        </div>
                                        <div class="modal-body">
                                        
                                            <form action="<s:url action="crearEtiqueta"/>" method="post">
                                                <textarea class="form-control" rows="3" placeholder="<s:text name="Tags"/>" name="nombre"></textarea> 
                                                <input type="hidden" name="idProducto" value="<s:property value="producto.idProducto"/>"/>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal"><s:text name="Cancelar"/></button>
                                            <button  type="submit" class="btn btn-primary"><s:text name="Aceptar"/></button>
                                        </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </ul> 
                    </div>  
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
    
    <!-- Valoracion de un producto previamente comprado -->
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12">
                    <h3>
                        <s:text name="Ayudanosamejorar"/>
                    </h3>
           
                    <p><s:text name="valcoment"/>
                    </p>
                    <s:if test="esComprador">
                        <!-- Boton de like y dislike -->
                        <form style="display:inline;" action="<s:url action="likeAjuego"/>" method="post">
                            <input type="hidden" name="idProducto" value="<s:property value="producto.idProducto"/>"/>
                            <button class="btn btn-primary btn-lg glyphicon glyphicon-thumbs-up" type="submit"></button>                                        
                        </form>
                        <form style="display:inline;" action="<s:url action="noLikeAJuego"/>" method="post">
                            <input type="hidden" name="idProducto" value="<s:property value="producto.idProducto"/>"/>
                            <button class="btn btn-danger btn-lg glyphicon glyphicon-thumbs-down" type="submit"></button>                                       
                        </form>
                        <s:if test="hasActionMessages()">
                            <div class="alert alert-dismissable alert-success">
                                 
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                                    ×
                                </button>
                                <p><s:actionmessage/></p>
                            </div>
                        </s:if>
                    </s:if>
                    <s:else>
                        <!-- Mensaje si el cliente no ha comprado el producto -->
                        <p class="text-warning"><s:text name="valcoment2"/></p>
                    </s:else>
                        
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
    
    <!-- Descripcion larga del producto -->
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12">
                    <h3>
                        <s:text name="Descripcionlarga"/>
                    </h3>
                    <p>
                        <s:property value="producto.descripcionLarga"/>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>

    <!-- Comentarios de la gente-->
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <div class="row">
                <div class="col-md-12">
                    <h3>
                        <s:text name="Comentarios"/>
                    </h3>
                    
                    <s:if test="#session.usuario != null">
                        <!-- Se puede comentar si esta logeado -->
                        <div style="padding: 15px;margin-bottom:18px">
                            <form action="<s:url action="crearComentario"/>" method="post">
                                <textarea class="form-control" rows="3" placeholder="<s:text name="Introducircomentario"/>" name="comentario"></textarea> 
                                <input type="hidden" name="idProducto" value="<s:property value="producto.idProducto"/>"/>
                                <button style="float:none;margin-top:10px" type="submit" class="btn btn-success"><s:text name="Aceptar"/></button>
                            </form>
                        </div>
                    </s:if>
                    <s:else>
                        <div style="padding: 15px;margin-bottom:18px">
                            <p class="text-warning"><s:text name="Introducircomentariocoment"/>
                            </p> 
                        </div>
                    </s:else>
                    
                    <s:iterator value="producto.comentarios" var="c">
                        <!-- Mostrar todos los comentarios -->
                        <blockquote>
                            
                            <s:if test="#session.usuario != null && #session.usuario.idUsuario == creador.idUsuario">
                                <div class="a" style="display:none" >
                                    <!-- Editar comentario -->
                                    
                                        <s:url action="borrarComentario" var="urlTag1" >
                                            <s:param name="fecha"><s:property value="fecha"/></s:param>
                                        </s:url>
                                    <form action="<s:url action="editComentario"/>" method="post">
                                        <textarea style="font-size: 17.5px;" class="form-control" rows="3" placeholder="Textarea" name="comentario"><s:property value="comentario"/></textarea> 
                                        <input type="hidden" name="idProducto" value="<s:property value="producto.idProducto"/>"/>
                                        <input type="hidden" name="fecha" value="<s:property value="fecha"/>"/>
                                        <p><small><s:property value="creador.nombre"/>[<s:property value="creador.correo"/>]<cite><s:property value="fecha"/></cite></small></p>
                                        <span style="float:none;margin-top:10px" class="btn btn-success apagaForm"><s:text name="Cancelar"/></span>
                                        
                                        <button style="float:none;margin-top:10px;margin-right:50px" type="submit" class="btn btn-warning"><s:text name="Editar"/></button>
                                        
                                        
                                        <a class="btn btn-danger button2" style="margin-top:10px;" href="<s:property value="#urlTag1" />&idProducto=<s:property value="idProducto"/>" class="btn btn-alert">
                                            <s:text name="Eliminar"/>
                                        </a>
                                        
                                    </form>
      
                                </div>
                                <div class="b">
                                    <!-- Mostar comentario -->
                                    <p>
                                        <s:property value="comentario"/>
                                    </p> 
                                    <small><s:property value="creador.nombre"/>[<s:property value="creador.correo"/>]<cite><s:property value="fecha"/></cite>
                                        
                                    </small>
                                    <span><button style="float:none;margin-top:10px" class="btn btn-success activaForm"><s:text name="Editar"/></button></span>
                                 </div>
                                    
                                
                            </s:if>
                            <s:else>
                                <div>                               
                                <p>
                                    <s:property value="comentario"/>
                                </p> 
                                <small><s:property value="creador.nombre"/>[<s:property value="creador.correo"/>]<cite><s:property value="fecha"/></cite></small>
                                </div>
                            </s:else>                            
                        </blockquote>
                    </s:iterator>                              
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>

    <!-- Scripts, se puede trasladar a un fichero aparte -->
    <script>
    $('.activaForm').click(function(){
        //Some code
        $(this).parent().parent().parent().children(".a").css("display","initial");
        $(this).parent().parent().parent().children(".b").css("display","none");
    });
    $('.apagaForm').click(function(){
        //Some code
        $(this).parent().parent().parent().children(".b").css("display","initial");
        $(this).parent().parent().parent().children(".a").css("display","none");
    });
    </script>
    
    <script type="text/javascript">  
        function display(){   
            var close = document.getElementsByClassName("close");


            for (i = 0; i < close.length; i++) {
                if(close[i].style.display=="none") { 
                    close[i].style.display="";  
                }
                else{ 
                    close[i].style.display="none";   
                }  
       
            }
        }  
    </script>   
<jsp:include page="WEB-INF/jsp/piePagina.jsp"/>
