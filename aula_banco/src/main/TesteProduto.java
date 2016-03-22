package main;

import dao.ProdutoDAO;
import entity.Produto;

public class TesteProduto {
	public static void main(String[] args) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
//		produtoDAO.insert(new Produto(0, "", "", 1000.00));
//		produtoDAO.delete(5);
//		produtoDAO.update(4, new Produto(0, "Cabeça de Gado", "Ruminante", 1500.0));
		for(Produto p : produtoDAO.listAll()){
			System.out.println(p.getId() + " - " + p.getNome() + " [" + p.getDescricao() + "] " + p.getPreco());
		}
	}
}
