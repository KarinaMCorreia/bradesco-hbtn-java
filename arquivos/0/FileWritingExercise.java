import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            while (true) {
                System.out.print("Digite uma linha de texto (ou 'sair' para finalizar): ");
                String linha = scanner.nextLine();
                if ("sair".equalsIgnoreCase(linha.trim())) {
                    break;
                }
                writer.write(linha);
                writer.newLine();
            }
            writer.flush();
            System.out.println("Arquivo \"" + fileName + "\" criado e conteúdo salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}