<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qqf"%>

<head>

<c:import url="aImports.jsp" />

<script type="text/javascript">
	function onSubmit() {
		f1.action = "aHome";
		f1.submit();
	}
</script>
</head>

<body class="no-sidebar" onload="${querystring}">
<div id="header">
	<div class="container">
		<c:import url="aMenu.jsp" />
	</div>
</div>

<div class="wrapper style1">
	<div class="container FontePadrao">
		
		<section>
			<header class="major">
				<h2>História gerada ${objHistoria.titulo}</h2>
			</header>
		
			<br>
				<p><qqf:out value="${objHistoria.texto1}" /></p>
				<p><qqf:out value="${objHistoria.texto2}" /></p>
				<p><qqf:out value="${objHistoria.texto3}" /></p>
			<br>
				<qqf:imagemPasso img="${objHistoria.caminhoimagemnivel3}" /><br>
			<br>
			<br> <b>Opções escolhidas:</b> <br> <b>Início:</b>
			<c:out value="${objHistoria.label1}" />
			<br> <b>Meio:</b>
			<c:out value="${objHistoria.label2}" />
			<br> <b>Fim:</b>
			<c:out value="${objHistoria.label3}" />
			<br> <br>
		</section>
	</div>
	<qqf:btnVoltar destino="nivel3" />
</div>
			
<c:import url="aRodape.jsp" />
			
</body>