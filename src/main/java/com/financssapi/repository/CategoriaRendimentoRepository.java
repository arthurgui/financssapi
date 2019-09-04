package com.financssapi.repository;

import com.financssapi.model.CategoriaRendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRendimentoRepository extends JpaRepository<CategoriaRendimento, Long> {

    CategoriaRendimento findById(Long id);
}
