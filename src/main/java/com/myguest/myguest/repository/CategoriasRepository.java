package com.myguest.myguest.repository;

import com.myguest.myguest.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    Optional<List<Categorias>> findAllByUsuarioId(Long usuarioId);

    Optional<Categorias> findByIdCatAndUsuarioId(Long id, Long userId);
}
