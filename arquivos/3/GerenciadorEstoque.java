import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorEstoque {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque("estoque.csv");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite a quantidade: ");
                    int quantidade;
                    try {
                        quantidade = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Quantidade inválida!");
                        scanner.nextLine();
                        break;
                    }

                    System.out.print("Digite o preço: ");
                    double preco;
                    try {
                        preco = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Preço inválido!");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine(); // limpar buffer
                    estoque.adicionarProduto(nome, quantidade, preco);
                    break;

                case 2:
                    System.out.print("Digite o ID do produto a ser excluído: ");
                    int idExcluir;
                    try {
                        idExcluir = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("ID inválido!");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    estoque.excluirProduto(idExcluir);
                    break;

                case 3:
                    System.out.println("Estoque:");
                    estoque.exibirEstoque();
                    break;

                case 4:
                    System.out.print("Digite o ID do produto: ");
                    int idAtualizar;
                    try {
                        idAtualizar = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("ID inválido!");
                        scanner.nextLine();
                        break;
                    }

                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade;
                    try {
                        novaQuantidade = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Quantidade inválida!");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                    estoque.atualizarQuantidade(idAtualizar, novaQuantidade);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}