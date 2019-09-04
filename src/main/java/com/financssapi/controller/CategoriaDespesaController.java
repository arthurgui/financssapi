package com.financssapi.controller;

import com.financssapi.model.CategoriaDespesa;
import com.financssapi.repository.CategoriaDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
@RequestMapping("/api/categoria_despesa")
public class CategoriaDespesaController extends WebMvcConfigurerAdapter implements ModeloCrud<CategoriaDespesa> {

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
    private CategoriaDespesaRepository cdr;

    @Override
    @GetMapping(SLASH + PATH_LISTAR)
    public List<CategoriaDespesa> listar() {

        return cdr.findAll();
    }

    @Override
    @PostMapping(SLASH + PATH_CADASTRAR)
    public CategoriaDespesa cadastrar(@RequestBody CategoriaDespesa obj) {

        return cdr.save(obj);
    }

    @Override
    @PutMapping(SLASH + PATH_EDITAR)
    public CategoriaDespesa editar(@RequestBody CategoriaDespesa obj) {

        return cdr.save(obj);
    }

    @Override
    @DeleteMapping(SLASH + PATH_REMOVER + SLASH + "{id}")
    public void remover(@PathVariable(name = "id") Long id) {

        cdr.delete(cdr.findById(id));
    }

    @Override
    @GetMapping(SLASH + PATH_PAGINAR)
    public Page<CategoriaDespesa> paginar(Pageable pageable) {

        return cdr.findAll(pageable);
    }

}
