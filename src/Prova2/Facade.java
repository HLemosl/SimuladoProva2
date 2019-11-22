package Prova2;

import java.util.List;

public class Facade {
	
	private ControllerCaixas caixasController = new ControllerCaixas();

	public void cadastraCaixaPentagonal(String descUnica, String personalizacao, int lado) {
		caixasController.cadastraCaixaPentagonal(descUnica, personalizacao, lado);
	}
	
    public void cadastraCaixaRetangular(String descUnica, String personalizacao, int lado1, int lado2) {
    	caixasController.cadastraCaixaRetangular(descUnica, personalizacao, lado1, lado2);
    }
    
    public void cadastraCaixaCircular(String descUnica, String personalizacao, int raio) {
    	caixasController.cadastraCaixaCircular(descUnica, personalizacao, raio);
    }
	
    public void modificar(String descUnica, String novaPersonalizacao) {
    	caixasController.modificar(descUnica, novaPersonalizacao);
    }
    
    public boolean remover(String descUnica) {
    	return caixasController.remover(descUnica);
    }
    
    public boolean contem(String personalizacao, String formato) {
    	return caixasController.contem(personalizacao, formato);
    }
    
    public List<String> pesquisa(String personalizacao) {
    	return caixasController.pesquisa(personalizacao);
    }
    
    public int calcularRendimentos() {
    	return caixasController.calcularRendimentos();
    }
}
