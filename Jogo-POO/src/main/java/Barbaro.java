import javax.swing.*;

public class Barbaro extends Heroi {

    private static final int SAUDE_FIXA = 120;

    public Barbaro(String nome) {
        super(nome, 20, 8, SAUDE_FIXA);
       
        setIcone(new ImageIcon("caminho/para/iconeBarbaro.png"));
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int danoEspecial = (int) (getAtaque() * 1.5); 
        alvo.receberDano(danoEspecial);
        System.out.println(getNome() + " entra em fúria e desfere um golpe devastador, causando " + danoEspecial
                + " de dano a " + alvo.getNome() + "!");

        if (alvo.getSaude() <= 0) {
            System.out.println(alvo.getNome() + " foi derrotado pelo golpe furioso!");
        }
    }
}
