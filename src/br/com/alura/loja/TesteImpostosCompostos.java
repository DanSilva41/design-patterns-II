package br.com.alura.loja;

import br.com.alura.loja.imposto.CalculadoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.OrcamentoSimples;

import java.math.BigDecimal;

public class TesteImpostosCompostos {

    public static void main(String[] args) {
        OrcamentoSimples orcamentoSimples = new OrcamentoSimples(new BigDecimal("100"), 1);

        CalculadoraDeImpostos calculadoraDeImpostos = new CalculadoraDeImpostos();
        System.out.println(calculadoraDeImpostos.calcular(orcamentoSimples, new ISS(new ICMS(null))));

    }
}
