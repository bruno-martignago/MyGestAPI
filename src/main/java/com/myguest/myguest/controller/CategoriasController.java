package com.myguest.myguest.controller;

import com.myguest.myguest.model.Categorias;
import com.myguest.myguest.model.DTO.CategoriaDTO;
import com.myguest.myguest.service.CategoriasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CategoriasController {

    private final CategoriasService categoriasService;

    @GetMapping("{userId}")
    public ResponseEntity<List<Categorias>> findUserCategorias(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(categoriasService.findUserCategories(userId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> cadastrarCategoria(@RequestBody Categorias categorias) {
        categoriasService.saveCategoria(categorias);
        return new ResponseEntity<>("Categoria salva com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("{categoriaId}")
    public ResponseEntity<?> updateCategoria(@RequestBody CategoriaDTO dto,
                                             @PathVariable("categoriaId") Long catId) {
        categoriasService.updateCategoria(catId, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{categoriaId}")
    public ResponseEntity<?> deleteCategoria(@PathVariable("categoriaId") Long categoriaId) {
        categoriasService.delete(categoriaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
