import java.util.ArrayList;

public abstract class Veiculo implements GetId {
    
    private int id;
    private String nome;
    private ArrayList<Locacao> locacoes;

    protected Veiculo(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.locacoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacao(Locacao locacao) {
        this.locacoes.add(locacao);
    }

    @Override
    public String toString() {
        return "id=" + id 
            + "\nnome=" + nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Veiculo)) {
            return false;
        }
        
        Veiculo other = (Veiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
