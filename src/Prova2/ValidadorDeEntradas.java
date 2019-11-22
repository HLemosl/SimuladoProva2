package Prova2;

public class ValidadorDeEntradas {

	public static void verificaNuloVazio(String atributo, String mensagem) {
		if (atributo == null) {
			throw new NullPointerException(mensagem);
		}
		if ("".equals(atributo.trim())) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
