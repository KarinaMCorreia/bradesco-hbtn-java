import java.util.LinkedList;
import java.util.Queue;

public class Fila {

    private final Queue<Integer> fila;
    private final int capacidade;

    public Fila(int capacidade) {
        this.fila = new LinkedList<>();
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait();
        }

        fila.add(item);
        System.out.println("Produtor " + Thread.currentThread().getName()
                + " produziu: " + item);
        notifyAll();
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait();
        }

        int item = fila.remove();
        System.out.println("Consumidor " + Thread.currentThread().getName()
                + " consumiu: " + item);
        notifyAll();

        return item;
    }
}