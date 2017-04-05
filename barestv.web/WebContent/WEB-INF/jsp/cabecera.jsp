<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>                    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>${param.title}</title>

<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

 <link href="css/style.css" rel="stylesheet">
 <script src="js/jquery.js"></script>
 <script src="js/bootstrap.js"></script>
 <script src="js/scripts.js"></script>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">

						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						
						<a class="brand" href="#"><img src="fonts/rsz2_barestv.png" height="48px" alt="Bares TV"></a>
						
					</div>
				
					

			
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
							<% String a = request.getParameter("active"); %>
							<% if(session.getAttribute("usuario")!=null && session.getAttribute("admin")!= null){ %>
							<ul class="nav navbar-nav">
								<li <% if (a!=null && a.equals("0")){%>class="active" <%}%>>
									<a href="<s:url  action="getEstablecimientos" />">Establecimientos</a>
								</li>
								<li <% if (a!=null && a.equals("1")){%>class="active" <%}%>>
									<a href="<s:url  action="getDardealta" />">Dar de alta</a>
								</li>
								<li <% if (a!=null && a.equals("2")){%>class="active" <%}%>>
									<a href="<s:url  action="getDestacado" />">Destacado</a>
								</li>
								<li <% if (a!=null && a.equals("3")){%>class="active" <%}%>>
									<a href="<s:url  action="getCategorias" />">Categorias</a>
								</li>
							</ul>
							<%}%>
							<% if(session.getAttribute("usuario")!=null && session.getAttribute("admin")== null){ %>
							<ul class="nav navbar-nav">
								<li <% if (a!=null && a.equals("0")){%>class="active" <%}%>>
									<a href="<s:url  action="getEstablecimiento" />">Establecimiento</a>
								</li>
								<li <% if (a!=null && a.equals("1")){%>class="active" <%}%>>
									<a href="<s:url  action="getProgramacion" />">Programacion</a>
								</li>
							</ul>
							<%}%>
							 <!-- Usuario -->
						     <ul class="nav navbar-nav navbar-right">
						      <%  if (session.getAttribute("usuario") != null){%>	
						      	<li <% if (a!=null && a.equals("-2")){%>class="active" <%}%>>
						      		<a href="<s:url  action="getUsuario" />">${session.usuario.usuario}</a>
						      	</li>
								 <li>
								 	<a href="<s:url  action="cerrarSesion" />"><s:text name="Cerrarsesion"/></a>
								 </li>	
						      <%  }else{%>
								<li <% if (a!=null && a.equals("-1")){%>class="active" <%}%>>
									<a href="<s:url  action="login" />">Sin logear</a>
								</li>
								 <%  }%>
							</ul>
						 
					</div>
				</nav>
			</div>
		</div>