<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="img" required="true" %>

<c:if test="${not empty img}">
	<a href="resources/imagens/historias/${img}" target="_blank" class="image feature">
		<img src="resources/imagens/historias/${img}" alt="" class="imagempasso" />
	</a>
</c:if>