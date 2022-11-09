import java.util.ArrayList;

public class Locacao implements GetId {
    
    private int id;
    private String data;
    private Vaga vaga;
    private Veiculo veiculo;

    private static ArrayList<Locacao> locacoes = new ArrayList<>();

    public Locacao(String data, Veiculo veiculo, Vaga vaga) {
        this.id = GetId.getNextId(locacoes);
        this.data = data;
        this.veiculo = veiculo;
        this.vaga = vaga;

        veiculo.setLocacao(this);
        vaga.setLocacao(this);

        setLocacao(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public static ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public static void setLocacao(Locacao locacao) {
        locacoes.add(locacao);
    }

    @Override
    public String toString() {
        return "id=" + id + "\n"
            + "data=" + data + "\n"
            + "vaga=" + vaga.getNumero() + "\n"
            + "veiculo=" + veiculo.getNome() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Locacao) {
            Locacao locacao = (Locacao) obj;
            return locacao.getId() == this.getId();
        }
        return false;
    }

    public static Locacao getLocacaoById(int id) throws Exception {
        for (Locacao locacao : locacoes) {
            if (locacao.getId() == id) {
                return locacao;
            }
        }
        throw new Exception("Locação não encontrada");
    }

    public static void excluir(int id) throws Exception {
        Locacao locacao = getLocacaoById(id);
        locacoes.remove(locacao);
    }
    
}
