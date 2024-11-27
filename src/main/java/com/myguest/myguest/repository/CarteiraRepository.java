package com.myguest.myguest.repository;

import com.myguest.myguest.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    Optional<List<Carteira>> findAllByUsuarioIdAndDataGeracaoAfter(Long usuarioId, LocalDateTime dataGeracao);

    Optional<List<Carteira>> findAllByUsuarioId(Long usuarioId);

}
