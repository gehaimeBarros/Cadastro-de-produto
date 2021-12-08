package br.com.minimercadouser;

import java.util.Objects;

public class Endereco {

	private String rua;
	private int casa;
	private String estado;
	private int cep;
	private String tipoDeRecidencia;
	private String observacao;
	private String bloco;
	private String numeroApartamento;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getCasa() {
		return casa;
	}

	public void setCasa(Integer casa) {
		this.casa = casa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getTipoDeRecidencia() {
		return tipoDeRecidencia;
	}

	public void setTipoDeRecidencia(String tipoDeRecidencia) {
		this.tipoDeRecidencia = tipoDeRecidencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bloco, casa, cep, estado, numeroApartamento, observacao, rua, tipoDeRecidencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bloco, other.bloco) && Objects.equals(casa, other.casa) && Objects.equals(cep, other.cep)
				&& Objects.equals(estado, other.estado) && Objects.equals(numeroApartamento, other.numeroApartamento)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(rua, other.rua)
				&& Objects.equals(tipoDeRecidencia, other.tipoDeRecidencia);
	}

	@Override
	public String toString() {
		return "\n\n\t\tEndereco\n\nRua: " + rua + "\nEstado: " + estado + "\nCep: " + cep + "\nApartemento ou Casa: "
				+ tipoDeRecidencia + "\nObservação: " + observacao + "\nBloco: " + bloco + "\nNumero Recidencial: "
				+ casa + "\nNumero Do Apartamento: " + numeroApartamento + "\n\n";
	}

}