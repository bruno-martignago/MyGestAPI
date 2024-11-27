package com.myguest.myguest.service;

import com.myguest.myguest.model.Moeda;
import com.myguest.myguest.repository.MoedasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoedasService {

    private final MoedasRepository moedasRepository;
    public List<Moeda> getAll() {
        return moedasRepository.findAll();
    }
}
