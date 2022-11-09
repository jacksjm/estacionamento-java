import java.util.ArrayList;

public class Bicicleta extends Veiculo {
    
    private String marca;
    private String cor;
    
    private static ArrayList<Bicicleta> bicicletas = new ArrayList<>();

    public Bicicleta(String nome, String marca, String cor) {
        super(GetId.getNextId(bicicletas),nome);
        this.marca = marca;
        this.cor = cor;

        setBicicleta(this);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public static ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public static void setBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
    }

    @Override
    public String toString() {
        return super.toString() 
            + "\nmarca=" + marca
            + "\ncor=" + cor + "\n";
    }

    public static Bicicleta getBicicletaById(int id) throws Exception {
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getId() == id) {
                return bicicleta;
            }
        }
        throw new Exception("Bicicleta não encontrada");
    }

    public static void excluir(int id) throws Exception {
        Bicicleta bicicleta = getBicicletaById(id);
        bicicletas.remove(bicicleta);
    }
}
