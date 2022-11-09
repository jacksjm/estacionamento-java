import java.util.ArrayList;

public class Vaga implements GetId {

    private int id;
    private Codigo<Character, Integer> numero;
    private char tipo;
    private double tamanho;
    private double preco;

    private ArrayList<Locacao> locacoes;

    private static ArrayList<Vaga> vagas = new ArrayList<>();

    public Vaga(char letra, int numeros, char tipo, double tamanho, double preco) throws Exception {
        this.id = GetId.getNextId(vagas);
        Codigo<Character,Integer> numero = new Codigo<>(letra, numeros);
        verificaNumero(numero);
        this.numero = numero;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.preco = preco;
        this.locacoes = new ArrayList<>();

        setVaga(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Codigo<Character, Integer> getNumero() {
        return numero;
    }

    public void setNumero(Codigo<Character, Integer> numero) {
        this.numero = numero;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setLocacao(Locacao locacao) {
        this.locacoes.add(locacao);
    }

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public static void setVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public static ArrayList<Vaga> getVagas() {
        return vagas;
    }

    public double getValores() {
        return this.getLocacoes().size() * this.getPreco();
    }

    @Override
    public String toString() {
        return "id=" + id + "\n" 
            + "numero=" + numero + "\n"
            + "tipo=" + tipo + "\n"
            + "tamanho=" + tamanho + "\n"
            + "preco=" + preco + "\n"
            + "valores=" + this.getValores() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vaga)) {
            return false;
        }
        Vaga vaga = (Vaga) obj;

        
        if (this.getId() == vaga.getId()) {
            return true;
        }

        return false;
    }    

    public static Vaga getVagaById(int id) throws Exception {
        for (Vaga vaga : vagas) {
            if (vaga.getId() == id) {
                return vaga;
            }
        }
        throw new Exception("Vaga não encontrada");
    }

    public static boolean verificaNumero(
        Codigo<Character, Integer> numero
    ) throws Exception {
        for (Vaga vaga : vagas) {
            if (vaga.getNumero().equals(numero)) {
                throw new Exception("Setor já existe!");
            }
        }

        return true;
    }

    public static void excluir(int id) throws Exception {
        Vaga vaga = getVagaById(id);
        vagas.remove(vaga);
    }

}