package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
	
	public Contato[] getContatos(String tag) {
		Contato[] contatosComTag = new Contato[TAMANHO_AGENDA];
		for (int i = 0; i < TAMANHO_AGENDA; i++) {
			if (contatos[i] != null && contatos[i].temTag(tag)) {
				contatosComTag[i] = contatos[i]; 
			}
		}
		return contatosComTag;
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		Validator.validaPosicao(posicao, TAMANHO_AGENDA);
		validaExistenciaContato(posicao);
		
		return contatos[posicao].toString();
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		Validator.validaPosicao(posicao, TAMANHO_AGENDA);
		Validator.validaCriacaoContato(nome, sobrenome, telefone);
		
		this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
	}
	
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}
	
	public void adicionaFavorito(int posicaoContato, int posicaoFavorito) {
		Validator.validaPosicao(posicaoContato, TAMANHO_AGENDA);
		Validator.validaPosicao(posicaoFavorito, TAMANHO_AGENDA);
		validaExistenciaContato(posicaoContato);
		
		Contato contato = this.contatos[posicaoContato];
		contato.favorita();
		favoritos[posicaoFavorito] = contato;
	}
	
	public void adicionaTag(int[] posicoesContatos, int posicaoTag, String tag) {
		for (int i = 0; i < posicoesContatos.length; i++) {
			this.adicionaTag(posicoesContatos[i], posicaoTag, tag);
		}
	}
	
	private void adicionaTag(int posicaoContato, int posicaoTag, String tag) {
		Validator.validaPosicao(posicaoContato, TAMANHO_AGENDA);
		validaExistenciaContato(posicaoContato);
		
		contatos[posicaoContato].adicionaTag(tag, posicaoTag);
	}
	
	private void validaExistenciaContato(int posicao) {
		if (contatos[posicao] == null) throw new IllegalArgumentException("Contato inexistente");
	}
	
}
