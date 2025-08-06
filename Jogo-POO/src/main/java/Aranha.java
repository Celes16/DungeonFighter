import javax.swing.*;

public class Aranha extends Monstro {

    private static final int SAUDE_FIXA = 50;

    public Aranha() {
        super("Aranha", 4, 2, SAUDE_FIXA);
       
        setIcone(new ImageIcon("caminho/para/iconeAranha.png"));
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int danoEspecial = getAtaque() + 2;
        alvo.receberDano(danoEspecial);
        System.out.println(getNome() + " usa uma picada venenosa, causando " + danoEspecial
                + " de dano a " + alvo.getNome() + " e envenenando-o!");

        if (alvo.getSaude() <= 0) {
            System.out.println(alvo.getNome() + " foi derrotado pelo veneno!");
        }
    }


    public String gerarRecompensa() {
        return "2 Moedas de Ouro";
    }
}
