package com.myguest.myguest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "email_usuario")
    private String emailUsuario;

    @Column(name = "senha_usuario")
    private String senhaUsuario;

    @Column(name = "moeda_padrao")
    private Long moedaPadrao;

    @Column(name = "avatar_usuario")
    private byte[] userAvatar;

    @Column(name = "data_registro")
    private LocalDateTime dataRegistro;

}
