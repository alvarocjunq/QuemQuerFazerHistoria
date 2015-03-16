<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="qqf"%>


<c:import url="aImports.jsp" />

<script type="text/javascript">
function validaSugerPer(form)
{
	var alerta = '';
	if(form.emailremetente.value == '')
		alerta += '\n- E-mail';
	
	if(form.personagem.value == '')
		alerta += '\n- Personagem';
	
	if(form.anexo.value == '')
		alerta += '\n- Desenho';
	
	if(alerta != '')
	{
		alert('Os seguintes campos são obrigatórios:\n' + alerta);
		return false;
	}
	
	var email = form.emailremetente;
	var parte1 = email.value.indexOf("@");
    var parte2 = email.value.indexOf(".");
    var parte3 = email.value.length; 
	if (!(parte1 >= 3 && parte2 >= 0 && parte3 >= 9))//Verifica se é um e-mail válido
	{ 
    	alert ("O campo de e-mail deve ser conter um endereço eletrônico!");
    	email.focus();
    	return false;
    }
	
	if(!isImagemValida(form.anexo.value))
	{
		alert('O tipo de imagem enviado não é válido!');
		form.anexo.focus();
		return false;
	}
	
	exibeloading();
	return true;
}
</script>

<body class="no-sidebar">
<div id="header">
	<div class="container">
		<c:import url="aMenu.jsp" />
	</div>
</div>
 

<div id="main" class="wrapper style1"  style="padding-top: 2em ">
	<div class="container FontePadrao">
		<form id="form" action="enviarumdesenho" method="post" target="_self" enctype="multipart/form-data" onSubmit="return validaSugerPer(this)">
			Seu e-mail*: <input type="email" id="emailremetente" name="emailremetente"  />
			Personagem*: <input type="text" id="personagem" name="personagem"  />
			Descrição do seu personagem: <input type="text" id="descricao" name="descricao"  />
			Desenho*: <br><input type ="file" id="anexo" name ="anexo" /><br> 
			<input type="submit" value="Enviar" style="margin-left: -3px;margin-top: 10px;" />
		</form>
		
		<div class="loading" id="loading" style="display: none">
		    <br><img alt="Enviando..." src="resources/imagens/loading.gif">
		    <br>Enviando...
		</div>	
		<div id="espaco" style="display: none">
			<br><br><br><br><br><br>
		</div>
	</div>
	<qqf:btnVoltar destino="home" />
</div>



<c:import url="aRodape.jsp" />
</body>