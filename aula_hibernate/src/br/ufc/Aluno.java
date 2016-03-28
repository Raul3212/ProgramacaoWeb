package br.ufc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "aluno")
public class Aluno {
	
	@Id //Define chave primária
	@Column(nullable=false) //Define not null
	@GeneratedValue(strategy=GenerationType.AUTO) //Define auto-incremento
	private long id; //Por padrão, o nome da coluna é idêntico ao do atributo de classe
	
	private String nome;
	
	public Aluno(){
		this.nome = "";
		this.email = "";
		this.sobreNome = "";
		this.id = 0;
		this.ira = 0;
	}
	
	public Aluno(long id, String nome, String sobreNome, String email,
			double ira) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.ira = ira;
	}
	
	private String email;
	
	@Column(name = "IRA")
	private double  ira;
	
	@Column(name = "sobre_nome") //Altera o nome da coluna da tabela no banco de dados
	private String sobreNome;
	
	
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
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getIra() {
		return ira;
	}
	public void setIra(double ira) {
		this.ira = ira;
	}
	
	public String toString(){
		return this.id + " - " + this.nome + " " + this.sobreNome + " - " + this.email + " - " + this.ira;
	}
	
}
