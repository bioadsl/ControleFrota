package br.com.frota.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.frota.model.BeanVeiculo;
import br.com.frota.model.DAO.VeiculoDAO;

public class ServletCasdastrar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> Cadastrar");
		processaRequisicao(request, response);
	}

	private void processaRequisicao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mensagem = "";
		String placa = request.getParameter("placa");
		String chassi = request.getParameter("chassi");
		String modelo = request.getParameter("modelo");
		String ano = request.getParameter("ano");
		String proprietario = request.getParameter("proprietario");
		
		BeanVeiculo beanVeiculo = new BeanVeiculo();
		beanVeiculo.setPlaca(placa);
		beanVeiculo.setChassi(chassi);
		beanVeiculo.setModelo(modelo);
		beanVeiculo.setAno(Integer.parseInt(ano));
		beanVeiculo.setProprietario(proprietario);
		
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		mensagem = veiculoDAO.salvar(beanVeiculo);
		
		request.setAttribute("msg", mensagem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
