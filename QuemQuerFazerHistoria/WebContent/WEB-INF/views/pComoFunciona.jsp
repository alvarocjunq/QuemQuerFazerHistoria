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

<div id="main" class="wrapper style1">
	<div class="container FontePadrao">
		<h2>Veja como o site funciona e fa�a a sua pr�pria hist�ria...</h2>
		<div class="row">
			<div id="sidebar" class="4u sidebar">
				<section>
					<div class="row half">
							<a href="resources/imagens/comofunciona.jpg#destino" target="_blank" class="image feature">
								<img src="resources/imagens/comofunciona.jpg" alt="" class="" />
							</a>
					</div>
				</section>
			</div>
			
			<div id="content" class="8u skel-cell-important">
				<section>
					Nesse site voc� pode montar a sua pr�pria hist�ria e decidir como ela vai acabar.
					<br><br>
					Ap�s voc� escolher que tipo de hist�ria quer gerar na primeira tela, com a escolha do personagem, voc� vai passar por mais 3 passos:
					<br>
					- Escolha do in�cio<br>
					- Escolha do meio<br>
					- Escolha do final<br>
					<br>
					Para cada in�cio haver�o v�rios meios e para cada meio haver�o v�rios finais.
					<br>
					J� contamos com v�rios finais diferentes, mas voc� tamb�m pode contribuir com a plataforma.
					<br>
					Sugira um personagem novo ou envie um final para uma id�ia existente no link abaixo "Sugerir um personagem".
					<br>
					<br>
					Se voc� quiser, pode compartilhar um desenho para a hist�ria que voc� gerou no site, em breve criaremos um mural com os desenhos.
					<br>
				</section>
			</div>
		</div>
		
	</div>
	<qqf:btnVoltar destino="home" />
</div>
			
<c:import url="aRodape.jsp" />
			
</body>