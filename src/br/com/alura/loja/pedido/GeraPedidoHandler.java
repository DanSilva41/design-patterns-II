package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.OrcamentoSimples;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;

import java.time.LocalDateTime;
import java.util.List;

public class GeraPedidoHandler {

    private final List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executa(GeraPedido dados) {
        OrcamentoSimples orcamentoSimples = new OrcamentoSimples(dados.getValorOrcamento(), dados.getQuantidadeItens());
        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamentoSimples);

        acoes.forEach(a -> a.executar(pedido));


    }
}
