package br.com.duarte.api_pagamentos.pagamento;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PagamentoCartao implements FormaPagamento {
    @Override
    public String processarPagamento(BigDecimal valor) {
        return "Processando pagamento via cartão no valor de: " + valor;
    }

    @Override
    public String codigo() {
        return getCodigo();
    }

    @Override
    public String getCodigo() {
        return "CARTAO";
    }
}
