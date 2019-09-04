package com.financssapi.repository;

import com.financssapi.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta findById(Long id);

    @Query("select sum (c.valor) from Conta c")
    float getValorTotal();
}
