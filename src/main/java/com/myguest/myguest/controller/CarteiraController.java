package com.myguest.myguest.controller;

import com.myguest.myguest.model.Carteira;
import com.myguest.myguest.model.DTO.CarteiraDTO;
import com.myguest.myguest.service.CarteiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carteira")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CarteiraController {

    private final CarteiraService carteiraService;

    @GetMapping("{userId}/filter/{filter}")
    public ResponseEntity<List<Carteira>> findUserCarteiras(@PathVariable("userId") Long userId,
                                                            @PathVariable("filter") Long filter) {
        return new ResponseEntity<>(carteiraService.findAllCarteiras(userId, filter), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createCarteira(@RequestBody Carteira carteira) {
        carteiraService.createCarteira(carteira);
        return new ResponseEntity<>("Carteira Criada Com Sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("{carteiraId}")
    public ResponseEntity<?> delete(@PathVariable("carteiraId") Long carteiraId) {
        carteiraService.delete(carteiraId);
        return new ResponseEntity<>("Carteira Excluida Com Sucesso!", HttpStatus.OK);
    }

    @PutMapping("{userId}/{carteiraId}")
    public ResponseEntity<?> update(@PathVariable("userId") Long userId,
                                    @PathVariable("carteiraId") Long carteiraId,
                                    @RequestBody CarteiraDTO dto) {
        carteiraService.updateCarteira(carteiraId, userId, dto);
        return new ResponseEntity<>("Carteira Excluida Com Sucesso!", HttpStatus.OK);
    }
}
