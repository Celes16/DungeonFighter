import javax.swing.*;

public abstract class Heroi extends Personagem {
    private ImageIcon icone; 

    public Heroi(String nome, int ataque, int defesa, int saude) {
        super(nome, ataque, defesa, saude);
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    @Override
    public void atacar(Personagem alvo) {
        super.atacar(alvo);
    }

    @Override
    public void receberDano(int dano) {
        super.receberDano(dano);
        if (getSaude() <= 0) {
            System.out.println(getNome() + " foi derrotado!");
        }
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);
}
