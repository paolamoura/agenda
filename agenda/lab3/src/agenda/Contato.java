package agenda;

import java.util.Objects;

public class Contato {

	private String nome;
	private String sobrenome;
	private String telefone;
	private boolean ehFavorito;
	private String[] tags;
	
	public Contato(String nome, String sobrenome, String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.ehFavorito = false;
		this.tags = new String[5];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getNomeCompleto() {
		String nomeCompleto = nome + " " + sobrenome;
		return this.ehFavorito ? "❤️ " + nomeCompleto : nomeCompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public boolean ehFavorito() {
		return ehFavorito;
	}
	
	public void favorita() {
		this.ehFavorito = true;
	}
	
	public void desfavorita() {
		this.ehFavorito = false;
	}
	
	public void adicionaTag(String tag, int posicao) {
		this.tags[posicao] = tag;
	}
	
	public String getTag(int posicao) {
		return this.tags[posicao];
	}
	
	public boolean temTag(String tagBuscada) {
		for (String tag : this.tags) {
			if (tag != null && tag.equals(tagBuscada)) {
				return true; 
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}
	
	private String formataTags() {
		String str = "";
		for (int i = 0; i < this.tags.length; i++)
			if (tags[i] != null)
				str += tags[i] + " ";
		return str.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getNomeCompleto() + "\n");
		sb.append(telefone + "\n");
		sb.append(formataTags());

		return sb.toString();
	}
	
}
