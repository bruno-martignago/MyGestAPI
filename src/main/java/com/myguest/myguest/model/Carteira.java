package com.myguest.myguest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="carteira")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Carteira implements Serializable {

    @Column(name = "id_carteira")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarteira;

    @Column(name="descricao_carteira")
    private String descricaoCarteira;

    @Column(name = "tipo_carteira")
    private String tipoCarteira;

    @Column(name = "categoria_carteira")
    private Long catCarteira;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "valor_carteira")
    private BigDecimal valor;

    @Column(name = "data_geracao")
    private LocalDateTime dataGeracao;
}
