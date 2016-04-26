package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.model.Aluno;

@Controller
public class AlunoController {
	
	@RequestMapping("/inserirAlunoFormulario")
	public String inserirAlunoFormulario(){
		return "aluno/inserirAlunoFormulario";
	}
	
	@RequestMapping("/inserirAluno")
	//Parâmetro Aluno já vem prenchido da página (Spring!!!)
	public String inserirAlno(Aluno aluno){
		
		System.out.println("Nome: " + aluno.getNome());
		System.out.println("IRA: " + aluno.getIra());
		
		return "aluno/alunoInseridoOk";
		
	}
	
}
