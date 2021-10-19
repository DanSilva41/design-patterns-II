package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.OrcamentoSimples;

import java.time.LocalDateTime;

public class Pedido {

    private String cliente;
    private LocalDateTime data;
    private OrcamentoSimples orcamentoSimples;

    public Pedido(String cliente, LocalDateTime data, OrcamentoSimples orcamentoSimples) {
        this.cliente = cliente;
        this.data = data;
        this.orcamentoSimples = orcamentoSimples;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public OrcamentoSimples getOrcamento() {
        return orcamentoSimples;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente='" + cliente + '\'' +
                ", data=" + data +
                ", orcamento=" + orcamentoSimples +
                '}';
    }
}
