import java.util.ArrayList;

public class Carro extends Veiculo {
    
    private Codigo<String, String> placa;
    private String cor;

    private static ArrayList<Carro> carros = new ArrayList<>();

    public Carro(String nome, String letras, String numeros, String cor) throws Exception{
        super(GetId.getNextId(carros), nome);
        Codigo<String, String> placa = new Codigo<>(letras, numeros);
        verificaPlaca(placa);
        this.placa = placa;
        this.cor = cor;

        setCarro(this);
    }

    public Codigo<String, String> getPlaca() {
        return placa;
    }

    public void setPlaca(Codigo<String, String> placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public static ArrayList<Carro> getCarros() {
        return carros;
    }

    public static void setCarro(Carro carro) {
        carros.add(carro);
    }

    @Override
    public String toString() {
        return super.toString() 
            + "\nplaca=" + placa
            + "\ncor=" + cor + "\n";
    }

    public static Carro getCarroById(int id) throws Exception {
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        throw new Exception("Carro não encontrado");
    }

    public static boolean verificaPlaca(
        Codigo<String, String> placa
    ) throws Exception {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                throw new Exception("Placa já existe!");
            }
        }
        return true;
    }

    public static void excluir(int id) throws Exception {
        Carro carro = getCarroById(id);
        carros.remove(carro);
    }
}
