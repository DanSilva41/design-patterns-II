package br.com.alura.loja.orcamento.situacao;

import br.com.alura.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {
    public Reprovado() {
        super("Reprovado");
    }

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }
}
