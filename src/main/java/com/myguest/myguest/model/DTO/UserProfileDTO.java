package com.myguest.myguest.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserProfileDTO implements Serializable {

    private Long idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private Long moedaPadrao;
    private String userAvatar;
    private LocalDateTime dataRegistro;
}
