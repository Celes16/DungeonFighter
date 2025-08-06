import javax.swing.*;
import java.awt.*;

public class DungeonMenuApp extends JFrame {

    private String nomeHeroiSelecionado;

    public DungeonMenuApp() {
        super("Dungeon Game Menu");

    
        Container tela = getContentPane();
        setLayout(null);

      
        JButton jogarButton = new JButton("Jogar");
        JButton debugButton = new JButton("Debug");
        JButton sairButton = new JButton("Sair");

        jogarButton.setBounds(150, 30, 100, 30);
        debugButton.setBounds(150, 80, 100, 30);
        sairButton.setBounds(150, 130, 100, 30);

        tela.add(jogarButton);
        tela.add(debugButton);
        tela.add(sairButton);

        setSize(400,250);
        setLocationRelativeTo(null);
        setVisible(true);

        sairButton.addActionListener(e -> System.exit(0));

        jogarButton.addActionListener(e -> {
            SelecionarJogador selecaoJogador = new SelecionarJogador(this);
            selecaoJogador.setVisible(true);
        });

        debugButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Debug selecionado");
        });
    }

    public void iniciarJogo(String nomeHeroiSelecionado) {
        this.nomeHeroiSelecionado = nomeHeroiSelecionado;
        new Tabuleiro(nomeHeroiSelecionado); 
        new MenuDoJogador(nomeHeroiSelecionado);  
    }

    public static void main(String[] args) {
        DungeonMenuApp dungeonMenuApp = new DungeonMenuApp();
        dungeonMenuApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
