package br.com.alura.loja.orcamento;

import br.com.alura.loja.exception.DomainException;
import br.com.alura.loja.http.HttpAdapter;

import java.util.Map;

public class RegistroDeOrcamento {

    private final HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(OrcamentoSimples orcamentoSimples) {
        // chamada HTTP para API externa
        // URLConnection
        // Http Client
        // Lib REST
        if (!orcamentoSimples.isFinalizado())
            throw new DomainException("Orcamento ainda não foi finalizado");

        final String url = "https://jsonplaceholder.typicode.com/users/1"; // http://api.externa/orcamento
        final Map<String, Object> dados = Map.of(
                "valor", orcamentoSimples.getValor(),
                "quantidadeDeItens", orcamentoSimples.getQuantidadeItens()
        );
        this.http.post(url, dados);
    }
}
