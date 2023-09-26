package agenda;

public class Validator {

	public static void validaPosicao(int posicao, int posicaoMaxima) {
		if (posicao > posicaoMaxima || posicao < 1) {
			throw new IllegalArgumentException("Posicao invalida");
		}
	}
	
	public static void validaCriacaoContato(String nome, String sobrenome, String telefone) {
		if (nome == null || "".equals(nome)) throw new NullPointerException("Nome null");
		if (sobrenome == null || "".equals(sobrenome)) throw new NullPointerException("Sobrenome null");
		if (telefone == null || "".equals(telefone)) throw new NullPointerException("Telefone null");
	}
	
}
