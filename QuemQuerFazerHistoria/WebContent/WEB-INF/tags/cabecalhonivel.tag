<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qqf"%>

<%@ attribute name="texto" required="true" %>
<%@ attribute name="imagem" required="true" %>


<div class="row">
	<div id="sidebar" class="4u sidebar">
		<section>
			<div class="row half">
				<qqf:imagemPasso img="${imagem}" />
			</div>
		</section>
	</div>
	
	<div id="content" class="8u skel-cell-important">
		<section>
			${texto}
			<br>
		</section>
	</div>
</div>