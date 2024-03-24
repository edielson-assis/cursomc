package com.edielsonassis.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    public static TipoCliente toEnum(Integer id) {
        if (id == null) {
            return null;
        }

        for (TipoCliente tipo : TipoCliente.values()) {
            if (id.equals(tipo.getCod())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Id inválido " + id);
    }
}