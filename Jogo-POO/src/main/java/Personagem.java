import javax.swing.*;
import java.util.Random;

public abstract class Personagem {
    private String nome;
    private int ataque;
    private int defesa;
    private int saude;
    private ImageIcon icone; 

    public Personagem(String nome, int ataque, int defesa, int saude) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.saude = saude;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setAtaque(int ataque) { 
        this.ataque = ataque;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void atacar(Personagem alvo) {
        int dano = calcularDano(alvo);
        alvo.receberDano(dano);
        System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + dano + " de dano.");

        if (alvo.getSaude() <= 0) {
            System.out.println(alvo.getNome() + " foi derrotado!");
        }
    }

    public void receberDano(int dano) {
        saude -= dano;
        if (saude < 0) {
            saude = 0;
        }
    }

    protected int calcularDano(Personagem alvo) {
        Random rand = new Random();
        int danoBase = ataque - alvo.getDefesa();
        return Math.max(danoBase + rand.nextInt(5), 0);
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);
}
