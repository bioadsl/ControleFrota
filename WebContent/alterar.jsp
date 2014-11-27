<%@ page import="br.com.frota.model.BeanVeiculo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<title>Alterar</title>
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

			<img id="logo" src="_imagens/alterarLogo.png" />

			<nav id="menu">
				<h1>Menu Principal</h1>
				<ul>
					<li onmouseover="mudafoto('_imagens/homeLogo.png')"
						onmouseout="mudafoto('_imagens/alterarLogo.png')"><a
						href="index.jsp">Home</a></li>
					<li onmouseover="mudafoto('_imagens/pesquisarLogo.png')"
						onmouseout="mudafoto('_imagens/alterarLogo.png')"><a
						href="consulta">Consulta</a></li>

				</ul>
			</nav>
		</header>
		<section id="corpo-full">
			<header id="cabecalho-corpo">

				<hgroup>
					<p id="caminho">Home > Alterar</p>
					<h1>Alteração de Cadastro de Veículos</h1>
					<h2>por Fabricio Duarte</h2>
				</hgroup>
			</header>

			<% BeanVeiculo veiculo = (BeanVeiculo) request.getAttribute("veiculo"); %>

			<article id="texto-principal">
				<form method="post" id="fContato" action="alterar">
					<fieldset id="usuario">
						<legend>Dados do Veículo</legend>
						<p>
							<label for="cPlaca">Placa: </label> <input type="text"
								name="placa" id="cPlaca" maxlength="30" size="20" required="yes"
								autofocus="yes" value="<%=veiculo.getPlaca()%>" readonly="readonly" />
						</p>
						<p>
							<label for="cChassi">Chassi: </label> <input type="text"
								name="chassi" id="cChassi" maxlength="30" size="20"
								required="yes" value="<%=veiculo.getChassi()%>">
						</p>

						<p>
							<label for="cModelo">Modelo:</label> <input type="text"
								name="modelo" id="modelo" maxlength="50" size="20" 
								value="<%=veiculo.getModelo()%>	" required="yes" />
						</p>
						<p>
							<label for="cAno">Ano:</label> <input type="text" name="ano"
								id="cAno" maxlength="15" size="15" multiple
								value="<%=veiculo.getAno()%>" required="yes" />
						</p>
						<p>
							<label for="cProprietario">Proprietario:</label> <input
								type="text" name="proprietario" id="cProprietario"
								maxlength="50" size="20" multiple
								value="<%=veiculo.getProprietario()%>" required="yes" />
						</p>

					</fieldset>

					<p>
						<input type="submit" name="alterar" value="Alterar" />
				</p>

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