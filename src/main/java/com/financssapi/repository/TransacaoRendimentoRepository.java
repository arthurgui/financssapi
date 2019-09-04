package com.financssapi.repository;

import com.financssapi.model.DataPesquisa;
import com.financssapi.model.TransacaoRendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransacaoRendimentoRepository extends JpaRepository<TransacaoRendimento, Long> {

    TransacaoRendimento findById(Long id);

    List<TransacaoRendimento> findAllByDtLancamentoBetween(@Param("datInicio") Date dataInicio, @Param("datFim")Date dataFim);

    List<TransacaoRendimento> findAllByDtLancamento(@Param("datInicio") Date data);
}
