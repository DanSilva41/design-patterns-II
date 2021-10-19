package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.OrcamentoSimples;

import java.math.BigDecimal;

public abstract class Imposto {

    private final Imposto outroImposto;

    protected Imposto(Imposto outroImposto) {
        this.outroImposto = outroImposto;
    }

    protected abstract BigDecimal realizarCalculo(OrcamentoSimples orcamentoSimples);

    public BigDecimal calcular(OrcamentoSimples orcamentoSimples) {
        BigDecimal valorImposto = realizarCalculo(orcamentoSimples);
        BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
        if (outroImposto != null)
            valorDoOutroImposto = outroImposto.realizarCalculo(orcamentoSimples);

        return valorImposto.add(valorDoOutroImposto);
    }
}
