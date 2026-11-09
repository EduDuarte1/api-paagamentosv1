package br.com.duarte.api_pagamentos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record PagamentosRequest(
        @NotNull @Positive BigDecimal valor,
        @NotBlank String metodoPagamento
) {}