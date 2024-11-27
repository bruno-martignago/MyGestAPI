package com.myguest.myguest.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class CarteiraDTO implements Serializable {
    private String descricao;
    private BigDecimal valor;
    private String categoria;
    private String tipo;
}
