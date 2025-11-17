public class SistemaFilas {

    public static void main(String[] args) throws InterruptedException {

        Fila fila = new Fila(10);

        Produtor produtor1 = new Produtor(fila);
        Produtor produtor2 = new Produtor(fila);

        Consumidor consumidor1 = new Consumidor(fila);
        Consumidor consumidor2 = new Consumidor(fila);

        produtor1.setName("P1");
        produtor2.setName("P2");
        consumidor1.setName("C1");
        consumidor2.setName("C2");

        produtor1.start();
        produtor2.start();
        consumidor1.start();
        consumidor2.start();

        Thread.sleep(20000);

        System.exit(0);
    }
}