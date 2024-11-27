package com.myguest.myguest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "categorias")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Categorias implements Serializable {

    @Id
    @Column(name = "id_cat")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCat;

    @Column(name = "nome_cat")
    private String nomeCat;

    @Column(name = "descricao_cat")
    private String descricaoCat;

    @Column(name = "usuario_id")
    private Long usuarioId;
}
