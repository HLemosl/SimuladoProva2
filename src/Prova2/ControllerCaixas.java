package Prova2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerCaixas {
	
	private Map<String, CentralCaixas> caixas;

	public ControllerCaixas() {
		caixas = new HashMap<>();
	}
	
	private void verificaZeroNegativo(int lado) {
		if (lado <= 0) {
			throw new RuntimeException("Lado nao pode ser zero ou um numero negativo.");
		}
	}
	
	private void verificaRaio(int raio) {
		if (raio <= 0) {
			throw new RuntimeException("Raio nao pode ser zero ou um numero negativo.");
		}
	}
	
	public void cadastraCaixaPentagonal(String descUnica, String personalizacao, int lado) {
		ValidadorDeEntradas.verificaNuloVazio(descUnica, "Descricao Unica nao pode ser nula ou vazia.");
		ValidadorDeEntradas.verificaNuloVazio(personalizacao, "Personalizacao nao pode ser nula ou vazia.");
		verificaZeroNegativo(lado);
		Pentagonal caixa = new Pentagonal(descUnica, personalizacao, lado);
		caixas.put(descUnica, caixa);
	}

	public void cadastraCaixaRetangular(String descUnica, String personalizacao, int lado1, int lado2) {
		ValidadorDeEntradas.verificaNuloVazio(descUnica, "Descricao Unica nao pode ser nula ou vazia.");
		ValidadorDeEntradas.verificaNuloVazio(personalizacao, "Personalizacao nao pode ser nula ou vazia.");
		verificaZeroNegativo(lado1);
		verificaZeroNegativo(lado2);
		Retangular caixa = new Retangular(descUnica, personalizacao, lado1, lado2);
		caixas.put(descUnica, caixa);
	}

	public void cadastraCaixaCircular(String descUnica, String personalizacao, int raio) {
		ValidadorDeEntradas.verificaNuloVazio(descUnica, "Descricao Unica nao pode ser nula ou vazia.");
		ValidadorDeEntradas.verificaNuloVazio(personalizacao, "Personalizacao nao pode ser nula ou vazia.");
		verificaRaio(raio);
		Circular caixa = new Circular(descUnica, personalizacao, raio);
		caixas.put(descUnica, caixa);
	}

	public void modificar(String descUnica, String novaPersonalizacao) {
		ValidadorDeEntradas.verificaNuloVazio(descUnica, "Descricao Unica nao pode ser nula ou vazia.");
		ValidadorDeEntradas.verificaNuloVazio(novaPersonalizacao, "Nova Personalizacao nao pode ser nula ou vazia.");
		if (!caixas.containsKey(descUnica)) {
			throw new RuntimeException("Esta caixa nao existe.");
		}
		caixas.get(descUnica).setPersonalizacao(novaPersonalizacao);
	}

	public boolean remover(String descUnica) {
		if (!caixas.containsKey(descUnica)) {
			return false;
		}
		caixas.remove(descUnica);
		return true;
	}

	public boolean contem(String personalizacao, String formato) {
		int contem = 0;
		List<CentralCaixas> mesmoFormato = new ArrayList<>();
		for (CentralCaixas f : mesmoFormato) {
			if (formato.equals(f.getFormato())) {
				mesmoFormato.add(f);
			}
		}
		for (int p = 0; p < mesmoFormato.size(); p++) {
			if (personalizacao.equals(mesmoFormato.get(p).getPersonalizacao())) {
				contem += 1;
			}
		}
		if (contem == 0) {
			return false;
		}
		return true;
	}

	public List<String> pesquisa(String personalizacao) {
		List<String> listaDeCaixas = new ArrayList<>();
		for (CentralCaixas c : caixas.values()) {
			listaDeCaixas.add(c.toString());
		}
		Collections.sort(listaDeCaixas);
		return listaDeCaixas;
	}

	public int calcularRendimentos() {
		double rendimento = 0;
		for (CentralCaixas r : caixas.values()) {
			rendimento = r.calculaPreco();
		}
		return (int) rendimento;
	}
}
