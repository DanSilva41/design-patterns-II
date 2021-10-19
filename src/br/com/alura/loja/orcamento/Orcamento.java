package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;

public abstract class Orcamento {

    protected BigDecimal valor;
    protected SituacaoOrcamento situacao;

    public BigDecimal getValor() {
        return valor;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public abstract int getQuantidadeItens();
}
