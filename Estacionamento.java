import java.util.Scanner;

public class Estacionamento {
    public static void main(String[] args) {
        System.out.println("Estacionamento");
        System.out.println("==============");
        System.out.println("1 - Cadastrar veículo");
        System.out.println("2 - Cadastrar vaga");
        System.out.println("3 - Cadastrar locação");
        System.out.println("4 - Listar veículos");
        System.out.println("5 - Listar vagas");
        System.out.println("6 - Listar locações");
        System.out.println("7 - Excluir veículo");
        System.out.println("8 - Excluir vaga");
        System.out.println("9 - Excluir locação");
        System.out.println("0 - Sair");
        System.out.println("==============");
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        do {
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    System.out.println("Cadastrar veículo");
                    System.out.println("==============");
                    System.out.print("Tipo: ");
                    char tipo = scanner.next().charAt(0);
                    switch (tipo) {
                        case 'C':
                            criarCarro(scanner);
                            break;
                        
                        case 'M':
                            criarMoto(scanner);
                            break;

                        case 'B':
                            criarBicicleta(scanner);
                            break;
                        default:
                            break;
                    }
                    
                    break;
                case 2:
                    System.out.println("Cadastrar vaga");
                    System.out.println("==============");
                    criarVaga(scanner);
                    break;
                case 3:
                    System.out.println("Cadastrar locação");
                    System.out.println("==============");
                    criarLocacao(scanner);
                    break;
                case 4:
                    System.out.println("Listar veículos");
                    System.out.println("==============");
                    listarCarro();
                    listarMoto();
                    listarBicicleta();
                    break;
                case 5:
                    listarVaga();
                    break;
                case 6:
                    listarLocacao();
                    break;
                case 7:
                    System.out.println("Excluir veículo");
                    System.out.println("==============");
                    char tipoExcluir = scanner.next().charAt(0);
                    switch (tipoExcluir) {
                        case 'C':
                            excluirCarro(scanner);
                            break;
                        
                        case 'M':
                            excluirMoto(scanner);
                            break;

                        case 'B':
                            excluirBicicleta(scanner);
                            break;
                        default:
                            break;
                    }
                    break;
                case 8:
                    System.out.println("Excluir vaga");
                    System.out.println("==============");
                    excluirVaga(scanner);
                    break;
                case 9:
                    System.out.println("Excluir locação");
                    System.out.println("==============");
                    excluirLocacao(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default: 
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }

    public static void criarVaga(Scanner scanner) {
        try {
            System.out.print("Setor: ");
            char setor = scanner.next().charAt(0);
            System.out.print("Número: ");
            int numero = scanner.nextInt();
            System.out.print("Tipo: ");
            char tipo = scanner.next().charAt(0);
            if (tipo != 'C' && tipo != 'M' && tipo != 'B') {
                throw new Exception("Tipo inválido!");
            }
            System.out.println("Tamanho: ");
            double tamanho = scanner.nextDouble();
            System.out.println("Valor: ");
            double valor = scanner.nextDouble();
            new Vaga(setor, numero, tipo, tamanho, valor);
            System.out.println("Vaga criada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void criarCarro(Scanner scanner) {
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Letras da Placa: ");
        String letras = scanner.next();
        if (letras.length() != 3) {
            System.out.println("Letras da placa inválidas!");
            return;
        }
        System.out.println("Números da Placa: ");
        String numeros = scanner.next();
        if (numeros.length() != 4) {
            System.out.println("Números da placa inválidos!");
            return;
        }
        System.out.println("Cor: ");
        String cor = scanner.next();

        try {
            new Carro(nome, letras, numeros, cor);
            System.out.println("Carro criado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void criarMoto(Scanner scanner) {
        System.out.println("Nome: ");
        String nome = scanner.next();
        String letras = scanner.next();
        if (letras.length() != 3) {
            System.out.println("Letras da placa inválidas!");
            return;
        }
        System.out.println("Números da Placa: ");
        String numeros = scanner.next();
        if (numeros.length() != 4) {
            System.out.println("Números da placa inválidos!");
            return;
        }
        System.out.println("Cilindrada: ");
        int cc = scanner.nextInt();
        try {
            new Moto(nome, letras, numeros, cc);
            System.out.println("Moto criada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void criarBicicleta(Scanner scanner) {
        System.out.println("Nome: ");
        String nome = scanner.next();
        System.out.println("Marca: ");
        String marca = scanner.next();
        System.out.println("Cor: ");
        String cor = scanner.next();
        new Bicicleta(nome, marca, cor);
        System.out.println("Bicicleta criada com sucesso!");
    }

    public static void criarLocacao(Scanner scanner) {
        try {
            System.out.println("Data: ");
            String data = scanner.next();
            System.out.println("Id da Vaga: ");
            int idVaga = scanner.nextInt();
            Vaga vaga = Vaga.getVagaById(idVaga);
            System.out.println("Id do Veículo: ");
            int idVeiculo = scanner.nextInt();
            Veiculo veiculo;
            if (vaga.getTipo() == 'C') {
                veiculo = Carro.getCarroById(idVeiculo);
            } else if (vaga.getTipo() == 'M') {
                veiculo = Moto.getMotoById(idVeiculo);
            } else {
                veiculo = Bicicleta.getBicicletaById(idVeiculo);
            }
            new Locacao(data, veiculo, vaga);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
    
    public static void listarVaga() {
        System.out.println("Listar vagas");
        System.out.println("==============");
        for (Vaga vaga : Vaga.getVagas()) {
            System.out.println(vaga);
        }
    }

    public static void listarCarro() {
        System.out.println("Carros");
        System.out.println("==============");
        for (Carro carro : Carro.getCarros()) {
            System.out.println(carro);
        }
    }

    public static void listarMoto() {
        System.out.println("Motos");
        System.out.println("==============");
        for (Moto moto : Moto.getMotos()) {
            System.out.println(moto);
        }
    }

    public static void listarBicicleta() {
        System.out.println("Bicicletas");
        System.out.println("==============");
        for (Bicicleta bicicleta : Bicicleta.getBicicletas()) {
            System.out.println(bicicleta);
        }
    }

    public static void listarLocacao() {
        System.out.println("Listar locações");
        System.out.println("==============");
        for (Locacao locacao : Locacao.getLocacoes()) {
            System.out.println(locacao);
        }
    }

    public static void excluirVaga(Scanner scanner) {
        try {
            System.out.println("Id: ");
            int id = scanner.nextInt();
            Vaga.excluir(id);
            System.out.println("Vaga excluída com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirCarro(Scanner scanner) {
        try {
            System.out.println("Id: ");
            int id = scanner.nextInt();
            Carro.excluir(id);
            System.out.println("Carro excluído com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirMoto(Scanner scanner) {
        try {
            System.out.println("Id: ");
            int id = scanner.nextInt();
            Moto.excluir(id);
            System.out.println("Moto excluída com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirBicicleta(Scanner scanner) {
        try {
            System.out.println("Id: ");
            int id = scanner.nextInt();
            Bicicleta.excluir(id);
            System.out.println("Bicicleta excluída com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void excluirLocacao(Scanner scanner) {
        try {
            System.out.println("Id: ");
            int id = scanner.nextInt();
            Locacao.excluir(id);
            System.out.println("Locação excluída com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
