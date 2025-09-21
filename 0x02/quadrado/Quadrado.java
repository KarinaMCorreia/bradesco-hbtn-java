public class Quadrado {

    public static double area(double lado) {
        if (lado <= 0) {
            // mensagem exatamente como no exemplo (sem ponto final)
            throw new IllegalArgumentException("Lado deve possuir valor positivo");
        }
        return lado * lado;
    }
}