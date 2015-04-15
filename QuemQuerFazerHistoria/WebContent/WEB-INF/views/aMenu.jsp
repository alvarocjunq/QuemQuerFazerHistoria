<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html lang='pt-br' xmlns="http://www.w3.org/1999/xhtml">

<h1><a href="#" id="logo" style="text-shadow: 0 0 0.2em #00BFFF;">Quem quer fazer história?</a></h1>
	
	<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="aHome#destino" class="menu menushadow">Home</a></li>
				<li>
					<a href="" style="font-weight: bold">Personagens</a>
					<ul>
						<c:forEach items="${lstPersonagem}" var="i" varStatus="id">
							<li><a  href="pnivel1?p=${i.personagemid}#destino">${i.descricao}</a></li>
						</c:forEach>
					</ul>
				</li>
				<li>
					<a href="historiarandom#destino" style="text-shadow: 0 0 0.2em #000, 0 0 0.2em #000, 0 0 0.2em #000;" class="menu" >
						Gerar história aleatória
					</a>
				</li>
			</ul>
		</nav>