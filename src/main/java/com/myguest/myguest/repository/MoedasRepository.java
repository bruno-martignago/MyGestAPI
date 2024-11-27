package com.myguest.myguest.repository;

import com.myguest.myguest.model.Moeda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoedasRepository extends JpaRepository<Moeda, Long> {
}
