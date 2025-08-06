import javax.swing.*;

public class Boss extends Monstro {

    private static final int SAUDE_FIXA = 200;

    public Boss(String nome) {
        super(nome, 30, 20, SAUDE_FIXA);
        
        setIcone(new ImageIcon("caminho/para/iconeBoss.png"));
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int danoEspecial = getAtaque() * 3; 
        alvo.receberDano(danoEspecial);
        System.out.println(getNome() + " realiza um ataque destruidor e causa " + danoEspecial + " de dano a "
                + alvo.getNome() + "!");

        if (alvo.getSaude() <= 0) {
            System.out.println(alvo.getNome() + " foi derrotado pelo ataque especial!");
        }
    }

    public String gerarRecompensa() {
        return "Espada Lendária";
    }
}
