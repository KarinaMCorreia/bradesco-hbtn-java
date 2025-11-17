import java.util.Random;

public class Produtor extends Thread {

    private final Fila fila;
    private final Random random;

    public Produtor(Fila fila) {
        this.fila = fila;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = random.nextInt(100) + 1; // 1 a 100
                fila.adicionar(numero);
                Thread.sleep(1000); // produz a cada 1 segundo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}