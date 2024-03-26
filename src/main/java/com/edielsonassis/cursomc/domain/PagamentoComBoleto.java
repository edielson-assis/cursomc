package com.edielsonassis.cursomc.domain;

import java.util.Date;

import com.edielsonassis.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper= true)
@Entity
public class PagamentoComBoleto extends Pagamento {
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataVencimento;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPagamento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}