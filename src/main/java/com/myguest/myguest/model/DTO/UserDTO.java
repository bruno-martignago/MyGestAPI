package com.myguest.myguest.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserDTO implements Serializable {

    private String email;
    private String senha;
    private String nome;
}
