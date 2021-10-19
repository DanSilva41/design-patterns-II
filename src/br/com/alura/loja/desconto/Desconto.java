package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {

    private final Desconto proximo;

    protected Desconto(Desconto proximo) {
        this.proximo = proximo;
    }

    public BigDecimal calcular(Orcamento orcamentoSimples) {
        if (deveAplicar(orcamentoSimples))
            return efetuarCalculo(orcamentoSimples);
        return proximo.calcular(orcamentoSimples);
    }

    protected abstract BigDecimal efetuarCalculo(Orcamento orcamentoSimples);

    protected abstract boolean deveAplicar(Orcamento orcamentoSimples);
}

