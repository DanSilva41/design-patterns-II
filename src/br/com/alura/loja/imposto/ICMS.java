package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.OrcamentoSimples;

import java.math.BigDecimal;

public class ICMS extends Imposto {

    public ICMS() {
        super(null);
    }

    public ICMS(Imposto outroImposto) {
        super(outroImposto);
    }

    @Override
    public BigDecimal realizarCalculo(OrcamentoSimples orcamentoSimples) {
        return orcamentoSimples.getValor().multiply(new BigDecimal("0.1"));
    }
}
