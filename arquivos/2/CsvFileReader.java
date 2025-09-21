import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {

    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    // ignora linha em branco (inclusive a do final do arquivo)
                    continue;
                }

                String[] colunas = linha.split(",", -1);

                System.out.println("Funcionário: " + colunas[0]);
                System.out.println("Idade: " + colunas[1]);
                System.out.println("Departamento: " + colunas[2]);
                System.out.println("Salarial: " + colunas[3]);
                System.out.println("------------------------");
            }

            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}