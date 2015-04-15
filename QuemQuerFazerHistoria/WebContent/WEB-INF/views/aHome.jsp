<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qqf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<c:import url="aImports.jsp" />
	</head>
<body class="homepage">

<div id="header">
	<div class="container">
		
		<c:import url="aMenu.jsp" />

		<div id="banner">
			<div class="container">
				<section>
					<header class="major">
						<h2>Bem vindo!</h2>
						<span class="byline">
						Crie a sua própria história em apenas 4 passos...
						</span>
					</header>
				</section>			
			</div>
		</div>

	</div>
</div>


<div class="wrapper style2">
	<section class="container">
		<header class="major">
			<a name="destino" class="ancora"><h2>Escolha um personagem</h2></a>
		</header>
		
		<div class="row no-collapse-1">
			<c:forEach items="${lstPersonagem}" var="i">
				<section class="4u">
					<a href="pnivel1?p=${i.personagemid}#destino" class="image feature" style="margin-top: 2em">
						<img src="resources/imagens/historias/${i.caminhoimagem}" alt="" class="imagemshadow">
					</a>
					<b>${i.descricao}</b>
				</section>
			</c:forEach>
		</div>
	</section>
</div>


<c:import url="aRodape.jsp" />

</body>
</html>