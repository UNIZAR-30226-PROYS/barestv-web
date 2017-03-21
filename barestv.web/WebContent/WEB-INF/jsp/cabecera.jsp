<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${param.title}</title>
        <meta name="description" content="Practica1 SI">
        <meta name="author" content="Daniel Martinez, Jorge Martinez y Xian Pan">

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/scripts.js"></script>
    
    </head>
    <body style="background-color: rgba;">

        <div class="container-fluid">
            <!-- Cabecera -->
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-md-12">
                    <!-- Header -->
                    <nav class="navbar navbar-default navbar-inverse navbar-static-top" role="navigation">
                        <div class="navbar-header">
                             
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                 <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                            </button> <a class="navbar-brand" href="#" style="width: 160px;margin-left: 10px;"><span class="glyphicon glyphicon-tower" aria-hidden="true"></span>
                                    G2team.io</a>
                        </div>
                        
                        <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" aria-expanded="false" style="height: 0.8px;">
                            <ul class="nav navbar-nav">
                                <!-- Boton Tienda -->
                                <li>
                                    <a href="<s:url  action="inicio" />"><s:text name="Tienda"></s:text></a>
                                </li>
                                
                                
                            </ul>
                            
                            <ul class="nav navbar-nav navbar-right" style="margin-right: 10px;">
                                <!-- Cambio de idioma -->
                                <li>
                                    <a href="<s:url action="inicio"/>?request_locale=ch">CH</a>
                                </li>
                                <li>
                                    <a href="<s:url action="inicio"/>?request_locale=es">ES</a>
                                </li>
                                <li>
                                    <a href="<s:url action="inicio"/>?request_locale=en">EN</a>
                                </li>
                            <%  if (session.getAttribute("usuario") != null){%>
                                <!-- Cuenta -->
                                <li class="dropdown">
                                     <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">${session.usuario.nombre}<strong class="caret"></strong></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="<s:url  action="mostrarCuenta" />"><s:text name="Micuenta"/></a>
                                        </li>
                                        <li>
                                            <a href="<s:url  action="cerrarSesion" />"><s:text name="Cerrarsesion"/></a>
                                        </li>
                                        
                                        
                                    </ul>
                                </li>
                                    
                            
                            <%  }else{%>
                                
                                <li>    
                                     <a href="<s:url  action="login" />"><s:text name="iniciarSesion"/></a>
                                    
                                </li>
                                    
                            <%  }%>
                            </ul>   
                            
                        </div>
                        
                    </nav>
                    
                </div>
            </div>
