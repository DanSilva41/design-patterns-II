package br.com.alura.loja;

import br.com.alura.loja.http.JavaHttpClient;
import br.com.alura.loja.orcamento.OrcamentoSimples;
import br.com.alura.loja.orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;

public class TesteAdapter {

    public static void main(String[] args) {
        OrcamentoSimples orcamentoSimples = new OrcamentoSimples(new BigDecimal("100"), 1);
        orcamentoSimples.aprovar();
        orcamentoSimples.finalizar();

        RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient()); // or new ExternalLibHttpClient()
        registroDeOrcamento.registrar(orcamentoSimples);
    }
}
