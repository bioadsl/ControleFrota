package br.com.frota.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.frota.model.BeanVeiculo;
import br.com.frota.model.DAO.VeiculoDAO;



public class ServletEditar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String placa = request.getParameter("id");
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		 BeanVeiculo beanVeiculo =  veiculoDAO.consultarItem(placa);
		if(beanVeiculo != null){
			
			request.setAttribute("veiculo", beanVeiculo);

			RequestDispatcher dispatcher = request.getRequestDispatcher("alterar.jsp");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("consulta");
			dispatcher.forward(request, response);
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>> Alterar");
		
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
		mensagem = veiculoDAO.editar(beanVeiculo);
		
		request.setAttribute("msg", mensagem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("consulta");
		dispatcher.forward(request, response);
	}
}
