package br.ufc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "EMENTA")
public class Ementa {

	@Id
	@Column(name = "EME_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long emeId;
	
	@Column(name = "NOME")
	private String nome;

	@OneToOne(optional = false)
	@JoinColumn(name = "DIS_ID")
	private Disciplina disciplina;
	
	public long getEmeId() {
		return emeId;
	}

	public void setEmeId(long emeId) {
		this.emeId = emeId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}
