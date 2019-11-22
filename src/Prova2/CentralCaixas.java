package Prova2;

public interface CentralCaixas {
	
	public void setPersonalizacao(String novaPersonalizacao);
	
	public double calculaPreco();
	
	public String getFormato();
	
	public String getPersonalizacao();
	
	public String toString();
	
	public int compareTo(CentralCaixas c);
}
