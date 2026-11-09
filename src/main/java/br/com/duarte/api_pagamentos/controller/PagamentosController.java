package br.com.duarte.api_pagamentos.controller;

import br.com.duarte.api_pagamentos.dto.PagamentosRequest;
import br.com.duarte.api_pagamentos.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentosController {

    private final PagamentoService pagamentoService;

    public PagamentosController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/pagamentos")
    public String criarPagamento(
            @Valid @RequestBody PagamentosRequest pedido
    ) {
        return pagamentoService.processar(
                pedido.metodoPagamento(),
                pedido.valor()
        );
    }
}
