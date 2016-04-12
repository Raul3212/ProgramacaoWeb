package br.ufc;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "DISCIPLINA")
public class Disciplina {

	@Id
	@Column(name = "DIS_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long disId;
	
	@Column(name = "NOME")
	private String nome;

	@OneToOne(optional = false, 
			cascade = CascadeType.ALL,
			mappedBy = "disciplina",
			targetEntity = Ementa.class
			)
	private Ementa ementa;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "UNI_ID",
			referencedColumnName = "UNI_ID"
			)
	private Universidade universidade;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ALUNO_DISCIPLINA",
			joinColumns = @JoinColumn(name = "DIS_ID", 
						referencedColumnName = "DIS_ID"
					),
			inverseJoinColumns = @JoinColumn(name = "ALUNO_ID",
						referencedColumnName = "ALUNO_ID"
					)		
			)
	private Collection<Aluno> alunos;
	
	public long getDisId() {
		return disId;
	}

	public void setDisId(long disId) {
		this.disId = disId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Ementa getEmenta() {
		return ementa;
	}

	public void setEmenta(Ementa ementa) {
		this.ementa = ementa;
	}

	public Universidade getUniversidade() {
		return universidade;
	}

	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}
}
