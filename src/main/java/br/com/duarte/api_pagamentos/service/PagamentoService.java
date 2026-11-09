package br.com.duarte.api_pagamentos.service;

import br.com.duarte.api_pagamentos.pagamento.FormaPagamento;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagamentoService {
    private final List<FormaPagamento> formasPagamento;

    public PagamentoService(List<FormaPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public String processar(String metodo, BigDecimal valor) {
        FormaPagamento escolhida = formasPagamento.stream()
                .filter(forma -> forma.getCodigo().equalsIgnoreCase(metodo))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Método não encontrado: " + metodo));

        return escolhida.processarPagamento(valor);
    }
}