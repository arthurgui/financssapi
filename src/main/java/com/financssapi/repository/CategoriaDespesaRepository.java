package com.financssapi.repository;

import com.financssapi.model.CategoriaDespesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDespesaRepository extends JpaRepository<CategoriaDespesa, Long> {
    CategoriaDespesa findById(Long id);
}
