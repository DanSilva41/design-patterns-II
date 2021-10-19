package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;

public class OrcamentoSimples extends Orcamento {

    private BigDecimal valor;
    private final int quantidadeItens;
    private SituacaoOrcamento situacao;

    public OrcamentoSimples(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacao = new EmAnalise();
    }

    public void aplicarDescontoExtra() {
        BigDecimal valorDoDescontoExtra = this.situacao.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    @Override
    public String toString() {
        return "Orcamento: \n" +
                "\tvalor = " + valor +
                ", \n\tquantidadeItens = " + quantidadeItens +
                ", \n\tsituacao = " + situacao.getNome();
    }

    public boolean isFinalizado() {
        return situacao instanceof Finalizado;
    }
}
