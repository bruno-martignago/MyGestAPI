package com.myguest.myguest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "moeda")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Moeda implements Serializable {

    @Id
    @Column(name = "id_moeda")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMoeda;

    @Column(name = "nome_moeda")
    private String nomeMoeda;
}
