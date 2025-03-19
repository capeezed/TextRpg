package Sistema;
public class Personagem {

	private String nome;
	private int nivel;
	private int pontosVida;
	private int pontosVidaMaximo;
	private int forca;
	private int destreza;
	private int inteligencia;
	private int experiencia;
	
	public Personagem(String nome, int forca, int destreza, int inteligencia) {
		this.nome = nome;
		this.forca = forca;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.nivel = 1;
		this.experiencia = 0;
		
		this.pontosVidaMaximo = 10 + (this.forca *2);
		this.pontosVida = pontosVidaMaximo;
	}
	
	public void receberDano(int dano) {
		this.pontosVida -= dano;
			if(this.pontosVida < 0) {
				this.pontosVida = 0;
		}
	}	
	
	public void curar(int cura) {
		this.pontosVida += cura;
		if(this.pontosVida > this.pontosVidaMaximo) {
			this.pontosVida = this.pontosVidaMaximo;
		}
	}
	
	public void ganharExperiencia(int exp) {
		this.experiencia += exp;
		verificarNivel();
	}
	
	private void verificarNivel() {
		int novoNivel = 1 + (this.experiencia/100);
		if(novoNivel > this.nivel) {
			int niveisGanhos = novoNivel - this.nivel;
			this.nivel = novoNivel;
			subirNivel(niveisGanhos);
		}
	}
	
	private void subirNivel(int niveisGanhos) {
		for(int i = 0; i< niveisGanhos; i++){
			this.forca += 1;
			this.destreza +=1;
			this.inteligencia +=1;
			this.pontosVidaMaximo +=1;
		}
		this.pontosVida = pontosVidaMaximo;
	}
	
	public boolean estaVivo() {
		return this.pontosVida > 0;
	}
	
	public int calcularDano() {
		return this.forca + (this.nivel / 2);
	}
	
	public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getPontosVidaMaximo() {
        return pontosVidaMaximo;
    }

    public int getForca() {
        return forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getExperiencia() {
        return experiencia;
    }
    
    @Override
    public String toString() {
        return "Personagem: " + nome + 
               "\nNível: " + nivel + 
               "\nVida: " + pontosVida + "/" + pontosVidaMaximo +
               "\nForça: " + forca +
               "\nDestreza: " + destreza +
               "\nInteligência: " + inteligencia +
               "\nExperiência: " + experiencia;
    }
}
