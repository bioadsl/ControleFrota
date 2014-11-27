<%@ page import="br.com.frota.model.BeanVeiculo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<title>Consulta</title>
<link href="_css/estilo.css" rel="stylesheet" type="text/css" />
<link href="_css/form.css" rel="stylesheet" type="text/css" />
<script src="_javascript/funcoes.js"></script>
</head>
<body>
	<div id="interface">
		<header id="cabecalho">
			<hgroup>
				<h1>Super frota</h1>
				<h2>Programa de Controle de Frota</h2>
			</hgroup>

			<img id="logo" src="_imagens/pesquisarLogo.png" />

			<nav id="menu">
				<h1>Menu Principal</h1>
				<ul>
					<li onmouseover="mudafoto('_imagens/homeLogo.png')"
						onmouseout="mudafoto('_imagens/pesquisarLogo.png')"><a
						href="index.jsp">Home</a></li>
					<li onmouseover="mudafoto('_imagens/pesquisarLogo.png')"
						onmouseout="mudafoto('_imagens/pesquisarLogo.png')"><a
						href="consulta">Consulta</a></li>

				</ul>
			</nav>
		</header>
		<section id="corpo-full">
			<header id="cabecalho-corpo">

				<hgroup>
					<p id="caminho">Home > Consulta</p>
					<h1>Consulta da Frota</h1>
					<h2>por Fabricio Duarte</h2>
				</hgroup>
			</header>


			<article id="texto-principal">

		<%
						if(request.getAttribute("msg") != null){
					%>
					<h2><%= request.getAttribute("msg") %></h2>
					<% } %>					   
					<form id="formConsulta" action="consulta" method="post" placeholder="Pesquise por dados do veículo">
					
					<table id=tabelaConsulta>

						<tr>
							<td colspan="8"><input type="text" name="consulta" value=""
								size="50"> <input type="submit" value="Consultar">
							</td>



						</tr>
						<tr>

							<th>PLACA</th>
							<th>CHASSI</th>
							<th>MODELO</th>
							<th>ANO</th>
							<th>PROPRIETARIO</th>
							<th>AÇÕES</th>

						</tr>


						<%
							java.util.List<BeanVeiculo> lista = (java.util.List<BeanVeiculo>) request.getAttribute("lista");
							for( BeanVeiculo veiculo : lista){
						%>
						
						<tr>
							<td><%=veiculo.getPlaca()%></td>
							<td><%=veiculo.getChassi()%></td>
							<td><%=veiculo.getModelo()%></td>
							<td><%=veiculo.getAno()%></td>
							<td><%=veiculo.getProprietario()%></td>
							<td><a href="alterar?id=<%= veiculo.getPlaca()%>"><img id="miniIcone" src="_imagens/alterarItem.png"> </a>
								<a href="excluir?id=<%= veiculo.getPlaca()%>"> <img id="miniIcone" src="_imagens/excluir.jpg"></a>
									 </td>
						</tr>
						<%
							}
						%>
					</table>
				</form>
			</article>

		</section>

		<footer id="rodape">
			<p> Copyright &copy; 2014 - by Fabricio Duarte
    <a href="http://facebook.com/biosonora" target="_blank">| Facebook</a> | <a href="http://twitter.com/biosonora" target="_blank">Twitter</a> | <a href="https://www.linkedin.com/pub/fabrÃ­cio-duarte/2a/306/522" target="_blank"> Linkedin </a>
            </p>
		</footer>
	</div>
</body>
</html>