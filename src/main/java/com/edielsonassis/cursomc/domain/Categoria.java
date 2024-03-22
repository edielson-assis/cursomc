package com.edielsonassis.cursomc.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria implements Serializable {
    
    private Integer id;
    private String nome;
}