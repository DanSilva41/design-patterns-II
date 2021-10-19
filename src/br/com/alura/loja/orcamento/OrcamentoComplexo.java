package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrcamentoComplexo extends Orcamento implements Orcavel {

    private List<Orcavel> itens;

    public OrcamentoComplexo() {
        this.valor = BigDecimal.ZERO;
        this.situacao = new EmAnalise();
        this.itens = new ArrayList<>();
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

    public boolean isFinalizado() {
        return situacao instanceof Finalizado;
    }

    public void adicionarItem(Orcavel item) {
        this.valor = valor.add(item.getValor());
        this.itens.add(item);
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public void setSituacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    @Override
    public int getQuantidadeItens() {
        return itens.size();
    }

    @Override
    public String toString() {
        return "Orcamento: \n" +
                "\tvalor = " + valor +
                ", \n\tquantidadeItens = " + itens.size() +
                ", \n\tsituacao = " + situacao.getNome();
    }

}
