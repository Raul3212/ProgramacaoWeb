package br.ufc;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "ALUNO")
public class Aluno {

	@Id
	@Column(name = "ALU_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long aluId;
	
	@Column(name = "NOME")
	private String nome;

	@ManyToMany(mappedBy = "alunos", fetch = FetchType.LAZY)
	private Collection<Disciplina> disciplinas;
	
	public long getAluId() {
		return aluId;
	}

	public void setAluId(long aluId) {
		this.aluId = aluId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
