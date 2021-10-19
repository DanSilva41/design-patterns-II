package br.com.alura.loja;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.OrcamentoComplexo;
import br.com.alura.loja.orcamento.OrcamentoProxy;

import java.math.BigDecimal;

public class TesteComposicao {

    public static void main(String[] args) {
        OrcamentoComplexo antigo = new OrcamentoComplexo();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
        antigo.reprovar();

        OrcamentoComplexo novo = new OrcamentoComplexo();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        novo.adicionarItem(antigo);

        OrcamentoProxy orcamentoProxy = new OrcamentoProxy(novo);
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());
        System.out.println(orcamentoProxy.getValor());

    }
}
