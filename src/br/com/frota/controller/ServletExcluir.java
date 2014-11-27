package br.com.frota.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.frota.model.BeanVeiculo;
import br.com.frota.model.DAO.VeiculoDAO;

public class ServletExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
	}
	
	private void processaRequisicao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		VeiculoDAO dao = new VeiculoDAO();
		String mensagem = "";
		String placa = request.getParameter("id");
		if(placa != null){
			
			mensagem = dao.excluir(placa);
		}
		
		List<BeanVeiculo> lista = dao.consultarTodos(null);
		
		request.setAttribute("lista", lista);
		request.setAttribute("msg", mensagem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("consulta");
		dispatcher.forward(request, response);
	}
}
