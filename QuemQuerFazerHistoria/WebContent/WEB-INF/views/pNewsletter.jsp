<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qqf"%>


<c:import url="aImports.jsp" />


<body class="no-sidebar">
<div id="header">
	<div class="container">
		<c:import url="aMenu.jsp" />
	</div>
</div>


<div id="main" class="wrapper style1"  style="padding-top: 2em ">
	<div class="container FontePadrao">
		${mensagem}
		<br><br>
	</div>
	<qqf:btnVoltar destino="home" />
</div>

<c:import url="aRodape.jsp" />
</body>