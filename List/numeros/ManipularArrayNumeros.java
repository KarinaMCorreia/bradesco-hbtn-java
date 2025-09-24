import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> numeros, int numero) {
        int idx = numeros.indexOf(numero);
        return idx >= 0 ? idx : -1;
    }

    public static void adicionarNumero(List<Integer> numeros, int numero) {
        if (buscarPosicaoNumero(numeros, numero) != -1) {
            throw new IllegalArgumentException("Numero jah contido na lista");
        }
        numeros.add(numero);
    }

    public static void removerNumero(List<Integer> numeros, int numero) {
        int idx = buscarPosicaoNumero(numeros, numero);
        if (idx == -1) {
            throw new IllegalArgumentException("Numero nao encontrado na lista");
        }
        numeros.remove(idx);
    }

    public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) {
        int idx = buscarPosicaoNumero(numeros, numeroSubstituir);
        if (idx == -1) {

            numeros.add(numeroSubstituto);
        } else {

            numeros.set(idx, numeroSubstituto);
        }
    }
}