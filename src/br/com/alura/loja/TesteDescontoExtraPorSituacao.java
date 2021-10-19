package br.com.alura.loja;

import br.com.alura.loja.orcamento.OrcamentoSimples;

import java.math.BigDecimal;

public class TesteDescontoExtraPorSituacao {

    private static final System.Logger log = System.getLogger("TesteDescontoExtraPorSituacao");

    public static void main(String[] args) {
        OrcamentoSimples orcamentoSimples = new OrcamentoSimples(new BigDecimal("100"), 2);
        log.log(System.Logger.Level.INFO, orcamentoSimples);

        orcamentoSimples.aprovar();
        log.log(System.Logger.Level.INFO, orcamentoSimples);

        orcamentoSimples.aplicarDescontoExtra();

        orcamentoSimples.finalizar();
        log.log(System.Logger.Level.INFO, orcamentoSimples);
    }
}
