package br.ufc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.Customer;
import br.ufc.dao.CustomerDAO;

@WebServlet("/inserirCustomer")
public class InserirCustomerServer extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String name = request.getParameter("name");
		
		Customer customer = new Customer();
		customer.setName(name);
		
		CustomerDAO cDAO = new CustomerDAO();
		cDAO.inserir(customer);
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h2>CUSTOMER " + customer.getName() + " inserido com sucesso!</h2>");
		pw.println("</body>");
		pw.println("</html>");
		
	}
	
}
