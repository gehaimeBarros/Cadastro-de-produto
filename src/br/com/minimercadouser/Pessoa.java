package br.com.minimercadouser;

import java.util.Objects;
import java.util.Random;

public class Pessoa {

	private String nome;
	private String email;
	private int idade;
	private String cpf;
	private int codigo;

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, cpf, email, idade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(idade, other.idade)
				&& Objects.equals(nome, other.nome);
	}

	Random rm = new Random();
	int numero2 = rm.nextInt(999999999);

	@Override
	public String toString() {
		return "\n\n\t\tDados Pessoais\n\nCodigo: BR" + numero2 + "SSD\n\nNome: " + nome + "\nEmail: " + email
				+ "\nIdade: " + idade + "\nCpf: " + cpf + "\n\n";
	}

}