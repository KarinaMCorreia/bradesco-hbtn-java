public class ContaBancariaControlada extends ContaBancariaBasica {

    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual,
                                   double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        // calcula com base no saldo atual
        double tarifa = calcularTarifaMensal();
        double juros = calcularJurosMensal();
        double novoSaldo = getSaldo() - tarifa + juros;

        if (novoSaldo < saldoMinimo) {
            novoSaldo -= valorPenalidade;
        }

        setSaldo(novoSaldo);
    }
}