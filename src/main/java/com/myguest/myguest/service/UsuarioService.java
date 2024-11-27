package com.myguest.myguest.service;

import com.myguest.myguest.model.DTO.UserDTO;
import com.myguest.myguest.model.DTO.UserProfileDTO;
import com.myguest.myguest.model.Usuario;
import com.myguest.myguest.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UserProfileDTO findById(Long userId) {
        Usuario user = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        return new UserProfileDTO(
                user.getIdUsuario(),
                user.getNomeUsuario(),
                user.getEmailUsuario(),

                user.getMoedaPadrao() != null
                        ? user.getMoedaPadrao()
                        : null,

                user.getUserAvatar() != null
                        ? Base64.getMimeEncoder().encodeToString(user.getUserAvatar())
                        : null,

                user.getDataRegistro()
        );
    }

    public Usuario createUser(UserDTO usuarioDto) {
        Usuario usuario = new Usuario();
        var senhaFormatted = Base64.getEncoder().encodeToString(usuarioDto.getSenha().getBytes());

        if (usuarioDto.getSenha().length() < 6)
            throw new RuntimeException("Senha curta demais!");

        if (userAlreadyExists(usuarioDto.getEmail(), senhaFormatted))
            throw new RuntimeException("Usuario já cadastrado!");

        usuario.setNomeUsuario(usuarioDto.getNome());
        usuario.setEmailUsuario(usuarioDto.getEmail());
        usuario.setSenhaUsuario(senhaFormatted);
        usuario.setDataRegistro(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }

    private boolean userAlreadyExists(String email, String senha) {
        Usuario user = usuarioRepository.findByEmailUsuarioAndSenhaUsuario(email, senha).orElse(null);
        return user != null;
    }

    public Usuario loginUser(String email, String senha) {
        var senhaFormatted = Base64.getEncoder().encodeToString(senha.getBytes());

        Usuario user = usuarioRepository.findByEmailUsuarioAndSenhaUsuario(email, senhaFormatted).orElse(null);

        if (user != null)
            return user;

        throw new RuntimeException("Usuario não encontrado, verifique suas Credenciais!");
    }

    public void update(UserProfileDTO dto, Long userId) {
        Usuario user = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        user.setNomeUsuario(dto.getNomeUsuario());
        user.setEmailUsuario(dto.getEmailUsuario());

        if (dto.getMoedaPadrao() != null)
            user.setMoedaPadrao(dto.getMoedaPadrao());

        if (dto.getUserAvatar() != null)
            user.setUserAvatar(Base64.getMimeDecoder().decode(dto.getUserAvatar()));

        usuarioRepository.save(user);
    }
}
