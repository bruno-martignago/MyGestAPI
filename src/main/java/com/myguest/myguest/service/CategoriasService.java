package com.myguest.myguest.service;

import com.myguest.myguest.model.Categorias;
import com.myguest.myguest.model.DTO.CategoriaDTO;
import com.myguest.myguest.repository.CategoriasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;

    public List<Categorias> findUserCategories(Long userId) {
        return categoriasRepository.findAllByUsuarioId(userId).orElse(new ArrayList<>());
    }


    public void saveCategoria(Categorias categorias) {
        categoriasRepository.save(categorias);
    }

    public void updateCategoria(Long catId, CategoriaDTO dto) {
        Categorias categorias = categoriasRepository.findById(catId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        if (!dto.getNome().isBlank())
            categorias.setNomeCat(dto.getNome());

        if (!dto.getDescricao().isBlank())
            categorias.setDescricaoCat(dto.getDescricao());

        categoriasRepository.save(categorias);
    }

    public void delete(Long catId) {
        categoriasRepository.deleteById(catId);
    }
}
