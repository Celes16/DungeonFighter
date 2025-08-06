import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tabuleiro extends JFrame {
    private JButton[][] celula;
    private int linhas = 5;
    private int colunas = 10;
    public static Map<Point, Armadilha> armadilhas;
    private Map<Point, Monstro> monstros;
    private Point posicaoHeroi;
    private Point posicaoBoss;
    private ImageIcon iconeHeroi;
    private ImageIcon iconeBoss;

    public Tabuleiro(String nomeHeroi) {
        super("Tabuleiro do Jogo");

        iconeHeroi = new ImageIcon("caminho/para/iconeHeroi.png");
        iconeBoss = new ImageIcon("caminho/para/iconeBoss.png");

        Container tela = getContentPane();
        tela.setLayout(new GridLayout(linhas, colunas));

        celula = new JButton[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                celula[i][j] = new JButton();
                celula[i][j].setFont(new Font("Arial", Font.BOLD, 16)); // fonte para o texto
                celula[i][j].addActionListener(e -> {
                    JButton botao = (JButton) e.getSource();
                    Point p = obterPosicao(botao);
                    if (p != null && verificarArmadilha(p.x, p.y)) {
                        JOptionPane.showMessageDialog(this, "Você caiu em uma armadilha!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }
                });
                tela.add(celula[i][j]);
            }
        }

        // herói na posição inicial
        posicaoHeroi = new Point(0, 0);
        celula[posicaoHeroi.x][posicaoHeroi.y].setText("HERÓI");
        celula[posicaoHeroi.x][posicaoHeroi.y].setIcon(iconeHeroi);

        // posição do boss na última célula
        posicaoBoss = new Point(linhas - 1, colunas - 1);
        armadilhas = new HashMap<>();
        adicionarArmadilhas();

        monstros = new HashMap<>();
        adicionarMonstros();

        // boss na última célula
        celula[posicaoBoss.x][posicaoBoss.y].setText("BOSS");
        celula[posicaoBoss.x][posicaoBoss.y].setIcon(iconeBoss);

        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarArmadilhas() {
        armadilhas.put(new Point(0, 2), new ArmadilhaFixa()); // Fixa
        armadilhas.put(new Point(1, 5), new ArmadilhaAleatoria(3)); // Aleatória
        armadilhas.put(new Point(2, 7), new ArmadilhaFixa()); // Fixa
        armadilhas.put(new Point(3, 1), new ArmadilhaAleatoria(4)); // Aleatória
        armadilhas.put(new Point(4, 3), new ArmadilhaFixa()); // Fixa
        armadilhas.put(new Point(1, 8), new ArmadilhaAleatoria(2)); // Aleatória
        armadilhas.put(new Point(0, 4), new ArmadilhaFixa()); // Fixa
        armadilhas.put(new Point(3, 6), new ArmadilhaAleatoria(5)); // Aleatória
        armadilhas.put(new Point(2, 9), new ArmadilhaFixa()); // Fixa
        armadilhas.put(new Point(4, 5), new ArmadilhaAleatoria(3)); // Aleatória
        armadilhas.put(new Point(0, 6), new ArmadilhaFixa()); // Fixa
        armadilhas.put(new Point(3, 8), new ArmadilhaAleatoria(4)); // Aleatória
        armadilhas.put(new Point(2, 2), new ArmadilhaFixa()); // Fixa
    }

    private void adicionarMonstros() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int linha = random.nextInt(linhas);
            int coluna = random.nextInt(colunas);
            Point posicao = new Point(linha, coluna);

            if (!posicao.equals(posicaoHeroi) && !posicao.equals(posicaoBoss) && !armadilhas.containsKey(posicao) && !monstros.containsKey(posicao)) {
                Monstro monstro;
                int tipoMonstro = random.nextInt(3);

                switch (tipoMonstro) {
                    case 0:
                        monstro = new Aranha();
                        break;
                    case 1:
                        monstro = new Goblin();
                        break;
                    case 2:
                        monstro = new Esqueleto();
                        break;
                    default:
                        throw new IllegalStateException("Tipo de monstro inesperado: " + tipoMonstro);
                }

                monstros.put(posicao, monstro);
                celula[linha][coluna].setIcon(monstro.getIcone());
            }
        }
    }

    public boolean verificarArmadilha(int linha, int coluna) {
        Point posicao = new Point(linha, coluna);
        return armadilhas.containsKey(posicao);
    }

    private Point obterPosicao(JButton button) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (celula[i][j] == button) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public void moverHeroi(int movimentos) {
        int novaLinha = posicaoHeroi.x;
        int novaColuna = posicaoHeroi.y + movimentos;

        if (novaColuna >= colunas) {
            novaLinha += novaColuna / colunas;
            novaColuna = novaColuna % colunas;
        }

        if (novaLinha >= linhas) {
            novaLinha = linhas - 1;
            novaColuna = colunas - 1;
        }

        celula[posicaoHeroi.x][posicaoHeroi.y].setIcon(null);
        celula[posicaoHeroi.x][posicaoHeroi.y].setText(""); 

        posicaoHeroi.setLocation(novaLinha, novaColuna);
        celula[novaLinha][novaColuna].setIcon(iconeHeroi);
        celula[novaLinha][novaColuna].setText("HERÓI"); 

        if (posicaoHeroi.equals(posicaoBoss)) {
            JOptionPane.showMessageDialog(this, "Você encontrou o Boss! Parabéns, você venceu o jogo!");
            return;
        }

        if (monstros.containsKey(posicaoHeroi)) {
            JOptionPane.showMessageDialog(this, "Você encontrou um monstro! Prepare-se para a batalha!");
        }

        if (armadilhas.containsKey(posicaoHeroi)) {
            JOptionPane.showMessageDialog(this, "Você caiu em uma armadilha!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
