package Prova2;

public class Pentagonal implements CentralCaixas, Comparable<CentralCaixas>{

	private String descUnica;
	private String formato = "Pentagonal";
	private String personalizacao;
	private int lado;
	
	public Pentagonal(String descUnica, String personalizacao, int lado) {
		this.descUnica = descUnica;
		this.personalizacao = personalizacao;
		this.lado = lado;
	}
	
	public void setPersonalizacao(String novaPersonalizacao) {
		this.personalizacao = novaPersonalizacao;
	}
	
	public double calculaPreco() {
		double altura = ((this.lado / 2 * Math.sqrt(5) + 2 * Math.sqrt(5) ) / 2);
		double area = (5.0 * ( this.lado * altura ) / 2.0);
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
		Pentagonal other = (Pentagonal) obj;
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
		return "Caixa com " + this.personalizacao + "custa " + calculaPreco() + "centavos. Formato " + this.formato + ".";
	}
	
	
}
