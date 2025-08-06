class Armadilha {
    private String tipo;
    private int valorMinimo;
    private int valorMaximo;

    public Armadilha() {

    }

    public Armadilha(String tipo, int valorMinimo, int valorMaximo) {
        this.tipo = tipo;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
    }

    public int causarDano() {
        return 0;
    }
}
class ArmadilhaFixa extends Armadilha {
    private static final int DANO_FIXO = 1;

    public ArmadilhaFixa() {
        super("Fixa", 1, 1); 
    }

    @Override
    public int causarDano() {
        return DANO_FIXO;
    }
}

class ArmadilhaAleatoria extends Armadilha {
    private int danoMaximo;

    public ArmadilhaAleatoria(int danoAleatorio) {
        super("Aleatória", 1, danoAleatorio); 
        this.danoMaximo = danoAleatorio;
    }

    @Override
    public int causarDano() {
        return gerarNumeroAleatorio(0, danoMaximo);
    }

    private int gerarNumeroAleatorio(int min, int max) {
        long tempo = System.currentTimeMillis();
        return (int) ((tempo % (max - min + 1)) + min);
    }
}
