import javax.swing.*;

public class Guerreiro extends Heroi {

    private static final int SAUDE_FIXA = 100;
    private int turnosDefensivos = 0;

    public Guerreiro(String nome) {
        super(nome, 18, 12, SAUDE_FIXA);
     
        setIcone(new ImageIcon("caminho/para/iconeGuerreiro.png"));
    }

    public void posturaDefensiva() {
        if (turnosDefensivos == 0) {
            turnosDefensivos = 2;
            setDefesa(getDefesa() + (int) (getDefesa() * 0.5));
            System.out.println(
                    getNome() + " assume uma postura defensiva, aumentando sua defesa em 50% por duas rodadas!");
        } else {
            System.out.println(getNome() + " já está em postura defensiva!");
        }
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        posturaDefensiva();
    }

    @Override
    public void atacar(Personagem alvo) {
        super.atacar(alvo);

        if (turnosDefensivos > 0) {
            turnosDefensivos--;
            if (turnosDefensivos == 0) {
                setDefesa(getDefesa() - (int) (getDefesa() * 0.5));
                System.out.println(getNome() + " sai da postura defensiva.");
            }
        }
    }
}
