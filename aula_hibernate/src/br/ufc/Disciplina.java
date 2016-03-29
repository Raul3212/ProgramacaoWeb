package br.ufc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.internal.Nullable;

@Entity(name="disciplina")
public class Disciplina {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	private int capacidade;
	private boolean obrigatoria;
	
	public Disciplina(){
		this.id = 0;
		this.nome = "";
		this.capacidade = 0;
		this.obrigatoria = false;
	}
	public Disciplina(long id, String nome, int capacidade, boolean obrigatoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.obrigatoria = obrigatoria;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public boolean isObrigatoria() {
		return obrigatoria;
	}
	public void setObrigatoria(boolean obrigatoria) {
		this.obrigatoria = obrigatoria;
	}
	@Override
	public String toString() {
		return this.id + " - " + this.nome + " - " + this.capacidade + " - " + this.obrigatoria;
	}
}
