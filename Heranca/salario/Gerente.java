public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (!departamento.alcancouMeta()) {
            return 0.0;
        }
        double bonusBase = salarioFixo * 0.20;
        double diferenca = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
        double adicional = 0.01 * diferenca;
        return bonusBase + adicional;
    }
}