package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.OrcamentoSimples;

import java.math.BigDecimal;

public class ISS extends Imposto {

    public ISS() {
        super(null);
    }

    public ISS(Imposto outroImposto) {
        super(outroImposto);
    }

    @Override
    public BigDecimal realizarCalculo(OrcamentoSimples orcamentoSimples) {
        return orcamentoSimples.getValor().multiply(new BigDecimal("0.06"));
    }
}
