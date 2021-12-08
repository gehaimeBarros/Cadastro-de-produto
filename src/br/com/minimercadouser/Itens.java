package br.com.minimercadouser;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Itens {

	private String produto;
	private double quantidade;
	private String marca;
	private double preco;
	private double taxaDeEntrega;
	private double valorFinal;
	
	Calendar c = Calendar.getInstance();
	Date data = c.getTime();

	Locale brasil = new Locale("pt", "BR");
	Locale eua = Locale.US;
	Locale italia = Locale.ITALIAN;

	DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
	
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getTaxaDeEntrega() {
		return taxaDeEntrega;
	}

	public void setTaxaDeEntrega(double taxaDeEntrega) {
		this.taxaDeEntrega = taxaDeEntrega;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, preco, produto, quantidade, taxaDeEntrega, valorFinal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itens other = (Itens) obj;
		return Objects.equals(marca, other.marca)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco)
				&& Objects.equals(produto, other.produto)
				&& Double.doubleToLongBits(quantidade) == Double.doubleToLongBits(other.quantidade)
				&& Double.doubleToLongBits(taxaDeEntrega) == Double.doubleToLongBits(other.taxaDeEntrega)
				&& Double.doubleToLongBits(valorFinal) == Double.doubleToLongBits(other.valorFinal);
	}

	@Override
	public String toString() {
		return "\n\t\tCarrinho\n\nProduto Escolhido: " + produto + "\nQuantidade: " + quantidade + "\nMarca: " + marca
				+ "\nValor R$ " + preco + "0\nTaxa R$ " + "2.10" + "\nTotal R$ " + valorFinal + "0\n\n"+"Data e Hora: "+f2.format(data)+"\n\n";
	}

}