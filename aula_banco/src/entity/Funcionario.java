package entity;

public class Funcionario {
	
	private long id;
	private String nome;
	private String email;
	private double salario;
	
	public Funcionario(long i, String nome, String email, double salario) {
		super();
		this.id = i;
		this.nome = nome;
		this.email = email;
		this.salario = salario;
	}
	public Long getId() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
