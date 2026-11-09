package br.com.duarte.api_pagamentos.pagamento;

import java.math.BigDecimal;

public interface FormaPagamento {
    String processarPagamento(BigDecimal valor);

    String codigo();

    String getCodigo();
}
