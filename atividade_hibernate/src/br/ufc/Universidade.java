package br.ufc;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "UNIVERSIDADE")
public class Universidade {

	@Id
	@Column(name = "UNI_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uniId;
	
	@Column(name = "NOME")
	private String nome;

	@OneToMany(mappedBy = "universidade",
			targetEntity = Disciplina.class,
			fetch = FetchType.EAGER
			)
	private Collection<Disciplina> disciplinas;
	
	public Collection<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Collection<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public long getUniId() {
		return uniId;
	}

	public void setUniId(long uniId) {
		this.uniId = uniId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
