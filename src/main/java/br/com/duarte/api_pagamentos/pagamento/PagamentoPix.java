package br.com.duarte.api_pagamentos.pagamento;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PagamentoPix implements FormaPagamento {
    @Override
    public String processarPagamento(BigDecimal valor) {
        return "Processando pagamento via PIX no valor de: " + valor;
    }

    @Override
    public String codigo() {
        return getCodigo();
    }

    @Override
    public String getCodigo() {
        return "PIX";
    }
}
