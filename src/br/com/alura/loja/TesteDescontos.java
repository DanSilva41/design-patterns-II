package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.orcamento.OrcamentoSimples;

import java.math.BigDecimal;

public class TesteDescontos {

    public static void main(String[] args) {
        OrcamentoSimples primeiroOrcamentoSimples = new OrcamentoSimples(new BigDecimal("200"), 6);
        OrcamentoSimples segundoOrcamentoSimples = new OrcamentoSimples(new BigDecimal("1000"), 1);

        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();
        System.out.println(calculadoraDeDescontos.calcular(primeiroOrcamentoSimples));
        System.out.println(calculadoraDeDescontos.calcular(segundoOrcamentoSimples));

    }
}
