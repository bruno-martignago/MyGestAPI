package com.myguest.myguest.repository;

import com.myguest.myguest.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmailUsuarioAndSenhaUsuario(String emailUsuario, String senhaUsuario);
}
