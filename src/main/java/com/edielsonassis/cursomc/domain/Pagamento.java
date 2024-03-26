package com.edielsonassis.cursomc.domain;

import java.io.Serializable;

import com.edielsonassis.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

    @Id
    private Integer id;
    private Integer estado;

    @JsonIgnore
    @JoinColumn(name = "pedido_id")
    @OneToOne
    @MapsId // indica que pagamento terá o mesmo ID do pedido
    private Pedido pedido;

    protected Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado.getCod();
        this.pedido = pedido;
    }

    public EstadoPagamento getTipo() {
        return EstadoPagamento.toEnum(estado);
    }

    public void setTipo(EstadoPagamento estado) {
        this.estado = estado.getCod();
    }
}