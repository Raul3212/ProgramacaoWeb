package br.ufc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.Product;
import br.ufc.dao.ProductDAO;

@WebServlet("/insertProduct")
public class InsereProdutoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		
		Product p = new Product();
		p.setName(name);
		
		ProductDAO pDAP = new ProductDAO();
		pDAP.inserir(p);
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h2>Produto " + p.getName() + " inserido com sucesso!</h2>");
		pw.println("</body>");
		pw.println("</html>");
		
	}
	
}
