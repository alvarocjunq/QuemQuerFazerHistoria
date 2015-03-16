<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qqf"%>

<head>

<c:import url="aImports.jsp" />

<script type="text/javascript">
	function onSubmit(id, obj, r) {
		var p = getQueryString("p");
		var action = "";
		var proximapagina = "pnivel2";

		action += proximapagina + "?";
		action += "p=" + p;
		action += "&n1=" + id;
// 		action += "&r=" + r;

		obj.href = action;
	}
</script>

</head>

<body class="left-sidebar">
<div id="header">
	<div class="container">
		<c:import url="aMenu.jsp" />
	</div>
</div>

<div id="main" class="wrapper style1">
	<div class="container FontePadrao">

		<qqf:cabecalhonivel texto="${textoanterior}" imagem="${caminhoimagem}" />
		
		<h2>Escolha o início da história ${titulo}</h2>
<!-- 		<h3>Ou <a href="" onclick="onSubmit(0,this,1)" class="link">clique aqui</a> para escolhermos um pra você</h3><br> -->
		<div class="row no-collapse-1" >								
			<c:forEach items="${lstNivel1}" var="i" varStatus="id">
				<qqf:opcao label="${i.label}" id="${i.nivel1id}" />
			</c:forEach>
		</div>

	</div>
	<qqf:btnVoltar destino="home" />
</div>

<c:import url="aRodape.jsp" />
			
</body>

