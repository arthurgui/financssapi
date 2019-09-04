package com.financssapi.controller;

import com.financssapi.model.CategoriaRendimento;
import com.financssapi.repository.CategoriaRendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
@RequestMapping("/api/categoria_redimento")
public class CategoriaRendimentoController extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE", "GET", "POST");
    }

    @Autowired
    private CategoriaRendimentoRepository crr;

    @GetMapping("/listar")
    public Page<CategoriaRendimento> listar(Pageable pageable){


        return crr.findAll(pageable);
    }

    @PostMapping("/cadastrar")
    public CategoriaRendimento cadastrar(@RequestBody CategoriaRendimento categoriaRendimento){

        return crr.save(categoriaRendimento);
    }

    @PutMapping("/editar")
    public CategoriaRendimento editar(@RequestBody CategoriaRendimento categoriaRendimento) {

        return crr.save(categoriaRendimento);
    }

    @DeleteMapping("/remover/{id}")
    public void remover(@PathVariable(name = "id") Long id){
        CategoriaRendimento categoriaRendimento = crr.findById(id);
        crr.delete(categoriaRendimento);
    }
}
