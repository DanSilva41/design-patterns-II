package br.com.alura.loja.pedido.acao;

import br.com.alura.loja.pedido.Pedido;

public class SalvarPedidoNoBanco implements AcaoAposGerarPedido {

    @Override
    public void executar(Pedido pedido) {
        System.out.print("Salvando pedido no banco de dados!");
    }
}
