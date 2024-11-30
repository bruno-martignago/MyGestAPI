package com.myguest.myguest.service;

import com.myguest.myguest.model.Carteira;
import com.myguest.myguest.model.Categorias;
import com.myguest.myguest.model.DTO.CarteiraDTO;
import com.myguest.myguest.repository.CarteiraRepository;
import com.myguest.myguest.repository.CategoriasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;
    private final CategoriasRepository categoriasRepository;

    public List<Carteira> findAllCarteiras(Long userId, Long filter) {
        if (!filter.equals(0L)) {
            LocalDateTime filterDate = LocalDateTime.now().minusDays(filter);
            return carteiraRepository.findAllByUsuarioIdAndDataGeracaoAfter(userId, filterDate).orElse(new ArrayList<>());
        }

        return carteiraRepository.findAllByUsuarioId(userId).orElse(new ArrayList<>());
    }

    public void createCarteira(Carteira carteira) {
        carteira.setDataGeracao(LocalDateTime.now());
        carteiraRepository.save(carteira);
    }

    public void delete(Long carteiraId) {
        carteiraRepository.deleteById(carteiraId);
    }

    public void updateCarteira(Long carteiraId,Long userId, CarteiraDTO dto) {
        Carteira carteira = carteiraRepository.findById(carteiraId)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada!"));

        if (dto.getCategoria() != null && dto.getCategoria() != 0L) {
            Categorias cat = categoriasRepository.findByIdCatAndUsuarioId(dto.getCategoria(), userId)
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
            carteira.setCatCarteira(cat.getIdCat());
        }

        if (dto.getDescricao() != null && !dto.getDescricao().isBlank())
            carteira.setDescricaoCarteira(dto.getDescricao());

        if (dto.getValor() != null && !dto.getValor().equals(BigDecimal.ZERO))
            carteira.setValor(dto.getValor());

        if (dto.getTipo() != null && !dto.getTipo().isBlank())
            carteira.setTipoCarteira(dto.getTipo());

        carteiraRepository.save(carteira);
    }
}
