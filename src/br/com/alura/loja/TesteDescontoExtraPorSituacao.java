package br.com.alura.loja;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteDescontoExtraPorSituacao {

    private static final System.Logger log = System.getLogger("TesteDescontoExtraPorSituacao");

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 2);
        log.log(System.Logger.Level.INFO, orcamento);

        orcamento.aprovar();
        log.log(System.Logger.Level.INFO, orcamento);

        orcamento.aplicarDescontoExtra();

        orcamento.finalizar();
        log.log(System.Logger.Level.INFO, orcamento);
    }
}
