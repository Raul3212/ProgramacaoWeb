package br.ufc;

public class TestaDiscplina {

	public static void main(String[] args) {
		
//		Disciplina d1 = new Disciplina(1, "Projeto e Análise de Algoritmos", 20, false);
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
//Inserindo
//		disciplinaDAO.inserir(d1);
		
		System.out.println("---------------- LISTANDO ---------------");
		
		for(Disciplina d : disciplinaDAO.listar()){
			System.out.println(d);
		}
		
//Atualizando
//		Disciplina d2 = new Disciplina(1, "Projeto e Análise de Algoritmos - PAA", 30, true);
		
//		disciplinaDAO.alterar(d2);
//Recuperando por ID
//		System.out.println(disciplinaDAO.recuperar(1));
		
		
		
		
	}

}
