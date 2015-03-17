<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="label" required="true" %>
<%@ attribute name="id" required="true" %>

<section class="4u" style="width: 180px;margin-right: 15px">
	<a href="" class="linkopcao" onclick="onSubmit('${id}',this, 0);">
		<div class="opcao">
			${label}
		</div>
	</a><br>
</section>