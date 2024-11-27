package com.myguest.myguest.controller;

import com.myguest.myguest.model.DTO.UserDTO;
import com.myguest.myguest.model.DTO.UserProfileDTO;
import com.myguest.myguest.model.Usuario;
import com.myguest.myguest.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<Usuario> createUser(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(usuarioService.createUser(dto), HttpStatus.CREATED);
    }

    @GetMapping("{email}/{senha}")
    public ResponseEntity<Usuario> loginUser(@PathVariable("email") String email,
                                             @PathVariable("senha") String senha) {
        return new ResponseEntity<>(usuarioService.loginUser(email, senha), HttpStatus.OK);
    }

    @GetMapping("find-by-id/{userId}")
    public ResponseEntity<UserProfileDTO> findById(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(usuarioService.findById(userId), HttpStatus.OK);
    }

    @PutMapping("update-user/{userId}")
    public ResponseEntity<?> alterUser(@RequestBody UserProfileDTO dto,
                                                    @PathVariable("userId") Long userId) {
        usuarioService.update(dto, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
