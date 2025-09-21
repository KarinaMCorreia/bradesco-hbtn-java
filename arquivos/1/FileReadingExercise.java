import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExercise {

    public static void main(String[] args) {
        String fileName = "exemplo.txt";

        System.out.println("Conteúdo do arquivo 'exemplo.txt':");
        System.out.println();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {

        }

        System.out.println();
        System.out.println("Leitura do arquivo concluída.");
    }
}