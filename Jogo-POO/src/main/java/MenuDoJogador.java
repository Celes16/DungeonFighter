import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuDoJogador extends JFrame {
    private String nomeHeroiSelecionado;
    private Tabuleiro tabuleiro;

    public MenuDoJogador(String nomeHeroiSelecionado) {
        super("Menu do Jogador");

        this.nomeHeroiSelecionado = nomeHeroiSelecionado;

        
        tabuleiro = new Tabuleiro(nomeHeroiSelecionado);

        
        setLayout(new BorderLayout());

        
        JButton visualizarArmadilhasButton = new JButton("Visualizar Armadilhas");
        visualizarArmadilhasButton.addActionListener(e -> visualizarArmadilhas());

        
        JButton rolarDadoButton = new JButton("Rolar Dado");
        rolarDadoButton.addActionListener(e -> rolarDado());

        
        JPanel botoesPanel = new JPanel();
        botoesPanel.add(visualizarArmadilhasButton);
        botoesPanel.add(rolarDadoButton);
        add(botoesPanel, BorderLayout.SOUTH);

       
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void visualizarArmadilhas() {
        JFrame armadilhasFrame = new JFrame("Visualização das Armadilhas");
        armadilhasFrame.setLayout(new GridLayout(5, 10));

        JButton[][] tabuleiroVisual = new JButton[5][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiroVisual[i][j] = new JButton();
                if (Tabuleiro.armadilhas.containsKey(new Point(i, j))) {
                    tabuleiroVisual[i][j].setText("X");
                }
                armadilhasFrame.add(tabuleiroVisual[i][j]);
            }
        }

        armadilhasFrame.setSize(700, 400);
        armadilhasFrame.setLocationRelativeTo(null);
        armadilhasFrame.setVisible(true);
    }

    private void rolarDado() {
        
        int movimentos = (int) (Math.random() * 3) + 1;

        
        tabuleiro.moverHeroi(movimentos);
    }
}
