package br.ufc;

import java.util.ArrayList;
import java.util.List;

public class TestaAluno {

	public static void main(String[] args) {
		AlunoDAO alunoDAO = new AlunoDAO();
//		alunoDAO.inserir(new Aluno(0, "Raul", "Araujo", "raul.araujo3212@gmail.com", 9.999));
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = alunoDAO.listar();
		
		for(Aluno a : alunos){
			System.out.println(a);
		}
		
	}

}
