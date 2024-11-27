package com.myguest.myguest.controller;

import com.myguest.myguest.model.Moeda;
import com.myguest.myguest.service.MoedasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("moedas")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class MoedasController {

    private final MoedasService moedasService;

    @GetMapping("get-all")
    public ResponseEntity<List<Moeda>> getAll() {
        return new ResponseEntity<>(moedasService.getAll(), HttpStatus.OK);
    }
}
