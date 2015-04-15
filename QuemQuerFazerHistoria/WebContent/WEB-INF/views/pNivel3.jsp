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
	var n2 = getQueryString("n2");
	var action = "";
	var proximapagina = "phistoriagerada";
	
	action += proximapagina + "?";
	action += "p=" + p;
	action += "&n1=" + n1;
	action += "&n2=" + n2;
	action += "&n3=" + id;
	
	obj.href = action+"#destino";
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

		<a name="destino" class="ancora">
			<qqf:cabecalhonivel texto="${textoanterior}" imagem="${caminhoimagem}" />
		</a>
		
		<h2>Escolha o final da história ${titulo}</h2>
		<div class="row no-collapse-1" >								
			<c:forEach items="${lstNivel3}" var="i" varStatus="id">
				<qqf:opcao label="${i.label}" id="${i.nivel3id}" />
			</c:forEach>
		</div>

	</div>
	<qqf:btnVoltar destino="nivel2" />
</div>
			
<c:import url="aRodape.jsp" />
			
</body>