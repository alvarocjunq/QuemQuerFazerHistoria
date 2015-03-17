<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qqf"%>

<head>

<c:import url="aImports.jsp" />

<script type="text/javascript">
	function onSubmit(id, obj) 
	{
		var p = getQueryString("p");
		var n1 = getQueryString("n1");
		var action = "";
		var proximapagina = "pnivel3";

		action += proximapagina + "?";
		action += "p=" + p;
		action += "&n1=" + n1;
		action += "&n2=" + id;

		obj.href = action;
	}
</script>
</head>

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
		
		<h2>Escolha o meio da história ${titulo}</h2>
		<div class="row no-collapse-1" >								
			<c:forEach items="${lstNivel2}" var="i" varStatus="id">
				<qqf:opcao label="${i.label}" id="${i.nivel2id}" />
			</c:forEach>
		</div>

	</div>
	<qqf:btnVoltar destino="nivel1" />
</div>
			
<c:import url="aRodape.jsp" />
			
</body>