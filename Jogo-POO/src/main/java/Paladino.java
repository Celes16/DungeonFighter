import javax.swing.*;

public class Paladino extends Heroi {

    private static final int SAUDE_FIXA = 150;

    public Paladino(String nome) {
        super(nome, 15, 15, SAUDE_FIXA);
    
        setIcone(new ImageIcon("caminho/para/iconePaladino.png"));
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int vidaRecuperada = (int) (SAUDE_FIXA * 0.5);
        int novaSaude = getSaude() + vidaRecuperada;

        if (novaSaude > SAUDE_FIXA) {
            novaSaude = SAUDE_FIXA;
        }

        setSaude(novaSaude);
        System.out.println(getNome() + " usa Recuperação e restaura " + vidaRecuperada + " pontos de vida!");

        if (getSaude() <= 0) {
            System.out.println(getNome() + " foi derrotado e não pode usar sua habilidade de recuperação.");
        }
    }
}