<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta>
    <title>Cadastro</title>
    <link href="_css/estilo.css" rel="stylesheet" type="text/css"/>
    <link href="_css/form.css" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script  src="_javascript/funcoes.js"></script>
</head>
<body>
<div id="interface">
    <header id="cabecalho">
        <hgroup>
            <h1>Super frota</h1>
            <h2>Programa de Controle de Frota</h2>
        </hgroup>

        <img id="logo" src="_imagens/homeLogo.png"/>

        <nav id="menu">
            <h1>Menu Principal</h1>
            <ul>
               		<li onmouseover="mudafoto('_imagens/homeLogo.png')"	onmouseout="mudafoto('_imagens/homeLogo.png')"><a href="index.jsp">Home</a></li>
					<li onmouseover="mudafoto('_imagens/pesquisarLogo.png')"onmouseout="mudafoto('_imagens/homeLogo.png')"><a href="consulta">Consulta</a></li>
                          
            </ul>
        </nav>
    </header>
    <section id="corpo-full">
        <header id="cabecalho-corpo">
            <hgroup>
                <p id="caminho"> Home > Cadastro</p>
                <h1>Formulário de Cadastro de Veículo</h1>
                <h2>por Fabricio Duarte</h2>
            </hgroup>
        </header>
		
		<article id="texto-principal">
		
					<%
						if(request.getAttribute("msg") != null){
					%>
					<h2><%= request.getAttribute("msg") %></h2>
					<% } %>

   
            <form method="post" action="cadastrar">
                <fieldset id="usuario"><legend>Dados do Veículo</legend>
                    <p><label for="cPlaca">Placa: </label>
                        <input type="text" name="placa" id="cPlaca" maxlength="7" size="12" required="yes" autofocus="yes" placeholder="Digite a placa"/></p>
                    <p><label for="cChassi">Chassi: </label>
                        <input type="text" name="chassi" id="cChassi" maxlength="10" size="12" required="yes" placeholder="Digite o chassi"> </p>
                    <hr/>
                    <p><label for="cModelo">Modelo:</label>
                        <input type="text" name="modelo" id="cModelo" maxlength="20" size="15" multiple placeholder="Digite o modelo" required="yes"/></p>
                    <p><label for="cAno">Ano:</label>
                        <input type="text" name="ano" id="cAno" maxlength="4" size="10" multiple placeholder="Digite o ano" required="yes"/></p>
                    <p><label for="cProprietario">Proprietário:</label>
                        <input type="text" name="proprietario" id="cProprietario" maxlength="50" size="20" multiple placeholder="Nome do Proprietário" required="true"/></p>
                </fieldset>
                <p><input type="submit" name="salvar" id="btnSalvar" value="Salvar" /></p>
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