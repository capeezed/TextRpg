package Sistema;

public class Item {

	private String nome;
	private String descricao;
	private TipoItem tipo;
	
	public Item(String nome, String descricao, TipoItem tipo) {
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	 public String getNome() {
	        return nome;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public TipoItem getTipo() {
	        return tipo;
	    }

	    @Override
	    public String toString() {
	        return nome + " (" + tipo + "): " + descricao;
	    }
	
}

enum TipoItem{
	ARMA, ARMADURA, POCAO, CHAVE, TESOURO
}