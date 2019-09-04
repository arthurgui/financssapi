package com.financssapi.controller;

import com.financssapi.model.Conta;
import com.financssapi.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
@RequestMapping("/api/conta")
public class ContaController extends WebMvcConfigurerAdapter implements ModeloCrud<Conta> {

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
    private ContaRepository cr;

    @Override
    @GetMapping(SLASH + PATH_LISTAR)
    public List<Conta> listar() {

        return cr.findAll();
    }

    @Override
    @PostMapping(SLASH + PATH_CADASTRAR)
    public Conta cadastrar(@RequestBody Conta conta) {

        return cr.save(conta);
    }

    @Override
    @PutMapping(SLASH + PATH_EDITAR)
    public Conta editar(@RequestBody Conta conta) {

        return cr.save(conta);
    }

    @Override
    @DeleteMapping(SLASH + PATH_REMOVER + SLASH + "{id}")
    public void remover(@PathVariable(name = "id") Long id) {
        cr.delete(cr.findById(id));
    }

    @Override
    @GetMapping(SLASH + PATH_PAGINAR)
    public Page<Conta> paginar(Pageable pageable) {

        return cr.findAll(pageable);
    }

    @GetMapping(SLASH + "/valor_total")
    public float valorTotal() {

        return cr.getValorTotal();
    }
}
