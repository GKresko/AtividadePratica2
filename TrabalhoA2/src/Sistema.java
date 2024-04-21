import java.util.ArrayList;
import java.util.Scanner;

class Sistema {
    private static ArrayList<Campeonato> listaCampeonatos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean sair = false;

    public static void executarProjeto() {
        System.out.println("Bem-vindo ao sistema de times brasileiros!");

        do {
            exibirMenu();
            int opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    editar();
                    break;
                case 4:
                    excluir();
                    break;
                case 5:
                    listar();
                    break;
                case 6:
                    excluirTodos();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (!sair);
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Cadastrar");
        System.out.println("2. Buscar");
        System.out.println("3. Editar");
        System.out.println("4. Excluir");
        System.out.println("5. Listar");
        System.out.println("6. Excluir todos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, insira um número correspondente à opção do menu.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void cadastrar() {
        System.out.println("Opção de cadastro selecionada.");
        System.out.println("Escolha o tipo de objeto a ser cadastrado:");
        System.out.println("1. Time");
        System.out.println("2. Jogador");
        System.out.println("3. Estádio");
        int opcaoCadastro = scanner.nextInt();
        scanner.nextLine(); 
        switch (opcaoCadastro) {
            case 1:
                cadastrarTime();
                break;
            case 2:
                cadastrarJogador();
                break;
            case 3:
                cadastrarEstadio();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void cadastrarTime() {
        System.out.print("Digite o nome do time: ");
        String nome = scanner.nextLine();
        Time time = new Time(nome);
        listaCampeonatos.add(time);
        System.out.println("Time cadastrado com sucesso!");
    }

    private static void cadastrarJogador() {
        System.out.print("Digite o nome do jogador: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a posição do jogador: ");
        String posicao = scanner.nextLine();
        Jogador jogador = new Jogador(nome, posicao);
        listaCampeonatos.add(jogador);
        System.out.println("Jogador cadastrado com sucesso!");
    }

    private static void cadastrarEstadio() {
        System.out.print("Digite o nome do estádio: ");
        String nome = scanner.nextLine();
        Estadio estadio = new Estadio(nome);
        listaCampeonatos.add(estadio);
        System.out.println("Estádio cadastrado com sucesso!");
    }

    private static void buscar() {
        System.out.println("Opção de busca selecionada.");
        System.out.print("Digite o nome a ser buscado: ");
    String termoBusca = scanner.nextLine();

    boolean encontrado = false;
    for (Campeonato campeonato : listaCampeonatos) {
        if (campeonato instanceof Time) {
            Time time = (Time) campeonato;
            if (time.getNome().equalsIgnoreCase(termoBusca)) {
                System.out.println("Time encontrado: " + time.getNome());
                encontrado = true;
            }
        } else if (campeonato instanceof Jogador) {
            Jogador jogador = (Jogador) campeonato;
            if (jogador.getNome().equalsIgnoreCase(termoBusca)) {
                System.out.println("Jogador encontrado: " + jogador.getNome() + " - Posição: " + jogador.getPosicao());
                encontrado = true;
            }
        } else if (campeonato instanceof Estadio) {
            Estadio estadio = (Estadio) campeonato;
            if (estadio.getNome().equalsIgnoreCase(termoBusca)) {
                System.out.println("Estádio encontrado: " + estadio.getNome());
                encontrado = true;
            }
        }
    }

    if (!encontrado) {
        System.out.println("Nenhum resultado encontrado para \"" + termoBusca + "\".");
    }
    }

    private static void editar() {
        System.out.println("Opção de edição de animal selecionada.");
        System.out.print("Digite o nome do animal a ser editado: ");
    }

    private static void excluir() {
        System.out.println("Opção de exclusão selecionada.");
        System.out.print("Digite o nome do objeto a ser excluído: ");
    String nomeObjeto = scanner.nextLine();

    boolean removido = false;
    for (Campeonato campeonato : listaCampeonatos) {
        if (campeonato instanceof Time) {
            Time time = (Time) campeonato;
            if (time.getNome().equalsIgnoreCase(nomeObjeto)) {
                listaCampeonatos.remove(campeonato);
                System.out.println("Time removido com sucesso!");
                removido = true;
                break;
            }
        } else if (campeonato instanceof Jogador) {
            Jogador jogador = (Jogador) campeonato;
            if (jogador.getNome().equalsIgnoreCase(nomeObjeto)) {
                listaCampeonatos.remove(campeonato);
                System.out.println("Jogador removido com sucesso!");
                removido = true;
                break;
            }
        } else if (campeonato instanceof Estadio) {
            Estadio estadio = (Estadio) campeonato;
            if (estadio.getNome().equalsIgnoreCase(nomeObjeto)) {
                listaCampeonatos.remove(campeonato);
                System.out.println("Estádio removido com sucesso!");
                removido = true;
                break; 
            }
        }
    }

    if (!removido) {
        System.out.println("Nenhum objeto encontrado com o nome \"" + nomeObjeto + "\".");
    }
    }

    private static void listar() {
        System.out.println("Opção de listagem selecionada.");
        if (listaCampeonatos.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            for (Campeonato campeonato : listaCampeonatos) {
                if (campeonato instanceof Time) {
                    Time time = (Time) campeonato;
                    System.out.println("Time: " + time.getNome());
                } else if (campeonato instanceof Jogador) {
                    Jogador jogador = (Jogador) campeonato;
                    System.out.println("Jogador: " + jogador.getNome() + " - Posição: " + jogador.getPosicao());
                } else if (campeonato instanceof Estadio) {
                    Estadio estadio = (Estadio) campeonato;
                    System.out.println("Estádio: " + estadio.getNome());
                }
            }
        }
    }

    private static void excluirTodos() {
        listaCampeonatos.clear();
        System.out.println("Todos os objetos foram excluídos da lista.");
    }
}