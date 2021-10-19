package br.com.alura.loja.imposto;

import br.com.alura.loja.orcamento.OrcamentoSimples;

import java.math.BigDecimal;

public class CalculadoraDeImpostos {

    public BigDecimal calcular(OrcamentoSimples orcamentoSimples, Imposto imposto) {
        return imposto.calcular(orcamentoSimples);
    }
}
