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
		<h2>Veja como o site funciona e faça a sua própria história...</h2>
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
					Nesse site você pode montar a sua própria história e decidir como ela vai acabar.
					<br><br>
					Após você escolher que tipo de história quer gerar na primeira tela, com a escolha do personagem, você vai passar por mais 3 passos:
					<br>
					- Escolha do início<br>
					- Escolha do meio<br>
					- Escolha do final<br>
					<br>
					Para cada início haverão vários meios e para cada meio haverão vários finais.
					<br>
					Já contamos com vários finais diferentes, mas você também pode contribuir com a plataforma.
					<br>
					Sugira um personagem novo ou envie um final para uma idéia existente no link abaixo "Sugerir um personagem".
					<br>
					<br>
					Se você quiser, pode compartilhar um desenho para a história que você gerou no site, em breve criaremos um mural com os desenhos.
					<br>
				</section>
			</div>
		</div>
		
	</div>
	<qqf:btnVoltar destino="home" />
</div>
			
<c:import url="aRodape.jsp" />
			
</body>