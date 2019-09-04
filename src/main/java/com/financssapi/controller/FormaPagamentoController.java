package com.financssapi.controller;

import com.financssapi.model.FormaPagamento;
import com.financssapi.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
@RequestMapping("/api/formas_pagamento")
public class FormaPagamentoController extends WebMvcConfigurerAdapter implements ModeloCrud<FormaPagamento> {

    private static final String SLASH = "/";
    private static final String PATH_LISTAR = "listar";
    private static final String PATH_CADASTRAR = "cadastrar";
    private static final String PATH_EDITAR = "editar";
    private static final String PATH_REMOVER = "remover";
    private static final String PATH_PAGINAR = "paginar";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE", "GET", "POST");
    }

    @Autowired
    private FormaPagamentoRepository fpr;


    @Override
    @GetMapping(SLASH + PATH_LISTAR)
    public List<FormaPagamento> listar() {

        return fpr.findAll();
    }

    @Override
    @PostMapping(SLASH + PATH_CADASTRAR)
    public FormaPagamento cadastrar(@RequestBody FormaPagamento formaPagamento) {

        return fpr.save(formaPagamento);
    }

    @Override
    @PutMapping(SLASH + PATH_EDITAR)
    public FormaPagamento editar(@RequestBody FormaPagamento formaPagamento) {

        return fpr.save(formaPagamento);
    }

    @Override
    @DeleteMapping(SLASH + PATH_REMOVER + SLASH + "{id}")
    public void remover(@PathVariable(name = "id") Long id) {

        fpr.delete(id);
    }

    @Override
    @GetMapping(SLASH + PATH_PAGINAR)
    public Page<FormaPagamento> paginar(Pageable pageable) {

        return fpr.findAll(pageable);
    }
}
