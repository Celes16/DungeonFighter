import javax.swing.*;

public class Esqueleto extends Monstro {

    private static final int SAUDE_FIXA = 50;

    public Esqueleto() {
        super("Esqueleto", 6, 2, SAUDE_FIXA);

        setIcone(new ImageIcon("caminho/para/iconeEsqueleto.png"));
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int danoEspecial = getAtaque() + 4; 
        alvo.receberDano(danoEspecial);
        System.out.println(getNome() + " lança uma flecha de osso, causando " + danoEspecial
                + " de dano a " + alvo.getNome() + "!");

        if (alvo.getSaude() <= 0) {
            System.out.println(alvo.getNome() + " foi derrotado pelo ataque do Esqueleto!");
        }
    }

    public String gerarRecompensa() {
        return "4 Moedas de Ouro";
    }
}
