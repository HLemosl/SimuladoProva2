package Prova2;

public class Retangular implements CentralCaixas, Comparable<CentralCaixas>{

	private String descUnica;
	private String formato = "Retangular";
	private String personalizacao;
	private int lado1;
	private int lado2;
	
	public Retangular(String descUnica, String personalizacao, int lado1, int lado2) {
		this.descUnica = descUnica;
		this.personalizacao = personalizacao;
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	public void setPersonalizacao(String novaPersonalizacao) {
		this.personalizacao = novaPersonalizacao;
	}
	
	public double calculaPreco() {
		double area = lado1 * this.lado2;
		return (10 * area);
	}

	public String getPersonalizacao() {
		return personalizacao;
	}
	
	public String getFormato() {
		return formato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descUnica == null) ? 0 : descUnica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retangular other = (Retangular) obj;
		if (descUnica == null) {
			if (other.descUnica != null)
				return false;
		} else if (!descUnica.equals(other.descUnica))
			return false;
		return true;
	}
	
	public int compareTo(CentralCaixas c) {
		return this.hashCode() - c.hashCode();
	}

	@Override
	public String toString() {
		return "Caixa com " + this.personalizacao + "custa " + calculaPreco() +  "centavos. Formato " + this.formato + ".";
	}
}
