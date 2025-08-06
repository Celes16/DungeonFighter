import javax.swing.*;

public abstract class Monstro extends Personagem {
    private ImageIcon icone; 

    public Monstro(String nome, int ataque, int defesa, int saude) {
        super(nome, ataque, defesa, saude);
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

   
    public void atacar(Heroi hero) {
        super.atacar(hero);
    }

    @Override
    public abstract void usarHabilidadeEspecial(Personagem alvo);
}
