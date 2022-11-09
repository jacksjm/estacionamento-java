import java.util.ArrayList;

public class Moto extends Veiculo {
    
    private Codigo<String, String> placa;
    private int cilindrada;

    private static ArrayList<Moto> motos = new ArrayList<>();

    public Moto(String nome, String letras, String numeros, int cilindrada) throws Exception{
        super(GetId.getNextId(motos), nome);
        Codigo<String, String> placa = new Codigo<>(letras, numeros);
        verificaPlaca(placa);
        this.placa = placa;
        this.cilindrada = cilindrada;
    }

    public Codigo<String, String> getPlaca() {
        return placa;
    }

    public void setPlaca(Codigo<String, String> placa) {
        this.placa = placa;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public static void setMoto(Moto moto) {
        motos.add(moto);
    }

    public static ArrayList<Moto> getMotos() {
        return motos;
    }

    @Override
    public String toString() {
        return super.toString() 
            + "\nplaca=" + placa
            + "\ncilindrada=" + cilindrada + "\n";
    }

    public static Moto getMotoById(int id) throws Exception {
        for (Moto moto : motos) {
            if (moto.getId() == id) {
                return moto;
            }
        }
        throw new Exception("Moto não encontrada");
    }

    public static boolean verificaPlaca(
        Codigo<String, String> placa
    ) throws Exception {
        for (Moto moto : motos) {
            if (moto.getPlaca().equals(placa)) {
                throw new Exception("Placa já existe!");
            }
        }
        return true;
    }

    public static void excluir(int id) throws Exception {
        Moto moto = getMotoById(id);
        motos.remove(moto);
    }
}
