package com.edielsonassis.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoPagamento {
    
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    public static EstadoPagamento toEnum(Integer id) {
        if (id == null) {
            return null;
        }

        for (EstadoPagamento estado : EstadoPagamento.values()) {
            if (id.equals(estado.getCod())) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Id inválido " + id);
    }
}