import javax.swing.*;

public class Goblin extends Monstro {

    private static final int SAUDE_FIXA = 50;

    public Goblin() {
        super("Goblin", 5, 3, SAUDE_FIXA);
        
        setIcone(new ImageIcon("caminho/para/iconeGoblin.png"));
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        alvo.receberDano(danoEspecial);
        System.out.println(getNome() + " lança um golpe rápido e traiçoeiro, causando " + danoEspecial
                + " de dano a " + alvo.getNome() + "!");

        if (alvo.getSaude() <= 0) {
            System.out.println(alvo.getNome() + " foi derrotado pelo golpe do Goblin!");
        }
    }

    public String gerarRecompensa() {
        return "3 Moedas de Ouro";
    }
}

