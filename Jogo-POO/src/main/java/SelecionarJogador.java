import javax.swing.*;
import java.awt.*;

public class SelecionarJogador extends JFrame {
    private DungeonMenuApp menuApp;
    private String nomeHeroiSelecionado;

    public SelecionarJogador(DungeonMenuApp menuApp) {
        super("Seleção de Herói");

        this.menuApp = menuApp;

        Container tela = getContentPane();
        setLayout(null);

        JButton guerreiroButton = new JButton("GUERREIRO");
        JButton paladinoButton = new JButton("PALADINO");
        JButton barbaroButton = new JButton("BÁRBARO");

        guerreiroButton.setBounds(50, 30, 150, 30);
        paladinoButton.setBounds(50, 80, 150, 30);
        barbaroButton.setBounds(50, 130, 150, 30);

        tela.add(guerreiroButton);
        tela.add(paladinoButton);
        tela.add(barbaroButton);

        setSize(250, 250);
        setLocationRelativeTo(null);
        setVisible(true);

        guerreiroButton.addActionListener(e -> selecionarHeroi("GUERREIRO"));
        paladinoButton.addActionListener(e -> selecionarHeroi("PALADINO"));
        barbaroButton.addActionListener(e -> selecionarHeroi("BÁRBARO"));
    }

    private void selecionarHeroi(String nomeHeroi) {
        nomeHeroiSelecionado = nomeHeroi;
        menuApp.iniciarJogo(nomeHeroiSelecionado);
        dispose(); 
    }

    public static void main(String[] args) {
        new SelecionarJogador(new DungeonMenuApp());
    }
}

